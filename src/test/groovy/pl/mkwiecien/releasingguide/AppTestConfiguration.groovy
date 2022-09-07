package pl.mkwiecien.releasingguide


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@DataMongoTest
@SpringBootApplication
@TestConfiguration
@EnableMongoRepositories(basePackages = "pl.mkwiecien.releasingguide.app.domain")
@ComponentScan(basePackages = "pl.mkwiecien.releasingguide.app")
@EntityScan(basePackages = "pl.mkwiecien.releasingguide.app.domain")
class AppTestConfiguration {
    private static final String MONGODB_URL = "localhost"
    private static final String MONGODB_NAME = "test"



}
