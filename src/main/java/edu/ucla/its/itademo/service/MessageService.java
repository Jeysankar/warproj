package edu.ucla.its.itademo.service;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import edu.ucla.its.itademo.util.User;

public class MessageService {

	private MailSender mailSender;
	
	/**
	 * @param args
	 */
	public void sendMessage(User user) {
		// TODO Auto-generated method stub

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("NoReply-Demo@it.ucla.edu");
		message.setTo(user.getEmail());
		message.setSubject("Your registration to Demo was successful");
		message.setText( "Dear " + user.getName() +",\n You registration to Demo application was successful.\n Thank you.");
		mailSender.send( message);
		
	}

	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
}