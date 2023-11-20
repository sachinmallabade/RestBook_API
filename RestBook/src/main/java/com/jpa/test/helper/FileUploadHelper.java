package com.jpa.test.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper 
{
//	for static path
//	public final String UPLOAD_DIR="C:\\Users\\sachin\\Documents\\SpringBootStarter\\RestBook\\src\\main\\resources\\static\\images";
	
	
//	for dynamic path
	public final String UPLOAD_DIR=new ClassPathResource("static/images/").getFile().getAbsolutePath();
	public FileUploadHelper()throws IOException
	{
		
	}
	public boolean uploadFile(MultipartFile file)
	{
		boolean f=false;
		
		try {
			
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		
			f=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}

}
