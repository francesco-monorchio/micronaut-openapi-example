package micronaut.openapi.example

import io.micronaut.context.env.Environment
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.swagger.v3.oas.annotations.Hidden
import jakarta.inject.Inject
import org.apache.commons.text.StringSubstitutor

@Controller
@Hidden
class OpenApiController {

    @Inject
    OpenApiConfig config

    @Inject
    Environment environment

    @Get('/swagger/openapi.json')
    String openapi() {

        def source = config.specFile.asInputStream()
        def propertyNames = environment.propertySources
          .find {ps -> ps.name == 'application'}
          .toList()
        Map<String, String> map = [:]
        propertyNames.forEach { name ->
            map.put(name, environment.get(name, String).orElseThrow())
        }

        return StringSubstitutor.replace(source.text, map)
    }

}
