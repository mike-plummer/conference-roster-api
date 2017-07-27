package com.objectpartners.conference_roster.config;

import com.google.common.base.Predicates;
import com.objectpartners.conference_roster.data.entities.Attendance;
import com.objectpartners.conference_roster.data.entities.Conference;
import com.objectpartners.conference_roster.data.entities.Person;
import com.objectpartners.conference_roster.data.entities.Presentation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.DocumentationContextBuilder;
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
                .build()
                // Ugh - SpringFox pukes on circular references
                .ignoredParameterTypes(Attendance.class)
                .ignoredParameterTypes(Conference.class)
                .ignoredParameterTypes(Person.class)
                .ignoredParameterTypes(Presentation.class);
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
