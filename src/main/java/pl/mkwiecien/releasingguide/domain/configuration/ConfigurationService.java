package pl.mkwiecien.releasingguide.domain.configuration;

import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
class ConfigurationService implements GetConfigurationPort {

    private final ConfigurationRepository repository;

    public ConfigurationService(ConfigurationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Configuration getLatest() {
        return repository.findTopByOrderByCreatedDesc()
                .orElse(defaultConfiguration());
    }

    private Configuration defaultConfiguration() {
        return new Configuration("id", new ColourPalette("82E0AA", "F7DC6F", "E74C3C"), Instant.now());
    }
}
