package com.luccascalderaro.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.luccascalderaro.cursomc.domain.Pedido;

public interface EmailService {
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
