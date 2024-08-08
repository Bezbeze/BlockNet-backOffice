package AuthBackOffice.service.imp;

import org.springframework.stereotype.Service;

import AuthBackOffice.dto.accounting.RolesResponseDto;
import AuthBackOffice.dto.accounting.UserAccountResponseDto;
import AuthBackOffice.dto.accounting.UserActivationDateResponseDto;
import AuthBackOffice.dto.accounting.UserPasswordUpdateDto;
import AuthBackOffice.dto.accounting.UserRegisterDto;
import AuthBackOffice.dto.accounting.UserRoleDto;
import AuthBackOffice.dto.accounting.UserUpdateDto;
import AuthBackOffice.repo.ClientRepo;
import AuthBackOffice.service.IAccountingManagement;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Service
public class AccountingManagementImp implements IAccountingManagement {

	ClientRepo clientRepo;
	
	@Override
	public UserAccountResponseDto registration(UserRegisterDto data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAccountResponseDto removeUser(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAccountResponseDto getUser(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAccountResponseDto editUser(String login, UserUpdateDto data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePassword(String login, UserPasswordUpdateDto data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void revokeAccount(String login) {
		// TODO Auto-generated method stub

	}

	@Override
	public void activateAccount(String login) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserActivationDateResponseDto getActivationDate(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RolesResponseDto getRoles(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RolesResponseDto addRole(String login, UserRoleDto data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RolesResponseDto removeRole(String login, UserRoleDto data) {
		// TODO Auto-generated method stub
		return null;
	}

}
