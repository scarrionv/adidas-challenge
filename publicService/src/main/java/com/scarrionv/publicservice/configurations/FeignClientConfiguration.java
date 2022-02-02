package com.scarrionv.publicservice.configurations;

import com.scarrionv.publicservice.clients.SubscriptionsClientErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new SubscriptionsClientErrorDecoder();
    }

}
