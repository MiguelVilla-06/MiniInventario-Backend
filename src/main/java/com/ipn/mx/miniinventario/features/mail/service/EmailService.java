package com.ipn.mx.miniinventario.features.mail.service;


public interface EmailService {
    public void enviarCorreo(String to, String asunto, String texto);
}
