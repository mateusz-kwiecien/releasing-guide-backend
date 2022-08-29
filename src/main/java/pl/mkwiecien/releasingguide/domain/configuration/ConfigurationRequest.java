package pl.mkwiecien.releasingguide.domain.configuration;

public record ConfigurationRequest(
        String released,
        String complex,
        String blocked) {
}