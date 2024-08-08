package AuthBackOffice.boot;

import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import AuthBackOffice.dto.accounting.Role;
import AuthBackOffice.entity.ClientDataEntity;
import AuthBackOffice.repo.ClientRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;


@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DefaultSuperAdminAccountCreationBoot implements ApplicationRunner {
	
	PasswordEncoder passwordEncoder;
	ClientRepo client;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (client.count() == 0) {
			ClientDataEntity defaultAdmin = new ClientDataEntity("admin", passwordEncoder.encode("qwe123"), "admin@gmail.com", null, null);
			Set<Role> roles = defaultAdmin.getRoles();
			roles.add(Role.SUPER_ADMIN);
			roles.remove(Role.USER);
			client.save(defaultAdmin);
		}
		System.out.println(client.findAll());
	}

}
