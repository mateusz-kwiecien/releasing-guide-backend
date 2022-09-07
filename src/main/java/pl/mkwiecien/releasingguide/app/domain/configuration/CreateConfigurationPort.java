package pl.mkwiecien.releasingguide.app.domain.configuration;

public interface CreateConfigurationPort {

    ConfigurationId createOrUpdate(ConfigurationRequest request);
}
