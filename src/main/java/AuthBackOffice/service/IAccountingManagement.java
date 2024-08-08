package AuthBackOffice.service;

import AuthBackOffice.dto.accounting.RolesResponseDto;
import AuthBackOffice.dto.accounting.UserAccountResponseDto;
import AuthBackOffice.dto.accounting.UserActivationDateResponseDto;
import AuthBackOffice.dto.accounting.UserPasswordUpdateDto;
import AuthBackOffice.dto.accounting.UserRegisterDto;
import AuthBackOffice.dto.accounting.UserRoleDto;
import AuthBackOffice.dto.accounting.UserUpdateDto;

public interface IAccountingManagement {
	
	UserAccountResponseDto registration(UserRegisterDto data);
	UserAccountResponseDto removeUser(String login);
	UserAccountResponseDto getUser(String login);
	UserAccountResponseDto editUser(String login, UserUpdateDto data);
	void updatePassword(String login, UserPasswordUpdateDto data);
	void revokeAccount(String login);
	void activateAccount(String login);
	UserActivationDateResponseDto getActivationDate(String login);
	RolesResponseDto getRoles(String login);
	RolesResponseDto addRole(String login, UserRoleDto data);
	RolesResponseDto removeRole(String login, UserRoleDto data);


}
