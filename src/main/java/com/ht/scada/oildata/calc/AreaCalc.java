package com.ht.scada.oildata.calc;

/**
 * 计算面积
 * @author 赵磊
 *
 */
public class AreaCalc {
	public float getGTArea(float[] weiyi, float[] zaihe, int maxFlag, int minFlag) {
		int standardAreaNum = 25;
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
		return sumarea;
	}

}
