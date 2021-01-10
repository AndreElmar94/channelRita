package by.itstep.channelRita.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

// http://localhost:8082/swagger-ui.html/
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(generateApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("by.itstep.channelRita.controller"))
                .build();
    }

    private ApiInfo generateApiInfo() {
       return new ApiInfoBuilder()
                .title("Channnel and posts api")
                .description("Api allows you to control the system!")
                .version("1.0")
                .build();
    }

}

