package com.devsuperior.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    /* Anotacao utilizada para informar que o método ira retornar um bean
     que sera gerenciado pelo Spring. Semelhante ao @Component, so que a nível de método */
    @Bean
    public RestTemplate registerRestTemplate(){
        return new RestTemplate();
    }
}
