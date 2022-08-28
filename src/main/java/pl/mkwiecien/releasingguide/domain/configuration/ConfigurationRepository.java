package pl.mkwiecien.releasingguide.domain.configuration;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface ConfigurationRepository extends MongoRepository<Configuration, String> {

    Optional<Configuration> findTopByOrderByCreatedDesc();
}
