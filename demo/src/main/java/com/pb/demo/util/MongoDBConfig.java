package com.pb.demo.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoDBConfig {

	@Bean
    public MongoClient mongo() {
		ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:admin@cluster0.8dgxs.mongodb.net/PuntoVenta");
//        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/PuntoVenta");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
          .applyConnectionString(connectionString)
          .build();
        
        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "PuntoVenta");
    }
}
