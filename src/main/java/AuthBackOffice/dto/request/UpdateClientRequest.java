package AuthBackOffice.dto.request;

import java.util.HashSet;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import static AuthBackOffice.api.ValidationConctant.*;
import static AuthBackOffice.api.ValidationMessage.*;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
public class UpdateClientRequest {
	@NotNull
	@Pattern(regexp = VALID_COMPANY_NAME_REGEXP, message = MESSAGE_INVALID_COMPANY_NAME)
	String companyName;
	
	@Email(message = MESSAGE_INVALID_EMAIL)
	String email;
	
	
	HashSet<String> companyUrls;
	
	
	HashSet<String> maliciousIp;

}
