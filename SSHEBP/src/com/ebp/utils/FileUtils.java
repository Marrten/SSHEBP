package com.ebp.utils;

import java.io.File;
/**
 * 设置文件的目录结构
 * @author Administrator
 */
public class FileUtils {
	//分层目录 
	public static String generateFilename(String uploadPath, String filename) {
		int hashCode = filename.hashCode();
		int dir1 = hashCode & 0xF;
		int dir2 = (hashCode >> 4) & 0xF;
		uploadPath = uploadPath + "/" + dir1 + "/" + dir2;
		File path =  new File(uploadPath);
		if(!path.exists()){
			path.mkdirs();
		}
		return filename = uploadPath + "/" + filename;
	}
}
