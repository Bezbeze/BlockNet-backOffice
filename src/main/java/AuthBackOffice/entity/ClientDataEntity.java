package AuthBackOffice.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import AuthBackOffice.dto.accounting.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Document(collection = "Clients")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ClientDataEntity {

	@Id
	@Setter(value = AccessLevel.NONE)
	String companyName;
	
	String passwordHashCode;
	
	String email;
	
	Set<String> companyUrls;
	
	Set<String> maliciousIp;
	
	HashSet<Role> roles;
	
	LocalDateTime activationDate;
	
	{
		activationDate = LocalDateTime.now();
		roles = new HashSet<>();
		roles.add(Role.USER);
	}
	
	public ClientDataEntity(String companyName, 
			String passwordHashCode,
			String email,
			Set<String> companyUrls,
			Set<String> maliciousIp) {
		super();
		this.companyName = companyName;
		this.passwordHashCode = passwordHashCode;
		this.email = email;
		this.companyUrls = companyUrls;
		this.maliciousIp = maliciousIp;
	}
}
