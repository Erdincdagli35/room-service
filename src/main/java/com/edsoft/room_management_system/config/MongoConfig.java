package com.edsoft.room_management_system.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        // authSource = admin
        MongoCredential credential = MongoCredential.createScramSha256Credential(
                "mongo",
                "admin",
                "RPLJLnAymTucCUYlkIDJQRnqJZTBDyOB".toCharArray()
        );

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString("mongodb://centerbeam.proxy.rlwy.net:45411"))
                .credential(credential)
                .build();

        return MongoClients.create(settings);
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient client) {
        return new MongoTemplate(client, "rms");
    }
}