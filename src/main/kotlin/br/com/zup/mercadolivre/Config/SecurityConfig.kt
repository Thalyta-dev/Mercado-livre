package br.com.zup.mercadolivre.Config

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer
import org.springframework.security.config.http.SessionCreationPolicy


@Configuration

class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)

    protected override fun configure(http: HttpSecurity) {
        http.csrf().disable()
        http.headers().httpStrictTransportSecurity().disable()
        http.authorizeRequests { authorizeRequests ->
            authorizeRequests
                .antMatchers(HttpMethod.POST, "/api/categorias").hasAuthority("SCOPE_prod")
                .antMatchers(HttpMethod.POST, "/api/usuarios").permitAll()

                .anyRequest().authenticated()
        }
            .oauth2ResourceServer(Customizer { oauth -> oauth.jwt() })
            .sessionManagement { s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
    }
}



