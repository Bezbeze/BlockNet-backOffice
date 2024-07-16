package AuthBackOffice.dto.request;

import static AuthBackOffice.api.ValidationConctant.VALID_COMPANY_NAME_REGEXP;
import static AuthBackOffice.api.ValidationMessage.*;

import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateClientRequest {
	
	@NotNull(message = MESSAGE_NULL_COMPANY_NAME)
	@Pattern(regexp = VALID_COMPANY_NAME_REGEXP, message = MESSAGE_INVALID_COMPANY_NAME)
	String companyName;
	
	@NotNull(message = MESSAGE_NULL_EMAIL)
	@NotBlank(message = MESSAGE_BLANK_EMAIL)
	@Email(message = MESSAGE_INVALID_EMAIL)
	String email;
	
	Set<String> companyUrls;
	
	Set<String> maliciousIp;
	

}
