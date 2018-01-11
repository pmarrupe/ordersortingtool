package com.sample.project.config;

import com.sample.project.repository.IApplicationRepository;
import com.sample.project.repository.impl.ApplicationRepository;
import com.sample.project.service.IApplicationService;
import com.sample.project.service.impl.ApplicationService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableAutoConfiguration
public class SpringConfig {

    @Bean
    public Docket simpleDiffServiceApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("A simple order list sorting application")
                .description("A simple REST service made with Spring Boot in Java")
                .version("1.0")
                .build();
    }

    @Bean
    public IApplicationService getService() {
        return new ApplicationService();
    }

    @Bean
    public IApplicationRepository getRepository() {
        return new ApplicationRepository();
    }
}