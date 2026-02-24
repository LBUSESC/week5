package com.unistudycircle.topic_service.client;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
@ImportHttpServices(StudentClient.class)
public class HttpClientConfig {
}
