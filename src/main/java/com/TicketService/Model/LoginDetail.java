package com.TicketService.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class LoginDetail {
	@Id
	private String username;
	
	@Enumerated(EnumType.ORDINAL)
	private Role role;
	
	public LoginDetail(){
		
	}
	
	public LoginDetail (String username){
		this.username=username;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	
}
