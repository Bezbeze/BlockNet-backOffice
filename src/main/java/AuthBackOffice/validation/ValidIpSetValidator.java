package AuthBackOffice.validation;

import java.util.Set;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidIpSetValidator implements ConstraintValidator<ValidIpSet, Set<String>>{

	private static final String IP_ADDRESS_PATTERN =
			"^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$";

    private final Pattern pattern = Pattern.compile(IP_ADDRESS_PATTERN);
	
	@Override
	public void initialize(ValidIpSet constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(Set<String> value, ConstraintValidatorContext context) {
		if(value == null || value.isEmpty())
			return true;
		
	    for (String ip : value) {
            if (ip==null || !pattern.matcher(ip).matches()) 
                return false;
        }
		
		return true;
	}

}
