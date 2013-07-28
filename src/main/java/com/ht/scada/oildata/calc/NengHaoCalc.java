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
        if (chongCi <= 0) {
            return 0;
        }
        float upPower = 0;  //上冲程能耗
        int n = power.length;
        float time = 60 / chongCi / n;  //相邻两点的时间间隔

        for (int i = minFlag; i != maxFlag;) {
            upPower += power[i] * time;
            i++;
            if (i == n) {
                i -= n;
            }
        }
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
        float time = 60 / chongCi / n;  //相邻两点的时间间隔

        for (int i = maxFlag; i != minFlag;) {
            downPower += power[i] * time;
            i++;
            if (i == n) {
                i -= n;
            }
        }
        return downPower;
    }
}
