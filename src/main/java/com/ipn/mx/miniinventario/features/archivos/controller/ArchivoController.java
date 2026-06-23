package com.ipn.mx.miniinventario.features.archivos.controller;

import com.ipn.mx.miniinventario.core.entidades.Archivo;
import com.ipn.mx.miniinventario.features.archivos.dto.RespuestaDTO;
import com.ipn.mx.miniinventario.features.archivos.service.ArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/apiArchivos/archivo")
public class ArchivoController {
    @Autowired
    private ArchivoService service;

    @PostMapping("/subirArchivo")
    public ResponseEntity<RespuestaDTO> subirArchivo(@RequestParam MultipartFile archivo) throws IOException{
        service.guardarArchivoBD(archivo);
        RespuestaDTO respuestaDTO = new RespuestaDTO();
        respuestaDTO.setMensaje("Archivo subido correctamente");
        return ResponseEntity.ok().body(respuestaDTO);
    }

    @GetMapping("/descargarArchivo/{idArchivo}")
    public ResponseEntity<byte[]> descargarArchivo(@PathVariable Long idArchivo) throws FileNotFoundException{
        Archivo archivo = service.descargarArchivo(idArchivo).get();
        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, archivo.getTipoArchivo())
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + archivo.getNombreArchivo() + "\"")
                .body(archivo.getDatosArchivo());
    }
}
