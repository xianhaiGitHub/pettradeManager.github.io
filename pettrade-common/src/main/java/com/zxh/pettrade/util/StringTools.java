package com.zxh.pettrade.util;

import java.util.Random;
import java.util.UUID;

public class StringTools {

	/**
	 * 生成6位随机字符
	 */
	public static String getStringRamdom(int length){
		String val = "";
		Random random = new Random();
		for(int i=0; i < length; i++){
			int temp = random.nextInt(2)%2 == 0 ? 65 : 97;
			val += (char)(random.nextInt(26) + temp);
		}
		return val;
	}
	
	
	
	/**
	 * 生成UUID
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
}
