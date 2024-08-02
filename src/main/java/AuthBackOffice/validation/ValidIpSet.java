package AuthBackOffice.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ValidIpSetValidator.class)
public @interface ValidIpSet {
	
	String message() default "Invalid IP address in the set";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	

}
