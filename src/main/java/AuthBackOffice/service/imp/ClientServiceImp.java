package AuthBackOffice.service.imp;

import org.springframework.stereotype.Service;

import AuthBackOffice.dto.request.CreateClientRequest;
import AuthBackOffice.dto.request.UpdateClientRequest;
import AuthBackOffice.dto.response.ClientDataResponse;
import AuthBackOffice.service.ClientService;


@Service
public class ClientServiceImp implements ClientService {

	@Override
	public ClientDataResponse addClient(CreateClientRequest client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientDataResponse getClient(String companyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientDataResponse updateClient(String companyName, UpdateClientRequest client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientDataResponse deleteClient(String companyName) {
		// TODO Auto-generated method stub
		return null;
	}

}
