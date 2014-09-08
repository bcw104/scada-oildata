/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.scada.oildata.calc;

import java.util.HashMap;
import java.util.Map;

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
    public static Map<String,Float> dianLiuCalc(float[] dl, int maxFlag, int minFlag) {
        float phd = 0;
        float sxdl = 0;
        float xxdl = 0;
        
        int n = dl.length;
        int p = 0;
        int q = 0;
        
        for (int i = minFlag; i != maxFlag;) {
            sxdl += dl[i];
            i++;
            if (i == n) {
                i -= n;
            }
            p++;
        }
        for (int i = maxFlag; i!=minFlag;) {
            xxdl += dl[i];
            i++;
            if (i == n) {
                i -= n;
            }
            q++;
        }
        if(sxdl > 0) {
            phd = xxdl/sxdl;
        }
        
        Map<String,Float> map = new HashMap<>();
        map.put("phd", phd);
        map.put("sxdl", sxdl/p);
        map.put("xxdl", xxdl/q);

        return map;
    }

    /**
     * 功率法
     *
     * @param power
     * @param maxFlag
     * @param minFlag
     * @return
     */
    public static float[] gongLvCalc(float[] power, int maxFlag, int minFlag) {
        float phd = 0;  //平衡度

        int n = power.length;
        float upPower = 0;  //上冲程平均功率
        float downPower = 0;    //下冲程平均功率
        int count = 0;
        for (int i = minFlag; i != maxFlag;) {
            count ++;
            upPower += power[i];
            i++;
            if (i == n) {
                i -= n;
            }
        }
        if(count>0) {
            upPower = upPower / count;
        }
        
        count = 0;
        for (int i = maxFlag; i!=minFlag;) {
            count ++;
            downPower += power[i];
            i++;
            if (i == n) {
                i -= n;
            }
        }
        if(count>0) {
            downPower = downPower / count;
        }
        if(upPower == 0) {
            phd = Float.MAX_VALUE;
        } else {
            phd = downPower / upPower;
        }

        return new float[]{phd,upPower,downPower};
    }
}
