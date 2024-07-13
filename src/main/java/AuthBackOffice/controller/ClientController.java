package AuthBackOffice.controller;

import static AuthBackOffice.api.ClientControllerEndpoint.ADD_CLIENT_ENDPOINT;
import static AuthBackOffice.api.ClientControllerEndpoint.DELETE_CLIENT_ENDPOINT;
import static AuthBackOffice.api.ClientControllerEndpoint.GET_CLIENT_ENDPOINT;
import static AuthBackOffice.api.ClientControllerEndpoint.UPDATE_CLIENT_ENDPOINT;
import static AuthBackOffice.api.ValidationConctant.VALID_COMPANY_NAME_REGEXP;
import static AuthBackOffice.api.ValidationMessage.MESSAGE_INVALID_COMPANY_NAME;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import AuthBackOffice.dto.request.CreateClientRequest;
import AuthBackOffice.dto.request.UpdateClientRequest;
import AuthBackOffice.dto.response.ClientDataResponse;
import AuthBackOffice.service.imp.ClientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;


@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ClientController{
	
	ClientService clientService;
	
	@PostMapping(path = ADD_CLIENT_ENDPOINT) 
	public ClientDataResponse addClient(@RequestBody @Valid CreateClientRequest client) {
		return clientService.addClient(client);
	}

	@GetMapping(path= GET_CLIENT_ENDPOINT)
	public ClientDataResponse getClient(
			@PathVariable(required = true) 
			@Pattern(regexp = VALID_COMPANY_NAME_REGEXP, message = MESSAGE_INVALID_COMPANY_NAME)
			String companyName) {
		return clientService.getClient(companyName);
	}

	
	@PutMapping(path = UPDATE_CLIENT_ENDPOINT)
	public ClientDataResponse updateClient(@RequestBody @Valid UpdateClientRequest client) {
		return clientService.updateClient(client);
	}

	@DeleteMapping(path = DELETE_CLIENT_ENDPOINT)
	public ClientDataResponse deleteClient(
			@PathVariable(required = true)
			@Pattern(regexp = VALID_COMPANY_NAME_REGEXP, message = MESSAGE_INVALID_COMPANY_NAME)
			String companyName) {
		return clientService.deleteClient(companyName);
	}

}
