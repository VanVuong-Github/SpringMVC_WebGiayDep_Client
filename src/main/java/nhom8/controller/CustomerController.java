package nhom8.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nhom8.request.CreateCustomerRequest;
import nhom8.service.CustomerService;

@Controller
@RequestMapping("customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String getAllCustomer(Model model) {
		model.addAttribute("customers", customerService.getAllCustomer());
		return "customer-list";
	}
	
	@GetMapping("/getById={id}")
	public String getById(Model model, @PathVariable("id") String id) {
		model.addAttribute("customer", customerService.findById(id));
		return "customer-detail";
	}
	
	@PostMapping("/create")
	public String createCustomer(@Valid @ModelAttribute("customer")CreateCustomerRequest request, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "customer-form";
		customerService.createCustomer(request);
		return "redirect:list";
	}

}
