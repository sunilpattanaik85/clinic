package com.clinicexa.clinic.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*@EnableSwagger2
@ComponentScan(basePackages = "com.clinicexa.clinic.controller.*")
@Configuration*/
public class SpringFoxConfig {                                    
	/*private ApiInfo apiInfo(){
	       return  new ApiInfoBuilder()
	               .title("Clinic App")
	               .description("Rest API's for Clinic App")
	               .license("License")
	               .version("1.0")
	               .build();
	   }
	   @Bean
	   public Docket clinicApi(){
	       return  new Docket(DocumentationType.SWAGGER_2)
	               .apiInfo(apiInfo())
	               .pathMapping("/")
	               .select()
	               .build();
	   }*/
}