package AuthBackOffice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Autorization {
	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception {
		return http.httpBasic(Customizer.withDefaults())
				.csrf(csrf->csrf.disable())
				.sessionManagement(sessionManagment -> sessionManagment.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(authorize-> authorize.requestMatchers("/account/register").permitAll()
						.requestMatchers("/account/user/*/role/*", "/account/revoke/*", "/account/activate/*")
						.hasRole("ADMIN")
//						.hasAnyRole("USER", "ADMIN")
						.anyRequest().authenticated())
				.build();
	}
	

}
