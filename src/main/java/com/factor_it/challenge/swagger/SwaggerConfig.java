package com.factor_it.challenge.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.factor_it.challenge.controller"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Api para Factor-IT",
                "Api para leer documento xml y convertirlo en en excel",
                "1.0",
                "Factor-IT",
                new Contact("Jonatan Fontana",
                            "https://github.com/bzstyle",
                            "fontanajonatan1133@gmail.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
        return apiInfo;
    }

}
