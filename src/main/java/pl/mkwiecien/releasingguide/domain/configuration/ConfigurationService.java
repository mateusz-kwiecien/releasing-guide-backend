package pl.mkwiecien.releasingguide.domain.configuration;

import org.springframework.stereotype.Service;
import pl.mkwiecien.releasingguide.domain.util.TimeService;

import java.time.Instant;

@Service
class ConfigurationService implements GetConfigurationPort, CreateConfigurationPort {

    private final ConfigurationRepository repository;

    private final TimeService timeService;

    public ConfigurationService(ConfigurationRepository repository, TimeService timeService) {
        this.repository = repository;
        this.timeService = timeService;
    }

    @Override
    public Configuration getLatest() {
        return repository.findTopByOrderByCreatedDesc()
                .orElse(defaultConfiguration());
    }

    @Override
    public ConfigurationId createOrUpdate(ConfigurationRequest request) {
        return new ConfigurationId(repository.save(from(request)).getId());
    }

    private Configuration defaultConfiguration() {
        return new Configuration("id", new ColourPalette("82E0AA", "F7DC6F", "E74C3C"), Instant.now());
    }

    private Configuration from(ConfigurationRequest request) {
        return new Configuration(null, new ColourPalette(request.released(), request.complex(), request.blocked()), timeService.now());
    }
}
