package AuthBackOffice.dto.accounting;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserActivationDateResponseDto {

	private LocalDateTime activationDate;
}
