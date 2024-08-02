package AuthBackOffice.api;

public interface ValidationMessage {
	String MESSAGE_INVALID_COMPANY_NAME = "Invalid company name";
	String MESSAGE_INVALID_EMAIL = "Invalid email";
	String MESSAGE_NULL_COMPANY_NAME = "Company name cannot be null";
	String MESSAGE_NULL_EMAIL = "Email cannot be null";
	String MESSAGE_BLANK_EMAIL = "Email cannot be blank";
	String MESSAGE_INVALID_COMPANY_IP = "One or more IP addresses in companyUrls are invalid";
	String MESSAGE_INVALID_MALICIOUS_IP = "One or more malicious Ip are invalid";
	String MESSAGE_NULL_OR_ENPTY_COMPANY_IP = "Has to have at list one company's ip";

}
