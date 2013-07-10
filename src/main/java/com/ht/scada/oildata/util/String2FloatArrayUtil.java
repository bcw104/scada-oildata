package com.ht.scada.oildata.util;

public class String2FloatArrayUtil {
	/**
	 * 字符串转浮点型数组
	 * @param value
	 * @param token
	 * @author 赵磊
	 */
	public static float[] string2FloatArrayUtil(String value, String token) {
		String[] str = value.split(token);
		float[] result = new float[str.length];
		int i = 0;
		for(String s : str) {
			result[i] = Float.valueOf(s.trim());
			i++;
		}
		return result;
	}

}
