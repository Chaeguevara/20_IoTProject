package com.controller;

import java.io.FileOutputStream;
import org.springframework.web.multipart.MultipartFile;

public class Util {
	// �޾ƿ� �����͸� ������ �̹����� �ø���.
	public static void saveFile(MultipartFile mf) {
		String dir = "G:\\My Drive\\PersonalProjects\\20-IoT\\prj1\\project\\web\\img\\";
		byte [] data;
		String imgname = mf.getOriginalFilename();
		try {
			data = mf.getBytes();
			FileOutputStream fo = 
					new FileOutputStream(dir+imgname);
			fo.write(data);
			System.out.println("saveok");
			fo.close();
		}catch(Exception e) {
			System.out.println("savefail");
		}
		
	}
	
}




