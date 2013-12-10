package com.LFMMS.library.utility;

import java.security.MessageDigest;


public class MD5Util {
	
	private static char hexDigits[] = {
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'	
		};
	
	public final static String MD5(String s) {
		
		try {
			byte[] btInput = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			
			byte[] md = mdInst.digest();
			char str[] = new char[md.length * 2];
			
			int k = 0;
			for (byte b : md) {
				str[k++] = hexDigits[b >>> 4 & 0xf];
				str[k++] = hexDigits[b & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
