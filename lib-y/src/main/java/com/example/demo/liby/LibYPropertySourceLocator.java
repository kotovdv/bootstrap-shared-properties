package com.example.demo.liby;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.bootstrap.BootstrapConfiguration;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.Map;

@BootstrapConfiguration
public class LibYPropertySourceLocator implements PropertySourceLocator {

    public static final String SOURCE_NAME = "lib-y-property-source";

    @Value("${libY.consumed.property}")
    private String consumedProperty;

    @Override
    public PropertySource<?> locate(Environment environment) {
        String key = "libY.produced.property";
        return new MapPropertySource(
                SOURCE_NAME,
                Map.of(key, "consumed " + consumedProperty)
        );
    }
}
