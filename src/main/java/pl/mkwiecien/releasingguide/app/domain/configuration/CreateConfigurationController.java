package pl.mkwiecien.releasingguide.app.domain.configuration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configuration")
public class CreateConfigurationController {

    private final CreateConfigurationPort createConfigurationPort;

    public CreateConfigurationController(CreateConfigurationPort createConfigurationPort) {
        this.createConfigurationPort = createConfigurationPort;
    }

    @PostMapping
    public ResponseEntity<ConfigurationId> createOrUpdateConfiguration(@RequestBody ConfigurationRequest request) {
        return ResponseEntity.ok(createConfigurationPort.createOrUpdate(request));
    }
}
