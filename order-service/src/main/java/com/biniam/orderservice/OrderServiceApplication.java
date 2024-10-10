package com.biniam.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }


    // Swagger Configuration to generate customized API documentation
    @Bean
    public Docket Swaggerapi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.biniam.orderservice.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfoDettails());
    }
    // adding application metadata for api info in swagger documentation page
    private ApiInfo apiInfoDettails() {
        return new ApiInfo(
                "Order Service API",
                "Order Service API for Order Management",
                "1.0",
                null,
                new springfox.documentation.service.Contact("Biniam", "www.biniam.com", "songyz@gmail.com"),
                "API License",
                null,
                Collections.emptyList()
        );
    }

}
