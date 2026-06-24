package com.ipn.mx.miniinventario.features.mail.service.impl;

import com.ipn.mx.miniinventario.features.mail.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpls implements EmailService {

    @Autowired
    private JavaMailSender mailSender;
    @Value("classpath:static/img/imagen.png")
    private Resource resourceFile;
    @Override
    public void enviarCorreo(String to, String asunto, String texto) {
        MimeMessage mensaje = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mensaje, true, "UTF-8");
            helper.addAttachment("super.jpg", resourceFile);
            helper.setFrom("miguel.villanova15@gmail.com", "Envio de correos via Spring"); // Usa tu correo real de properties
            helper.setSubject(asunto);
            helper.setText(texto, true); // 'true' habilita soporte para diseño HTML
            helper.setTo(to);
            helper.setCc("migueldevoca3@gmail.com");
            helper.setBcc("miguel.villanova15@gmail.com");
            mailSender.send(mensaje);
            System.out.println("¡Correo enviado exitosamente a " + to + "!");
        } catch (Exception ex) {
            System.err.println("Error crítico al intentar enviar el correo electrónico:");
            ex.printStackTrace();
        }
    }
}