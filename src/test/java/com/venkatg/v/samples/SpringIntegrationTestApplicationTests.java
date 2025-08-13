package com.venkatg.v.samples;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.test.context.MockIntegrationContext;
import org.springframework.integration.test.context.SpringIntegrationTest;

@SpringBootTest
@SpringIntegrationTest
class SpringIntegrationTestApplicationTests {

    @Autowired
    private MockIntegrationContext mockIntegrationContext;

    @Test
    void contextLoads() {
    }
}
