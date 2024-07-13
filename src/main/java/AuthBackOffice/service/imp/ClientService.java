package AuthBackOffice.service.imp;

import AuthBackOffice.dto.request.CreateClientRequest;
import AuthBackOffice.dto.request.UpdateClientRequest;
import AuthBackOffice.dto.response.ClientDataResponse;

public interface ClientService {
	ClientDataResponse addClient(CreateClientRequest client);
	ClientDataResponse getClient(String companyName);
	ClientDataResponse updateClient(UpdateClientRequest client);
	ClientDataResponse deleteClient(String companyName);
}
