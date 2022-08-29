package pl.mkwiecien.releasingguide.domain.configuration;

public interface CreateConfigurationPort {

    ConfigurationId createOrUpdate(ConfigurationRequest request);
}
