package AuthBackOffice.dto.response;

import java.util.HashSet;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ClientDataResponse {
	
	String companyName;
	String email;
	HashSet<String> companyUrls;
	HashSet<String> maliciousIp;
	

}
