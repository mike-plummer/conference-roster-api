package com.objectpartners.conference_roster.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import({
        SpringDataRestConfiguration.class,
        BeanValidatorPluginsConfiguration.class
})
public class DocumentationConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .apiInfo(new ApiInfoBuilder()
                        .title("OPI Conference Roster API")
                        .description("API for OPI Conference Roster system data")
                        .license("MIT")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/**"))
                .build();
    }

    @Bean
    public Docket management() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("management")
                .apiInfo(new ApiInfoBuilder()
                        .title("OPI Conference Roster Application Management")
                        .description("API for managing the OPI Conference Roster system")
                        .license("MIT")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.ant("/api/**")))
                .build();
    }
}
