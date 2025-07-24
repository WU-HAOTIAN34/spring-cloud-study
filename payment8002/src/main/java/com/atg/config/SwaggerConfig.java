package com.atg.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi payApi(){
        return GroupedOpenApi.builder().group("支付模块").pathsToMatch("/pay/**").build();
    }

    @Bean
    public OpenAPI docsOpenApi() {
        return new OpenAPI()
            .info(new Info()
                    .title("spring-cloud")
                    .description("通用设计")
                    .version("v1.0")
            )
            .externalDocs(new ExternalDocumentation()
                    .description("")
                    .url("")
            );
    }

}
