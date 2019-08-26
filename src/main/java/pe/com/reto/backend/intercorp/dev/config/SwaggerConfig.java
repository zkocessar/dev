package pe.com.reto.backend.intercorp.dev.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("pe.com.reto.backend.intercorp.dev"))
				.paths(PathSelectors.regex("/rest.*"))
				.build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"MicroServicio - Reto Intercorp",
				"MicroServicio - Reto Intercorp for Cesar Flores",
				"1.0",
				"Terms of Service",
				new Contact("Cesar Flores Dev", "https://www.linkedin.com/in/cesar-michel-flores-espinoza-58aa3474/", "owcessar@gmail.com"),
				"Apache License Version 2.0", "https://www.apache.org/license.html", null
				);
		return apiInfo;
	}

	
	
}
