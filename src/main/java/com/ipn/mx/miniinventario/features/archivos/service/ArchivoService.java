package com.ipn.mx.miniinventario.features.archivos.service;

import com.ipn.mx.miniinventario.core.entidades.Archivo;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public interface ArchivoService {
    Archivo guardarArchivoBD(MultipartFile archivo) throws IOException;

    Optional<Archivo> descargarArchivo(Long idArchivo) throws FileNotFoundException;
}
