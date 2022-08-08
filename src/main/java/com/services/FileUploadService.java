package com.services;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	public void imgUpload(MultipartFile file, int userId) {

		try {

			String mainPath = "C:\\Users\\shubham\\ismtraining\\maven\\ism-spring-mvc-practice\\src\\main\\webapp\\resources\\images";
			File folder = new File(mainPath, userId + "");
			folder.mkdir();
			File newFile = new File(folder, file.getOriginalFilename());
			byte b[] = file.getBytes();   
			FileOutputStream fos = new FileOutputStream(newFile);
			fos.write(b);
			fos.close();
		} catch (Exception e) {
            e.printStackTrace();
		}
	}
}
