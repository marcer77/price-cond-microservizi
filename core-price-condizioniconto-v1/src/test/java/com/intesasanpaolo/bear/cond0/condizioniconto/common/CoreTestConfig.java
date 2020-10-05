package com.intesasanpaolo.bear.cond0.condizioniconto.common;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ContextConfiguration
@EnableWebMvc
@ComponentScan("com.intesasanpaolo")
public class CoreTestConfig {
}
