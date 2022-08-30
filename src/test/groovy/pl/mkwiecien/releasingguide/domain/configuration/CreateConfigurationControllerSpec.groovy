package pl.mkwiecien.releasingguide.domain.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectWriter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import pl.mkwiecien.releasingguide.config.AppTestConfiguration
import spock.lang.Specification

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static pl.mkwiecien.releasingguide.domain.configuration.ConfigurationFixture.BLOCKED_COLOUR
import static pl.mkwiecien.releasingguide.domain.configuration.ConfigurationFixture.COMPLEX_COLOUR
import static pl.mkwiecien.releasingguide.domain.configuration.ConfigurationFixture.RELEASED_COLOUR

@WebMvcTest(CreateConfigurationController)
@ContextConfiguration(classes = AppTestConfiguration)
class CreateConfigurationControllerSpec extends Specification {

    @Autowired
    private MockMvc mockMvc

    @Autowired
    private ConfigurationRepository repository

    private static ObjectWriter objectWriter

    def 'Should properly save configuration from given request'() {
        given:
            def request = ConfigurationFixture.validConfigurationRequest()

        when:
            def result = mockMvc.perform(MockMvcRequestBuilders.post('/configuration')
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectWriter.writeValueAsString(request)))

        then:
            result
                    .andExpect(status().isOk())
                    .andExpect(jsonPath('$.id').isNotEmpty())

        and:
            repository.count() == 1
            with(repository.findTopByOrderByCreatedDesc().get()) {
                it.id != null
                it.colourPalette.released == RELEASED_COLOUR
                it.colourPalette.complex == COMPLEX_COLOUR
                it.colourPalette.blocked == BLOCKED_COLOUR
            }
    }

    def 'Should properly save configuration when there is already saved one in database'() {
        given:
            def existingConfiguration = ConfigurationFixture.validConfiguration()
            repository.save(existingConfiguration)

        and:
            def request = requestWithNewValues()

        when:
            def result = mockMvc.perform(MockMvcRequestBuilders.post('/configuration')
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectWriter.writeValueAsString(request)))

        then:
            result
                    .andExpect(status().isOk())
                    .andExpect(jsonPath('$.id').isNotEmpty())

        and:
            repository.count() == 2
    }

    def requestWithNewValues() {
        ConfigurationFixture.validConfigurationRequest(
                released: UUID.randomUUID().toString(),
                complex: UUID.randomUUID().toString(),
                blocked: UUID.randomUUID().toString())
    }

    def setupSpec() {
        ObjectMapper mapper = new ObjectMapper()
        objectWriter = mapper.writer().withDefaultPrettyPrinter()
    }

    def setup() {
        cleanup()
    }

    def cleanup() {
        repository.deleteAll()
    }
}
