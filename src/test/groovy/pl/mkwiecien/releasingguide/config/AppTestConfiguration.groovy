package pl.mkwiecien.releasingguide.config

import com.mongodb.client.MongoClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Primary
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@DataMongoTest
@SpringBootApplication
@EnableMongoRepositories(basePackages = "pl.mkwiecien.releasingguide.domain")
@ComponentScan(basePackages = "pl.mkwiecien.releasingguide")
@EntityScan(basePackages = "pl.mkwiecien.releasingguide.domain")
class AppTestConfiguration {
    private static final String MONGODB_URL = "localhost"
    private static final String MONGODB_NAME = "test"



}
