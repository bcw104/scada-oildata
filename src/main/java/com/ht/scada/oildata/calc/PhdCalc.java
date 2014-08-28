/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.scada.oildata.calc;

/**
 * 计算平衡度
 *
 * @author 赵磊
 */
public class PhdCalc {

    /**
     * 电流法
     *
     * @return
     */
    public static float dianLiuCalc() {
        float phd = 0;

        return phd;
    }

    /**
     * 功率法
     *
     * @param power
     * @param maxFlag
     * @param minFlag
     * @return
     */
    public static float gongLvCalc(float[] power, int maxFlag, int minFlag) {
        float phd = 0;  //平衡度

        int n = power.length;
        float upPower = 0;  //上冲程电能
        float downPower = 0;    //下冲程电能
        for (int i = minFlag; i != maxFlag;) {
            upPower += power[i];
            i++;
            if (i == n) {
                i -= n;
            }
        }
        for (int i = maxFlag; i!=minFlag;) {
            downPower += power[i];
            i++;
            if (i == n) {
                i -= n;
            }
        }
        phd = Math.abs(upPower)/Math.abs(downPower);
        if(phd>1) {
            phd = 1/phd;
        }

        return phd;
    }
}
