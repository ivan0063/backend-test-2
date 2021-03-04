package com.walmart.example.api.feedback.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>CLass that storage the beans to be used in the whole application</p>
 *
 * @author J. Ivan Martinez Mateos
 * @since 03/03/2021
 */
@Configuration
public class Beans {
    /**
     * This object its going to be use to fill the DTO Objects
     * in a simple way and trying to avoid the boilerplate
     * @return ModelMapper
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
