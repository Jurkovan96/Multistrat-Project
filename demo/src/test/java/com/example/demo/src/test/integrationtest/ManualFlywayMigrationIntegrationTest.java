package com.example.demo.src.test.integrationtest;

import com.example.demo.model.EmptyMigrationStrategyConfig;
import org.flywaydb.core.Flyway;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = EmptyMigrationStrategyConfig.class)
public class ManualFlywayMigrationIntegrationTest {

    @MockBean
    private Flyway flyway;

    @Test
    public void skipAutomaticAndTriggerManualFlywayMigration() {
        flyway.migrate();
    }
}