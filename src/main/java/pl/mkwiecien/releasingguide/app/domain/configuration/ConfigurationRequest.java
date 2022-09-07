package pl.mkwiecien.releasingguide.app.domain.configuration;

public record ConfigurationRequest(
        String released,
        String complex,
        String blocked) {
}