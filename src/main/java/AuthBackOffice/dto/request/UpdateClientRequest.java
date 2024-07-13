package AuthBackOffice.dto.request;

import java.util.HashSet;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
public class UpdateClientRequest {
	String companyName;
	String email;
	HashSet<String> companyUrls;
	HashSet<String> maliciousIp;

}
