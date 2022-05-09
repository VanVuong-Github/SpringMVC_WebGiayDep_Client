package nhom8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import nhom8.entity.Customer;
import nhom8.request.CreateCustomerRequest;

@Service
public class CustomerService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${url_customer}")
	private String requestUrl;
	
	public List<Customer> getAllCustomer() {
		ResponseEntity<List<Customer>> response = restTemplate.exchange(requestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Customer>>() {
				});
		return response.getBody();
	}
	
	public Customer findById(String id) {
		ResponseEntity<Customer> responseEntity = restTemplate.getForEntity(requestUrl + "/" + id, Customer.class);
		return responseEntity.getBody();
	}
	
	public void createCustomer(CreateCustomerRequest request) {
		restTemplate.postForEntity(requestUrl, request, Customer.class);
	}

}
