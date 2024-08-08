package AuthBackOffice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import AuthBackOffice.entity.ClientDataEntity;
import AuthBackOffice.repo.ClientRepo;

@Configuration
public class SecurityConfig {

	@Bean
	PasswordEncoder getPasswordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	UserDetailsService userDetailsService(ClientRepo clientrepo) {
		return (username) -> {
			ClientDataEntity account = clientrepo.findById(username)
					.orElseThrow(() -> new UsernameNotFoundException("Account with login '%s' not found".formatted(username)));
			String password = account.getPasswordHashCode();
			String[] roles = account.getRoles().stream().map(r -> "ROLE_" + r).toArray(String[]::new);
			return new User(username, password, AuthorityUtils.createAuthorityList(roles));
		};
	}
}
