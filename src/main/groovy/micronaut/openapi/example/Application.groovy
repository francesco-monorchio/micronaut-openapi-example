package micronaut.openapi.example

import io.micronaut.core.annotation.NonNull
import io.micronaut.context.ApplicationContextBuilder
import io.micronaut.context.ApplicationContextConfigurer
import io.micronaut.context.annotation.ContextConfigurer
import io.micronaut.runtime.Micronaut
import groovy.transform.CompileStatic
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.info.*

@OpenAPIDefinition(
    info = @Info(
            title = "micronaut-openapi-example",
            version = "0.0"
    )
)
@CompileStatic
class Application {

    @ContextConfigurer
    static class Configurer implements ApplicationContextConfigurer {
        @Override
        public void configure(@NonNull ApplicationContextBuilder builder) {
            builder.defaultEnvironments("dev")
        }
    }
    static void main(String[] args) {
        Micronaut.run(Application, args)
    }
}
