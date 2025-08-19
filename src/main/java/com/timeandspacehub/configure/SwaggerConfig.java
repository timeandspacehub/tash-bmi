package com.timeandspacehub.configure;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "googleOAuth",
        type = SecuritySchemeType.OAUTH2,
        flows = @OAuthFlows(
                authorizationCode = @OAuthFlow(
                        authorizationUrl = "https://accounts.google.com/o/oauth2/v2/auth",
                        tokenUrl = "https://oauth2.googleapis.com/token",
                        scopes = {
                                @OAuthScope(name = "email", description = "Access email"),
                                @OAuthScope(name = "profile", description = "Access profile")
                        }
                )
        )
)

public class SwaggerConfig {

}
