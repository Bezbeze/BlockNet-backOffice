package AuthBackOffice.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import AuthBackOffice.dto.accounting.RolesResponseDto;
import AuthBackOffice.dto.accounting.UserAccountResponseDto;
import AuthBackOffice.dto.accounting.UserActivationDateResponseDto;
import AuthBackOffice.dto.accounting.UserPasswordUpdateDto;
import AuthBackOffice.dto.accounting.UserRegisterDto;
import AuthBackOffice.dto.accounting.UserRoleDto;
import AuthBackOffice.dto.accounting.UserUpdateDto;
import AuthBackOffice.service.IAccountingManagement;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE,  makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountingController {
	
	IAccountingManagement accountingManagement;
	
	@PostMapping("/register")
	public UserAccountResponseDto registration(@RequestBody UserRegisterDto data) {
		return accountingManagement.registration(data);
	}

	@DeleteMapping("/user/{login}")
	public UserAccountResponseDto removeUser(@PathVariable String login) {
		return accountingManagement.removeUser(login);
	}

	@GetMapping("/user/{login}")
	public UserAccountResponseDto getUser(@PathVariable String login) {
		return accountingManagement.getUser(login);
	}

	@PutMapping("/user/{login}")
	public UserAccountResponseDto editUser(@PathVariable String login, @RequestBody UserUpdateDto account) {
		return accountingManagement.editUser(login, account);
	}

	@PutMapping("/password")
	public void updatePassword(Principal principal, @RequestBody UserPasswordUpdateDto password) {
		accountingManagement.updatePassword(principal.getName(), password);
	}

	@PutMapping("/revoke/{login}")
	public void revokeAccount(@PathVariable String login) {
		accountingManagement.revokeAccount(login);

	}

	@PutMapping("/activate/{login}")
	public void activateAccount(@PathVariable String login) {
		accountingManagement.activateAccount(login);

	}

	@GetMapping("/activation_date/{login}")
	public UserActivationDateResponseDto getActivationDate(@PathVariable String login) {
		return accountingManagement.getActivationDate(login);
	}

	@GetMapping("/roles/{login}")
	public RolesResponseDto getRoles(@PathVariable String login) {
		return accountingManagement.getRoles(login);
	}

	@PutMapping("/user/{login}/role")
	public RolesResponseDto addRole(@PathVariable String login, @RequestBody UserRoleDto data) {
		return accountingManagement.addRole(login, data);
	}

	@DeleteMapping("/user/{login}/role")
	public RolesResponseDto removeRole(@PathVariable String login, @RequestBody UserRoleDto data) {
		return accountingManagement.removeRole(login, data);
	}

}
