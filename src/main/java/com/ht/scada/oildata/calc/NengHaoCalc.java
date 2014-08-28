/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.scada.oildata.calc;

/**
 * 能耗计算
 *
 * @author 赵磊
 */
public class NengHaoCalc {

    /**
     * 计算上冲程能耗
     *
     * @param power
     * @param maxFlag
     * @param minFlag
     * @param chongCi
     * @return
     */
    public static float nengHaoShang(float[] power, int maxFlag, int minFlag, float chongCi) {
//        System.out.println(maxFlag + " " + minFlag);
        if (chongCi <= 0) {
            return 0;
        }
        float upPower = 0;  //上冲程能耗
        int n = power.length;
        float time = 60 / chongCi / n /3600;  //相邻两点的时间间隔

        for (int i = minFlag; i != maxFlag;) {
            upPower += power[i] * time;
            i++;
            if (i == (n)) {
                i -= (n);
            }
        }
//        System.out.println("上冲程能耗：" + upPower);
        return upPower;
    }
    
    /**
     * 计算下冲程能耗
     * @param power
     * @param maxFlag
     * @param minFlag
     * @param chongCi
     * @return 
     */
    public static float nengHaoXia(float[] power, int maxFlag, int minFlag, float chongCi) {
        if (chongCi <= 0) {
            return 0;
        }
        float downPower = 0;  //下冲程能耗
        int n = power.length;
        float time = 60 / chongCi / n /3600;  //相邻两点的时间间隔

        for (int i = maxFlag; i != minFlag;) {
            downPower += power[i] * time;
            i++;
            if (i == (n)) {
                i -= (n);
            }
        }
//        System.out.println("下冲程能耗：" + downPower);
        return downPower;
    }
    
    public static void main(String args[]) {
        float power[] = {0.3F,0.1F,0.3F,0.6F,0.90000004F,0.8F,0.6F,0.7F,1.6F,1.6F,2.3F,1.1F,1.6F,1.9F,2.3F,2.7F,2.0F,2.1000001F,2.4F,3.3F,2.3F,2.9F,3.5F,2.3F,2.9F,3.4F,2.4F,2.9F,3.2F,2.6000001F,3.3F,2.3F,3.2F,2.5F,2.5F,2.9F,2.3F,2.6000001F,1.8000001F,2.8F,2.0F,2.8F,1.6F,2.4F,1.6F,2.2F,1.5F,2.0F,1.6F,1.8000001F,1.7F,1.5F,1.5F,1.0F,1.2F,0.90000004F,1.2F,1.5F,1.6F,1.9F,1.9F,1.0F,1.9F,0.90000004F,1.8000001F,1.1F,1.2F,1.2F,1.1F,1.8000001F,2.1000001F,2.0F,1.6F,1.5F,1.9F,2.2F,2.6000001F,2.1000001F,1.6F,1.7F,2.4F,2.8F,2.0F,2.1000001F,3.0F,2.0F,2.3F,3.0F,2.2F,2.5F,3.2F,2.7F,2.2F,2.8F,3.3F,2.6000001F,2.3F,2.7F,3.3F,3.1000001F,2.5F,2.4F,2.7F,3.1000001F,2.3F,2.2F,2.8F,2.4F,1.8000001F,2.3F,2.5F,1.8000001F,1.8000001F,2.4F,1.5F,1.6F,2.2F,1.5F,1.3000001F,1.3000001F,1.2F,1.4F,0.6F,0.90000004F,1.8000001F,0.6F,1.1F,0.3F,0.7F,0.6F,0.7F,1.5F,1.1F,1.2F,2.1000001F,1.6F,2.2F,2.2F,2.1000001F,3.0F,2.4F,3.4F,2.4F,3.3F,2.3F,3.1000001F,2.5F,2.8F,3.5F,3.3F,3.2F,3.2F,2.8F,2.8F,2.5F,2.4F,2.3F,2.6000001F,2.4F,2.6000001F,2.9F,3.1000001F,3.1000001F,2.9F,2.1000001F,2.7F,2.3F,2.3F,2.1000001F,1.7F,1.3000001F,1.5F,2.1000001F,2.4F,2.0F,1.1F,1.8000001F,1.6F,1.8000001F,1.4F,1.5F,1.3000001F,1.2F,1.2F,0.8F,1.6F,0.5F,1.4F,0.5F,1.1F,0.2F,1.0F,0.2F,0.5F,-0.3F,0.5F,0.7F,0.90000004F,0.5F,0.3F};
        NengHaoCalc.nengHaoShang(power, 103, 199, 1);
    }
}
