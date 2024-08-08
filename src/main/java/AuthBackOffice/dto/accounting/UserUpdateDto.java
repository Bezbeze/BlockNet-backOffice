package AuthBackOffice.dto.accounting;

import java.util.Set;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateDto {
	
	String email;
	Set<String> companyUrls;
	Set<String> maliciousIp;

}
