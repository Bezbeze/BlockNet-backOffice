package AuthBackOffice.dto.accounting;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
	
	USER("USER"),
	ADMIN("ADMIN"),
	SUPER_ADMIN("SUPER_ADMIN");
	
	private String value;
	
	public static boolean existsByValue(String role) {
		boolean res = false;
		if(role != null && !role.isBlank()) {
			res = Arrays.stream(values())
					.anyMatch(e -> e.value.equalsIgnoreCase(role));
		}
		return res;
	}

}
