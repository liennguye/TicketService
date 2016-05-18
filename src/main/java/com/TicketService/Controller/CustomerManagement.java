package com.TicketService.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.TicketService.Model.Customer;
import com.TicketService.Model.Role;
import com.TicketService.Service.IEmailSenderService;
import com.TicketService.ServiceImpl.CustomermanagementService;

@Controller
public class CustomerManagement {

	private CustomermanagementService customermanagementService;
	private IEmailSenderService emailSenderService;

	@Autowired
	public CustomerManagement(CustomermanagementService customermanagementService,
			IEmailSenderService emailSenderService) {

		this.customermanagementService = customermanagementService;
		this.emailSenderService = emailSenderService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String CustomerHome() {
		return "FindCustomer";
	}

	@RequestMapping(value = "/customer/findCustomer", method = RequestMethod.GET)
	public String findCustomer(@RequestParam("customerName") String customerName,
			@RequestParam("customerEmail") String customerEmail, Model model) {
		List<Customer> customers = new ArrayList<Customer>();
		if (customerName.isEmpty() && customerEmail.isEmpty()) {
			model.addAttribute("errorMessage", "Please input criteria to find!");
		} else if (customerName.isEmpty()) {
			customers = customermanagementService.findCustomerByEmail(customerEmail);
		} else if (customerEmail.isEmpty()) {
			customers = customermanagementService.findCustomerByName(customerName);
		} else {
			customers = customermanagementService.findCustomerByNameAndEmail(customerName, customerEmail);
		}
		model.addAttribute("customers", customers);
		return "FindCustomer";
	}

	@RequestMapping(value = "/customer/addCustomer", method = RequestMethod.GET)
	public String showAddCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("page", "addCustomer");
		model.addAttribute("usernameDisabled", "");
		return "NewCustomer";
	}

	@RequestMapping(value = "/customer/addCustomer", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute Customer customer, BindingResult errors, HttpServletRequest request) {
		customermanagementService.add(customer);
		return "FindCustomer";
	}

	@RequestMapping(value = "/customer/updateCustomer/{id}", method = RequestMethod.GET)
	public String viewEditCustomer(@PathVariable Long id, Model model) {
		model.addAttribute("customer", customermanagementService.findOne(id));
		model.addAttribute("page", "updateCustomer");
		model.addAttribute("usernameDisabled", "true");
		model.addAttribute("RegisteredViewer", Role.RegisteredViewer);
		return "NewCustomer";
	}

	@RequestMapping(value = "/customer/updateCustomer", method = RequestMethod.POST)
	public String editCustomer(@ModelAttribute Customer customer, BindingResult errors, HttpServletRequest request)
			throws Exception {
		if (errors.hasErrors()) {
			return null;
		}
		customermanagementService.update(customer);
		return "FindCustomer";
	}

	@RequestMapping(value = "/customer/removeCustomer/{id}", method = RequestMethod.GET)
	public String removeCustomer(@PathVariable Long id, Model model) throws Exception {

		customermanagementService.remove(id);
		return "FindCustomer";
	}

	// Registration

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegister(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("RegisteredViewer", Role.RegisteredViewer);
		return "register";
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addRegister(@ModelAttribute Customer customer, BindingResult errors, HttpServletRequest request,
			Model model) {

		// send email
		try {
			String toAddr = "liennguyen2030@gmail.com";
			String subject = "Hey.. This email sent by EA CS544 Group1";
			String body = "Test by EA CS544 Group1";
			emailSenderService.sendEmail(toAddr, subject, body);
			customermanagementService.add(customer);

			if (errors.hasErrors()) {
				System.out.println("error:" + errors.toString());
			}
			model.addAttribute("customerForm", customer);
		} catch (Exception ex) {
			ex.getMessage();
			System.out.println(ex.toString());
		} finally {
			return "RegistrationSuccess";
		}

	}
}
