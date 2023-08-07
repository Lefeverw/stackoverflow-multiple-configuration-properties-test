package com.wouterlefever.stackoverflow.configtest.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Objects;

class MyConfigTest {

    @ParameterizedTest
    @ValueSource(strings = {"application-foo.yml", "application-bar.yml"})
    void test(String fileName) throws IOException, URISyntaxException {
        final PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        final Resource resource = resourceResolver
                .getResource(String.valueOf(Objects.requireNonNull(getClass().getClassLoader().getResource(String.valueOf(Path.of("configurations", fileName)))).toURI()));


        final Yaml yaml = new Yaml();
        final Object map = yaml.load(resource.getInputStream());
        final ObjectWriter ow = new ObjectMapper().writer();
        final String componentPageDescriptorString = ow.writeValueAsString(map);
        final MyConfig myConfig = new ObjectMapper()
                .readValue(componentPageDescriptorString, MyConfig.class);
        System.out.println(myConfig.getProperties());
    }
}

