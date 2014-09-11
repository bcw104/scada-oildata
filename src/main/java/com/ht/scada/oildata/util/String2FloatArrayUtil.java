package com.ht.scada.oildata.util;

public class String2FloatArrayUtil {

    public static final String ORIENTATION_X = "X";
    public static final String ORIENTATION_Y = "Y";

    /**
     * 字符串转浮点型数组
     *
     * @param value
     * @param token
     * @author 赵磊
     */
    public static float[] string2FloatArrayUtil(String value, String token) {
        if (value == null) {
            return null;
        }
        String[] str = value.split(token);
        float[] result = new float[str.length];
        int i = 0;
        for (String s : str) {
            result[i] = Float.valueOf(s.trim());
            i++;
        }
        return result;
    }

    /**
     * 字符串转浮点型数组（根据方向）
     *
     * @param value
     * @param orientation x,横坐标，y，纵坐标
     * @param token 标识
     * @author 陈志强
     */
    public static float[] string2OrientationFloatArrayUtil(String value, String orientation, String token) {
        if (value == null) {
            return null;
        }
        String[] str = value.split(token);
        float[] result = new float[str.length];
        for (int i = 0; i < str.length; i++) {
            String[] axis = str[i].trim().split(",");
            if (ORIENTATION_X.equals(orientation)) {
                result[i] = Float.valueOf(axis[0].trim());
            } else if (ORIENTATION_Y.equals(orientation)) {
                result[i] = Float.valueOf(axis[1].trim());
            }
        }
        return result;
    }

    public static String string2OrientationStringArrayUtil(String value, String orientation, String token) {
        if (value == null) {
            return null;
        }
        String[] str = value.split(token);
        String[] result = new String[str.length];
        String jg = "";
        for (int i = 0; i < str.length; i++) {
            String[] axis = str[i].trim().split(",");
            if (ORIENTATION_X.equals(orientation)) {
                result[i] = axis[0].trim();
            } else if (ORIENTATION_Y.equals(orientation)) {
                result[i] = axis[1].trim();
            }
        }
        for(String s : result) {
            jg = jg.concat(","+s);
        }
        return jg.replaceFirst(",", "");
    }
    
    /**
     * Object array to float array
     * @param objects
     * @return
     */
    public static float[] objectArray2FloatArrayUtil(Object[] objects) {
        float[] rtnArray = new float[objects.length];
        for (int i = 0; i < objects.length; i++) {
            rtnArray[i] = (float)objects[i];
        }
        return rtnArray;
    }

}
