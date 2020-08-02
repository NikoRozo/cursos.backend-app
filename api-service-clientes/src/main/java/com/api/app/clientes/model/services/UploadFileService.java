package com.api.app.clientes.model.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileService implements IUploadFileService {
	private final Logger log = LoggerFactory.getLogger(UploadFileService.class);
	private final static String DIR_UPLOAD = "uploads";

	@Override
	public Resource carga(String fileName) throws MalformedURLException {
		Path ruta = getPath(fileName);
		log.info("Ruta Download" + ruta.toString());
		
		Resource resource = new UrlResource(ruta.toUri());
		
		if (!resource.exists() && !resource.isReadable()) {
			ruta = getPath(fileName);
			log.info(ruta.toString());
			resource = new UrlResource(ruta.toUri());
			log.error("Error al cargar la image: " + fileName);
		}
		return resource;
	}

	@Override
	public String copiar(MultipartFile file) throws IOException {
		String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replace(" ", "");
		Path ruta = getPath(fileName);
		
		log.info("Ruta Upload" + ruta.toString());
		
		Files.copy(file.getInputStream(), ruta);
		return fileName;
	}

	@Override
	public boolean eliminar(String fileName) {
		if (fileName != null && fileName.length() > 0) {
			Path rutaAnt = getPath(fileName);
			
			File fileAnte = rutaAnt.toFile();
			
			if (fileAnte.exists() && fileAnte.canRead()) {
				fileAnte.delete();
				return true;
			}
		}
		return false;
	}

	@Override
	public Path getPath(String fileName) {
		return Paths.get(DIR_UPLOAD).resolve(fileName).toAbsolutePath();
	}

}
