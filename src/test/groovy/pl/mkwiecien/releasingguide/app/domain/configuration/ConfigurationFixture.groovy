package pl.mkwiecien.releasingguide.app.domain.configuration

import pl.mkwiecien.releasingguide.app.domain.configuration.ColourPalette
import pl.mkwiecien.releasingguide.app.domain.configuration.Configuration
import pl.mkwiecien.releasingguide.app.domain.configuration.ConfigurationRequest

import java.time.Instant

class ConfigurationFixture {
    public static String RELEASED_COLOUR = '138D75'
    public static String COMPLEX_COLOUR = 'F39C12'
    public static String BLOCKED_COLOUR = '922B21'


    static def validConfiguration(Map map = [:]) {
        new Configuration(
                map.id as String ?: UUID.randomUUID().toString(),
                map.colourPalette as ColourPalette ?: validColourPalette(),
                map.created as Instant ?: Instant.now()
        )
    }

    static def validColourPalette(Map map = [:]) {
        new ColourPalette(
                map.released as String ?: RELEASED_COLOUR,
                map.complex as String ?: COMPLEX_COLOUR,
                map.blocked as String ?: BLOCKED_COLOUR
        )
    }

    static def validConfigurationRequest(Map map = [:]) {
        new ConfigurationRequest(
                map.released as String ?: RELEASED_COLOUR,
                map.complex as String ?: COMPLEX_COLOUR,
                map.blocked as String ?: BLOCKED_COLOUR
        )
    }
}
