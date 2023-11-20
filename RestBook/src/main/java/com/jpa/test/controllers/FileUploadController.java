package com.jpa.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jpa.test.helper.FileUploadHelper;

@RestController
public class FileUploadController 
{
	@Autowired
	private FileUploadHelper fuh;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	{
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
		
		try {
		
		if(!file.getContentType().equals("image/jpeg"))
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain jpeg file");
		}
		
		boolean f=fuh.uploadFile(file);
		
		if(f)
		{
//			for static path
//			return ResponseEntity.ok("File Uploaded successfully");
			
//			for dynamic path
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
		}
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong");
	}
}
