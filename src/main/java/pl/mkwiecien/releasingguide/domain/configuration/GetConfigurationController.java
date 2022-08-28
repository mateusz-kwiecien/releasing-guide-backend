package pl.mkwiecien.releasingguide.domain.configuration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configuration")
public class GetConfigurationController {

    private final GetConfigurationPort getConfigurationPort;

    public GetConfigurationController(GetConfigurationPort getConfigurationPort) {
        this.getConfigurationPort = getConfigurationPort;
    }

    @GetMapping
    public ResponseEntity<Configuration> getLatestConfiguration() {
        return ResponseEntity.ok(getConfigurationPort.getLatest());
    }
}
