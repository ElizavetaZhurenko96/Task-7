package com.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
@RequiredArgsConstructor
public class EndpointLogger {

    private final ApplicationContext applicationContext;

    @PostConstruct
    public void printAllEndpoints() {
        var handlerMapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        handlerMapping.getHandlerMethods().forEach((key, value) -> {
            System.out.println("Mapped URL: " + key + " => " + value);
        });
    }
}