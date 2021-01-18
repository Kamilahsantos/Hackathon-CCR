package com.ccr.hackathon.backend.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ccr.hackathon.backend.controller"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(true)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){

        return new ApiInfoBuilder()
                .title("RecomeçaTech API ")
                .description("Backend do projeto RecomeçaTech! Nossa missão é capacitar jovens egressos do\n" +
                        "sistema penal e conectá-los com o mercado da tecnologia, seja por meio da\n" +
                        "educação empreendedorismo, apoio social e mercado de trabalho.")
                .version("1.0.0")
                .contact(new Contact("Github", "https://github.com/Kamilahsantos/Recomeca-Tech-Api",null))
                .build();

    }
}
