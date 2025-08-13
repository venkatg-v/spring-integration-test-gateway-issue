package com.venkatg.v.samples;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.MessageChannel;

@SpringBootApplication
public class SpringIntegrationTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationTestApplication.class, args);
    }

    @Bean
    IntegrationFlow integrationFlow() {
        return IntegrationFlow.from(MessageChannels.direct())
                .gateway("subflowInputChannel")
                .bridge()
                .get();
    }

    @Bean("subflowInputChannel")
    MessageChannel subflowInputChannel() {
        return new DirectChannel();
    }

    @Bean
    IntegrationFlow subflow(@Qualifier("subflowInputChannel") MessageChannel subflowInputChannel) {
        return IntegrationFlow.from(subflowInputChannel)
                .handle((payload, headers) -> payload.toString().toUpperCase())
                .get();
    }
}
