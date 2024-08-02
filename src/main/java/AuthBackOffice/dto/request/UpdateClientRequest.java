package AuthBackOffice.dto.request;

import static AuthBackOffice.api.ValidationMessage.MESSAGE_INVALID_COMPANY_IP;
import static AuthBackOffice.api.ValidationMessage.MESSAGE_INVALID_EMAIL;
import static AuthBackOffice.api.ValidationMessage.MESSAGE_INVALID_MALICIOUS_IP;

import java.util.HashSet;

import AuthBackOffice.validation.ValidIpSet;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
public class UpdateClientRequest {
	
	@Email(message = MESSAGE_INVALID_EMAIL)
	String email;
	
	@ValidIpSet(message = MESSAGE_INVALID_COMPANY_IP)
	HashSet<String> companyUrls;
	
	@ValidIpSet(message = MESSAGE_INVALID_MALICIOUS_IP)
	HashSet<String> maliciousIp;

}
