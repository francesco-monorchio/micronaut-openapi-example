package micronaut.openapi.example

import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.core.io.Readable

@ConfigurationProperties('openapi')
class OpenApiConfig {

    Readable specFile

}
