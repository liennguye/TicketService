package com.TicketService.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TicketService.Model.Staff;
import com.TicketService.Repository.IStaffRepository;
import com.TicketService.Service.IUsermanagementService;

@Service
@Transactional
public class StaffmanagementService implements IUsermanagementService {
	@Autowired
	private IStaffRepository staffRepository;

	public List<Staff> findStaffByName(String name) {
		List<Staff> staffs = staffRepository.findByNameLike(name);
		return staffs;
	}

	public List<Staff> findStaffByEmail(String email) {
		List<Staff> staffs = staffRepository.findByEmailLike(email);
		return staffs;
	}

	public List<Staff> findStaffByNameAndEmail(String staffName, String staffEmail) {
		List<Staff> staffs = staffRepository.findStaffByNameAndEmail(staffName, staffEmail);
		return staffs;
	}

	public Staff findOne(long id) {
		Staff staff = staffRepository.findById(id);
		return staff;
	}

	public void add(Staff staff) {
		staffRepository.save(staff);
	}

	public void update(Staff staff) {
		staffRepository.updateById(staff.getId(), staff.getName(), staff.getAddress(), staff.getEmail());
	}

	public void remove(long id) {
		staffRepository.delete(id);
	}
}
