package com.api.app.clientes.model.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {
	public Resource carga(String fileName) throws MalformedURLException;
	public String copiar(MultipartFile file) throws IOException;
	public boolean eliminar(String fileName);
	public Path getPath(String fileName);
}
