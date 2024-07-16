package AuthBackOffice.dto.response;

import java.util.Set;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@Builder
public class ClientDataResponse {
	
	String companyName;
	String email;
	Set<String> companyUrls;
	Set<String> maliciousIp;
	

}
