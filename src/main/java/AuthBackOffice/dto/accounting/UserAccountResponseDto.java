package AuthBackOffice.dto.accounting;

import java.util.Set;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserAccountResponseDto {
	
	String companyName;  //login
	String email;
	Set<String> companyUrls;
	Set<String> maliciousIp;
	Set<String> roles;
}
