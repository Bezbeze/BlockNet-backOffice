package AuthBackOffice.controller;

import static AuthBackOffice.api.ClientControllerEndpoint.ADD_CLIENT_ENDPOINT;
import static AuthBackOffice.api.ValidationMessage.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import AuthBackOffice.dto.request.CreateClientRequest;
import AuthBackOffice.dto.response.ClientDataResponse;
import AuthBackOffice.dto.response.GeneralErrorResponseValidation;
import AuthBackOffice.service.imp.ClientService;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

@WebMvcTest(controllers = ClientController.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
class AddClientControllerTest {

	@MockBean
	ClientService clientService;

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	static final String CORRECT_COMPANY_NAME = "name";
	static final String CORRECT_EMAIL = "qwerty@gmail.com";
	static final Set<String> CORRECT_COMPANY_URLS = new HashSet<>(
			Arrays.asList("20.167.212.166", "146.41.203.136", "197.95.253.234", "47.152.17.155"));
	static final Set<String> CORRECT_MALICIOUS_IPs = new HashSet<>(
			Arrays.asList("30.167.212.166", "145.41.203.136", "191.95.253.234", "48.152.17.155"));
	static final ArrayList<CreateClientRequest> createClientRequests = new ArrayList<>();
	static final ArrayList<ClientDataResponse> dataResponses = new ArrayList<>();

	@BeforeEach
	void setUo() {
		createClientRequests.clear();
		dataResponses.clear();
		createClientRequests.addAll(Arrays.asList(
						new CreateClientRequest(CORRECT_COMPANY_NAME, CORRECT_EMAIL, CORRECT_COMPANY_URLS, null),
						new CreateClientRequest(CORRECT_COMPANY_NAME.concat("1"), CORRECT_EMAIL, CORRECT_COMPANY_URLS, null),
						new CreateClientRequest(CORRECT_COMPANY_NAME.concat("2"), CORRECT_EMAIL, CORRECT_COMPANY_URLS, CORRECT_MALICIOUS_IPs)));

		dataResponses.addAll(Arrays.asList(
				new ClientDataResponse(CORRECT_COMPANY_NAME, CORRECT_EMAIL, CORRECT_COMPANY_URLS, null),
				new ClientDataResponse(CORRECT_COMPANY_NAME.concat("1"), CORRECT_EMAIL, CORRECT_COMPANY_URLS, null),
				new ClientDataResponse(CORRECT_COMPANY_NAME.concat("2"), CORRECT_EMAIL, CORRECT_COMPANY_URLS, CORRECT_MALICIOUS_IPs)));
	}

	/*
	 * company can't be created without company's mail
	 * company can't be created without company's urls,
	 * company can be created without MALICIOUS_IPs, it's correct
	 */
	@Test
	@SneakyThrows
	@DisplayName("Add correct client data")
	void addClient_correctData_ok() {
		for (int i = 0; i < createClientRequests.size(); i++) {

			CreateClientRequest dataRequest = createClientRequests.get(i);
			ClientDataResponse dataResponse = dataResponses.get(i);
			Mockito.when(clientService.addClient(dataRequest)).thenReturn(dataResponse);

			RequestBuilder request = MockMvcRequestBuilders.post(ADD_CLIENT_ENDPOINT)
					.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(dataRequest));

			String actualResponse = mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
					.andReturn().getResponse().getContentAsString();
			ClientDataResponse actualClientResponse = objectMapper.readValue(actualResponse, ClientDataResponse.class);

			assertEquals(dataResponse, actualClientResponse);
		}
	}

	// ^[a-zA-Z0-9]+$ pattern name
	@Test
	@DisplayName("Invalid company's name")
	void addClient_invalidCompanyName_badRequest() {
		
		createClientRequests.get(0).setCompanyName(null);
		GeneralErrorResponseValidation res = executeAddClientValidException(createClientRequests.get(0));
		assertTrue(res.getMessage().contains(MESSAGE_NULL_COMPANY_NAME));
		
		createClientRequests.get(1).setCompanyName("");
		res = executeAddClientValidException(createClientRequests.get(1));
		assertTrue(res.getMessage().contains(MESSAGE_INVALID_COMPANY_NAME));
		
		createClientRequests.get(2).setCompanyName("+@1sw");
		res = executeAddClientValidException(createClientRequests.get(2));
		assertTrue(res.getMessage().contains(MESSAGE_INVALID_COMPANY_NAME));

	}

	@Test
	@DisplayName("Invalid company's email")
	void addClient_invalidCompanyEmail_badRequest() {
		
		createClientRequests.get(0).setEmail(null);
		GeneralErrorResponseValidation res = executeAddClientValidException(createClientRequests.get(0));
		assertTrue(res.getMessage().contains(MESSAGE_NULL_EMAIL));
		
		createClientRequests.get(1).setEmail("");
		res = executeAddClientValidException(createClientRequests.get(1));
		assertTrue(res.getMessage().contains(MESSAGE_BLANK_EMAIL));
		
		createClientRequests.get(2).setEmail("Nata@");
		res = executeAddClientValidException(createClientRequests.get(2));
		assertTrue(res.getMessage().contains(MESSAGE_INVALID_EMAIL));

	}
	
	@Test
	@DisplayName("Invalid company's url")
	void addClient_invalidCompanyUrl_badRequest() {
		createClientRequests.get(0).setCompanyUrls(null);
		GeneralErrorResponseValidation res = executeAddClientValidException(createClientRequests.get(0));
		assertTrue(res.getMessage().contains(MESSAGE_NULL_OR_ENPTY_COMPANY_IP));
		
		createClientRequests.get(1).setCompanyUrls(Set.of());
		res = executeAddClientValidException(createClientRequests.get(1));
		assertTrue(res.getMessage().contains(MESSAGE_NULL_OR_ENPTY_COMPANY_IP));
		
		createClientRequests.get(2).setCompanyUrls(Set.of("123.123.123.11", ""));
		res = executeAddClientValidException(createClientRequests.get(2));
		assertTrue(res.getMessage().contains(MESSAGE_INVALID_COMPANY_IP));
		
		createClientRequests.get(2).setCompanyUrls(Set.of("123.123.123.11", "123.123.12"));
		res = executeAddClientValidException(createClientRequests.get(2));
		assertTrue(res.getMessage().contains(MESSAGE_INVALID_COMPANY_IP));
		
		createClientRequests.get(2).setCompanyUrls(Set.of("123.123.123.256"));
		res = executeAddClientValidException(createClientRequests.get(2));
		assertTrue(res.getMessage().contains(MESSAGE_INVALID_COMPANY_IP));
		
		createClientRequests.get(2).setCompanyUrls(new HashSet<>(Arrays.asList("123.123.123.11", null)));
		res = executeAddClientValidException(createClientRequests.get(2));
		assertTrue(res.getMessage().contains(MESSAGE_INVALID_COMPANY_IP));
		
	}

	@SneakyThrows
	private GeneralErrorResponseValidation executeAddClientValidException(CreateClientRequest createClientRequest) {
		RequestBuilder request = MockMvcRequestBuilders.post(ADD_CLIENT_ENDPOINT)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createClientRequest));

		String ex = mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isBadRequest()).andReturn()
				.getResponse().getContentAsString();
		return objectMapper.readValue(ex, GeneralErrorResponseValidation.class);

	}

}
