package com.pawan.boot.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

	@Autowired
	private JavaMailSender sender;

	public boolean sendMail(String to, String sub, String text) {

		boolean sent;
		try {

			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message);
			helper.setTo(to);
			helper.setSubject(sub);
			helper.setText(text);
			sender.send(message);
			sent=true;
		} catch (Exception e) {
			sent=false;
			e.printStackTrace();
		}
		return sent;
	}
}
