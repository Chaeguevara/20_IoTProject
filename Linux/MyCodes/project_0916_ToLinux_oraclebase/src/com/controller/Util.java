package com.controller;

import java.io.FileOutputStream;
import org.springframework.web.multipart.MultipartFile;

public class Util {
	// �޾ƿ� �����͸� ������ �̹����� �ø���.
	public static void saveFile(MultipartFile mf) {
		String dir = "G:\\My Drive\\PersonalProjects\\20-IoT\\prj1\\project_0909_final\\web\\view\\main\\img\\bookimg\\";
		byte [] data;
		String imgname = mf.getOriginalFilename();
		System.out.println("Image Save ok");
		try {
			data = mf.getBytes();
			FileOutputStream fo = 
					new FileOutputStream(dir+imgname);
			fo.write(data);
			fo.close();
		}catch(Exception e) {
			
		}
		
	}
	
}




