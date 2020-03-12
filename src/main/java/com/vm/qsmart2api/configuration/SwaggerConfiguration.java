/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.configuration;


import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author Phani
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

//    public static final Contact DEFAULT_CONTACT = new Contact("Vectramind Technologies", "http://www.vectramind.com", "sales@vectramind.com");
//    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Qsmart", "Qsmart 1.0 UI Services", "1.0", "", "http://www.vectramind.com", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
//    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json", "application/xml"));
    private final String BASE_PATH = "/myapp/api/v1";

    @Bean
    public Docket api() {
        
        System.out.println("-------> Swagger");
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Qsmart-2.0")
//                .pathProvider(new RelativePathProvider(servletContext) {
//                    @Override
//                    public String getApplicationBasePath() {
//                        return  super.getApplicationBasePath() + "/serviceName" ;
//                    }
//                }).host(BASE_PATH)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vm.qsmart2api.contoller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Qsmart-2",
                "Qsmart 2.0 UI Services",
                "1.0",
                "",
                new Contact("Vectramind Technologies", "http://www.vectramind.com", "sales@vectramind.com"),
                "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0.html", Collections.emptyList());
    }

}
