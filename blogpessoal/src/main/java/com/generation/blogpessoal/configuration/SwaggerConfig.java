package com.generation.blogpessoal.configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

	@Bean
    OpenAPI springBlogPessoalOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Projeto Blog Pessoal")
                .description("Meu Projeto de Blog Pessoal criado para a Generation Brasil ")
                .version("v0.0.1")
                .license(new License()
                    .name("Gustavo Traves")
                    .url("https://github.com/GustavoLeal01/blogPessoal"))
                .contact(new Contact()
                    .name("Gustavo Traves")
                    .url("https://github.com/GustavoLeal01/blogPessoal")
                    .email("Travesleal@gmail.com")))
            .externalDocs(new ExternalDocumentation()
                .description("Github")
                .url("https://github.com/GustavoLeal01/blogPessoal"));
    }


	@Bean
	public OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {

		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {

				ApiResponses apiResponses = operation.getResponses();

				apiResponses.addApiResponse("200", createApiResponse("Nice!"));
				apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
				apiResponses.addApiResponse("204", createApiResponse("O Objeto foi de Base!"));
				apiResponses.addApiResponse("400", createApiResponse("Errouu a Requisição!"));
				apiResponses.addApiResponse("401", createApiResponse("Block by James!"));
				apiResponses.addApiResponse("403", createApiResponse("Denied by James!"));
				apiResponses.addApiResponse("404", createApiResponse("Ué cade a Teté!"));
				apiResponses.addApiResponse("500", createApiResponse("Errouu na Aplicação!"));

			}));
		};
	}

	private ApiResponse createApiResponse(String message) {

		return new ApiResponse().description(message);

	}
}