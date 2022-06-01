package com.example.crudexample.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        return (ModelMapper) new ModelMapper();
                //.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }
}
