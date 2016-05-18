package com.TicketService.Service;

public interface IEmailSenderService {

	public void sendEmail(String toAddr, String subject, String body);
}
