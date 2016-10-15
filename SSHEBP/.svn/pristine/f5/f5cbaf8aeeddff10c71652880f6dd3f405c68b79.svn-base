package com.ebp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
/*
 * 
 * 加密算法
 */
public class MD5Util {
	public static String getProcessor(String password) {
		String pwd = "";
		try {
			
			MessageDigest md= MessageDigest.getInstance("md5");
			byte[] data = md.digest(password.getBytes()); // 128bit, 16byte
			pwd = Base64.encode(data);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return pwd;

	}

}
