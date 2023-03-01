package micronaut.openapi.example

import groovy.transform.CompileStatic
import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.extensions.Extension
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.security.OAuthFlow
import io.swagger.v3.oas.annotations.security.OAuthFlows
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.security.SecurityScheme
import io.swagger.v3.oas.annotations.security.SecuritySchemes

@OpenAPIDefinition(
  info = @Info(title = '${info.title}'),
  security = @SecurityRequirement(name = 'OAuth')
)
@SecuritySchemes(
  @SecurityScheme(
    name = 'OAuth',
    type = SecuritySchemeType.OAUTH2,
    extensions = @Extension(
      properties = [
        @ExtensionProperty(
          name = 'client-id',
          value = '${security.oauth.client-id}'
        ),
        @ExtensionProperty(
          name = 'client-secret',
          value = '${security.oauth.client-secret}'
        )
      ]
    ),
    flows = @OAuthFlows(
      authorizationCode = @OAuthFlow(
        authorizationUrl = '${security.oauth.authorization-endpoint}',
        tokenUrl = '${security.oauth.token-endpoint}'
      )
    )
  )
)
@CompileStatic
class Application {

    static void main(String[] args) {
        Micronaut.run(Application, args)
    }

}
