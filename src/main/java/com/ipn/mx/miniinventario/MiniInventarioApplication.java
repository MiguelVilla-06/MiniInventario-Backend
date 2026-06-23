package com.ipn.mx.miniinventario;

import com.ipn.mx.miniinventario.core.entidades.Categoria;
import com.ipn.mx.miniinventario.features.categoria.repository.CategoriaDAO;
import com.ipn.mx.miniinventario.features.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniInventarioApplication implements CommandLineRunner {

    @Autowired
    private CategoriaDAO dao;
    @Autowired
    private EmailService emailService;

    public static void main(String[] args) {
        SpringApplication.run(MiniInventarioApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Categoria");
        Categoria categoria = new Categoria();
        System.out.println("====== PROCESANDO ENVÍO DE NOTIFICACIÓN DE ARRANQUE ======");
        try {
            String destino = "migueldevoca3@gmail.com";
            String asunto = "Notificación de Inicio: Servidor Activo";
            String cuerpoHtml = """
                <h1 style='color: #0d6efd;'>¡El servidor ha encendido con éxito!</h1>
                <p>La aplicación <b>MiniInventario</b> se encuentra en ejecución y conectada con Yugabyte Cloud.</p>
                <hr>
                <small style='color: gray;'>Este es un correo automatizado generado por el sistema.</small>
                """;
            emailService.enviarCorreo(destino, asunto, cuerpoHtml);

            System.out.println("====== NOTIFICACIÓN ENVIADA EXITOSAMENTE ======");
        } catch (Exception e) {
            System.err.println("No se pudo despachar el correo de inicio: " + e.getMessage());
        }
    }
}
