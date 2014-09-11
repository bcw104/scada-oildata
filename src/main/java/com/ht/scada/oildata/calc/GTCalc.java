package com.ht.scada.oildata.calc;

/**
 * 功图计算
 *
 * @author 赵磊
 *
 */
public class GTCalc {

    public static float[] getGTCalcResult(float[] weiyi, float[] zaihe, float chongCi) {
        float result[] = new float[]{0f,0f};

        int maxFlag = 0; // 上死点
        int minFlag = 0; // 下死点
        // 计算上死点与下死点
        for (int i = 1; i < weiyi.length; i++) {
            // 上死点
            if (weiyi[maxFlag] < weiyi[i]) {
                maxFlag = i;
            } else if (weiyi[maxFlag] == weiyi[i]) {// 位移相等，则选择载荷最大点
                if (zaihe[maxFlag] < zaihe[i]) {
                    maxFlag = i;
                }
            }
            // 下死点
            if (weiyi[minFlag] > weiyi[i]) {
                minFlag = i;
            } else if (weiyi[minFlag] == weiyi[i]) {// 位移相等，则选择载荷最小点
                if (zaihe[minFlag] > zaihe[i]) {
                    minFlag = i;
                }
            }
        }
//		int standardAreaNum = 25;
        int standardAreaNum = 8;
        int n = weiyi.length;
        // 将上下行程分别求出每个区间内载荷的平均值
        float space = (weiyi[maxFlag] - weiyi[minFlag]) / standardAreaNum;
        int j = minFlag;
        float[] averloadup = new float[standardAreaNum]; // 上冲程载荷平均值
        float[] averloaddown = new float[standardAreaNum]; // 下冲程载荷平均值
        for (int i = 0; i < standardAreaNum; i++) {
            int flag = 0;
            while (weiyi[j] < (1 + i) * space && j != maxFlag) {
                averloadup[i] += zaihe[j++];
                if (j == n) {
                    j -= n;
                }
                flag++;
            }
            averloadup[i] /= flag; // 第i个面积区间的载荷平均值
        }
        j = maxFlag;
        for (int i = 0; i < standardAreaNum; i++) {
            int flag = 0;
            while (j != minFlag && weiyi[j] > (standardAreaNum - i - 1) * space) {
                averloaddown[i] += zaihe[j++];
                if (j == n) {
                    j -= n;
                }
                flag++;
            }
            averloaddown[i] /= flag;
        }

        float sumarea = 0; // 示功图面积
        for (int i = 0; i < standardAreaNum; i++) {
            float iArea = (averloadup[i] - averloaddown[standardAreaNum - i - 1])
                    * space;
            sumarea = sumarea + iArea;
        }
        result[0] = sumarea;
        result[1] = sumarea*chongCi/(60);
        return result;
    }
}
