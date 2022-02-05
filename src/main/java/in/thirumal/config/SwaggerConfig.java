/**
 * 
 */
package in.thirumal.config;

import org.springframework.context.annotation.Profile;

/**
 * @author Thirumal
 *
 */
//@Configuration
//@EnableSwagger2
@Profile("!PRO")
public class SwaggerConfig {
/*	
	private ApiInfo apiInfo() {
        return new ApiInfo("Microservice to send notification", "Microservice to send notification via e-mail, sms,..", "API V1", "Terms of service",
          new Contact("Thirumal", "https://twitter.com/_thirumal", "m.thirumal@hotmail.com"),
          "License of API", "API license URL", Collections.emptyList());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
          .select()
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())
          .build();
    }

   
    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
          .deepLinking(true)
          .displayOperationId(false)
          .defaultModelsExpandDepth(1)
          .defaultModelExpandDepth(1)
          .defaultModelRendering(ModelRendering.EXAMPLE)
          .displayRequestDuration(false)
          .docExpansion(DocExpansion.NONE)
          .filter(false)
          .maxDisplayedTags(null)
          .operationsSorter(OperationsSorter.ALPHA)
          .showExtensions(false)
          .tagsSorter(TagsSorter.ALPHA)
          .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
          .validatorUrl(null)
          .build();
    }
	*/
}
