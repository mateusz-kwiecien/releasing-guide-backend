package pl.mkwiecien.releasingguide.domain.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import pl.mkwiecien.releasingguide.config.AppTestConfiguration
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static pl.mkwiecien.releasingguide.domain.configuration.ConfigurationFixture.BLOCKED_COLOUR
import static pl.mkwiecien.releasingguide.domain.configuration.ConfigurationFixture.COMPLEX_COLOUR
import static pl.mkwiecien.releasingguide.domain.configuration.ConfigurationFixture.RELEASED_COLOUR

@WebMvcTest(GetConfigurationController)
@ContextConfiguration(classes = AppTestConfiguration)
class GetConfigurationControllerSpec extends Specification {

    @Autowired
    private MockMvc mockMvc

    @Autowired
    private ConfigurationRepository repository

    def "should return default configuration when there isn't any in database"() {
        expect:
            mockMvc.perform(get("/configuration")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath('$.id').isNotEmpty())
                    .andExpect(jsonPath('$.created').isNotEmpty())
                    .andExpect(jsonPath('$.colourPalette.released').value('82E0AA'))
                    .andExpect(jsonPath('$.colourPalette.complex').value('F7DC6F'))
                    .andExpect(jsonPath('$.colourPalette.blocked').value('E74C3C'))
    }

    def "should return valid configuration when there is any saved in database"() {
        given:
            def existingConfiguration = ConfigurationFixture.validConfiguration()
            repository.save(existingConfiguration)

        expect:
            mockMvc.perform(get("/configuration")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath('$.id').isNotEmpty())
                    .andExpect(jsonPath('$.created').isNotEmpty())
                    .andExpect(jsonPath('$.colourPalette.released').value(RELEASED_COLOUR))
                    .andExpect(jsonPath('$.colourPalette.complex').value(COMPLEX_COLOUR))
                    .andExpect(jsonPath('$.colourPalette.blocked').value(BLOCKED_COLOUR))
    }

    def setup() {
        cleanup()
    }

    def cleanup() {
        repository.deleteAll()
    }
}
