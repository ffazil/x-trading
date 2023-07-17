package com.example.x.trading.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Configuration
public class KotakSecuritiesConfig {

    @Value("${kotak.marketplace.api.baseUrl}")
    private String baseUrl;

    @Bean
    public WebClient kotakSecuritiesWebClient(){
        WebClient client = WebClient.builder()
                .baseUrl(vtexMarketplaceBaseUrl)
                .exchangeStrategies(exchangeStrategies())
                .defaultHeader("X-VTEX-API-AppKey", vtexMarketplaceAppKey)
                .defaultHeader("X-VTEX-API-AppToken", vtexMarketplaceAppSecret)
                .build();
        return client;
    }
}
