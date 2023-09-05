package com.example.springboot.config;

import com.example.springboot.model.DevProfile;
import com.example.springboot.model.ISystemProfile;
import com.example.springboot.model.ProductionProfile;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "true", matchIfMissing = true)
    public ISystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "false", matchIfMissing = false)
    public ISystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
