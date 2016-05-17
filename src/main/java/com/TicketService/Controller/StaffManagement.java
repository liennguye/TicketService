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
import com.TicketService.Model.Staff;
import com.TicketService.ServiceImpl.StaffmanagementService;

@Controller
public class StaffManagement {
	@Autowired
	StaffmanagementService usermanagementService;
	
	@RequestMapping(value="/staff" , method = RequestMethod.GET)
	public String staffHome(){
		return "FindStaff";
	}
		
	@RequestMapping(value = "/staff/findStaff", method = RequestMethod.GET)
	public String findStaff(@RequestParam("staffName") String staffName, @RequestParam("staffEmail") String staffEmail, Model model) {
		List<Staff> staffs = new ArrayList<Staff>();
		if (staffName.isEmpty() && staffEmail.isEmpty()){
			model.addAttribute("errorMessage", "Please input criterian to find!");
		}
		else if (staffName.isEmpty()){
			System.out.println("Find by Email");
			staffs = usermanagementService.findStaffByEmail(staffEmail);
		} else if(staffEmail.isEmpty()){
			System.out.println("Find by Name: " + staffName);
			staffs = usermanagementService.findStaffByName(staffName);
		} else {
			System.out.println("Find by Name and Email");
			staffs = usermanagementService.findStaffByNameAndEmail(staffName, staffEmail);
		}
		model.addAttribute("staffs",staffs);
		return "FindStaff";
	}
	
	@RequestMapping(value = "/staff/addStaff", method = RequestMethod.GET)
	public String showAddStaff(Model model) {
		model.addAttribute("staff",new Staff());
		model.addAttribute("page", "addStaff");
		return "NewStaff";
	}
	@RequestMapping(value = "/staff/addStaff", method = RequestMethod.POST)
	public String addStaff(@ModelAttribute Staff staff,
			BindingResult errors, HttpServletRequest request) {		
		usermanagementService.add(staff);
		return "FindStaff";
	}
	
	@RequestMapping(value="/staff/updateStaff/{id}", method=RequestMethod.GET)
	public String viewEditStaff(@PathVariable Long id, Model model){		
		model.addAttribute("staff", usermanagementService.findOne(id));		
		model.addAttribute("page", "addStaff");
		return "NewStaff";
	}
	
	@RequestMapping(value="/staff/updateStaff", method=RequestMethod.POST)
	public String editStaff(@ModelAttribute Staff staff,
			BindingResult errors, HttpServletRequest request)
			throws Exception {
		if (errors.hasErrors()) {
			return null;
		}
	usermanagementService.update(staff);
		return "FindStaff";
	}

	@RequestMapping(value="/staff/removeStaff/{id}", method=RequestMethod.GET)
	public String removeStaff(@PathVariable Long id, Model model)
			throws Exception {
		
	usermanagementService.remove(id);
		return "FindStaff";
	}

}
