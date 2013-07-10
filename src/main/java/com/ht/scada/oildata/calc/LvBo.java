package com.htong.alg;

import java.util.List;

/**
 * 滤波算法
 * @author 赵磊
 *
 */
public class LvBo {
	/**
	 * 3点滤波
	 * @param weiyi
	 * @param zaihe
	 */
	public static void lvBo(float[] weiyi, float[] zaihe) {
		int n = weiyi.length;
		
		//载荷滤波
		float[] zaiheTemp = new float[n];
		for(int i = 0;i<n;i++) {
			zaiheTemp[i] = zaihe[i];
		}
		zaihe[0] = (zaiheTemp[1] + zaiheTemp[n - 1] + zaiheTemp[0]) / 3;
		zaihe[n-1] = (zaiheTemp[n-1] + zaiheTemp[n - 2] + zaiheTemp[0]) / 3;
		for(int i = 1;i<n-1;i++) {
			zaihe[i] = (zaiheTemp[i-1] + zaiheTemp[i] + zaiheTemp[i+1]) / 3;
		}
		
		//位移滤波
//		float[] weiyiTemp = new float[n];
//		for(int i = 0;i<n;i++) {
//			weiyiTemp[i] = weiyi[i];
//		}
//		weiyi[0] = (weiyiTemp[1] + weiyiTemp[n - 1] + weiyiTemp[0]) / 3;
//		weiyi[n-1] = (weiyiTemp[n-1] + weiyiTemp[n - 2] + weiyiTemp[0]) / 3;
//		for(int i = 1;i<n-1;i++) {
//			weiyi[i] = (weiyiTemp[i-1] + weiyiTemp[i] + weiyiTemp[i+1]) / 3;
//		}

		// 封闭图形
		weiyi[0] = weiyi[n - 1] = (weiyi[0] + weiyi[n - 1]) / 2;
		zaihe[0] = zaihe[n - 1] = (zaihe[0] + zaihe[n - 1]) / 2;
	}
	
	/**
	 * 5点滤波
	 * @param weiyi
	 * @param zaihe
	 */
	public static void lvBo5(float[] weiyi, float[] zaihe) {
		int n = weiyi.length;
//		float[] weiyiO = new float[n];
		float[] zaiheO = new float[n];
		for(int i = 0;i<n;i++) {
//			weiyiO[i] = weiyi[i];
			zaiheO[i] = zaihe[i];
		}
		
		zaihe[0] = (zaiheO[1] +zaiheO[2]+ zaiheO[n - 1] + zaiheO[n-2] + zaiheO[0]) / 5;
		zaihe[1] = (zaiheO[1] +zaiheO[2]+ zaiheO[n - 1] + zaiheO[3] + zaiheO[0]) /5;
		zaihe[n-1] = (zaiheO[n-1] +zaiheO[n-2]+ zaiheO[n - 3] + zaiheO[0] + zaiheO[1]) / 5;
		zaihe[n-2] = (zaiheO[n-2] +zaiheO[n-1]+ zaiheO[n - 3] + zaiheO[0] + zaiheO[n-4]) / 5;
		for(int i = 2;i<n-2;i++) {
			zaihe[i] = (zaiheO[i-2] +zaiheO[i-1]+ zaiheO[i] + zaiheO[i+1] + zaiheO[i+2]) / 5;
		}

		// 封闭图形
		weiyi[0] = weiyi[n - 1] = (weiyi[0] + weiyi[n - 1]) / 2;
		zaihe[0] = zaihe[n - 1] = (zaihe[0] + zaihe[n - 1]) / 2;
	}
	
	/**
	 * 一阶惯性滤波
	 * @param weiyi
	 * @param zaihe
	 */
	public static void lvBoG(float[] weiyi, float[] zaihe) {
		int n = weiyi.length;
		
		// 一阶惯性滤波
		float c = 0.2f;
		for (int i = 1; i < n - 1; i++) {
	//		weiyi[i] = c * weiyi[i] + (1 - c) * weiyi[i - 1];
			zaihe[i] = c * zaihe[i] + (1 - c) * zaihe[i - 1];
		}
		
		// 封闭图形
		weiyi[0] = weiyi[n - 1] = (weiyi[0] + weiyi[n - 1]) / 2;
		zaihe[0] = zaihe[n - 1] = (zaihe[0] + zaihe[n - 1]) / 2;
	}
	
	/**
	 * 中值滤波
	 * @param resultList
	 * @return
	 */
	public static float zhongzhiLB(List<Float> resultList) {
		if(resultList == null || resultList.isEmpty()) {
			return 0;
		}
		int deal_num = resultList.size();
		if(deal_num == 1) {
			return resultList.get(0);
		} else if(deal_num == 2) {
			return (resultList.get(0)+resultList.get(1))/2;
		}
		// 冒泡法，从小到大
		for (int i1 = 0; i1 < deal_num; i1++) {
			for (int i2 = 0; i2 < deal_num - i1 - 1; i2++) {
				if (resultList.get(i2 + 1) < resultList.get(i2)) {
					float temp = resultList.get(i2 + 1);
					resultList.set(i2 + 1, resultList.get(i2));
					resultList.set(i2, temp);
				}
			}
		}

		int numCount = resultList.size();
		
		int numStart = numCount * 1 / 3;
		int numEnd = numCount * 2 / 3;
		
//		int numStart = numCount * 3 / 5;
//		int numEnd = numCount * 4 / 5;
		float result = 0; // 结果
		for (int i = numStart; i <= numEnd; i++) {
			result += resultList.get(i);
		}
		
		if((numEnd-numStart)<=0) {
			result = 0;
		} else {
			result /= (numEnd - numStart+1);
		}
		
		return result;
	}
	/**
	 * 中值滤波，处理光杆缓下问题
	 * @param resultList
	 * @return
	 */
	public static float zhongzhiLB_GGHX(List<Float> resultList) {
		int deal_num = resultList.size();
		// 冒泡法，从小到大
		for (int i1 = 0; i1 < deal_num; i1++) {
			for (int i2 = 0; i2 < deal_num - i1 - 1; i2++) {
				if (resultList.get(i2 + 1) < resultList.get(i2)) {
					float temp = resultList.get(i2 + 1);
					resultList.set(i2 + 1, resultList.get(i2));
					resultList.set(i2, temp);
				}
			}
		}

		int numCount = resultList.size();
		
//		int numStart = numCount * 3 / 5;
//		int numEnd = numCount * 4 / 5;
		int numStart = numCount*2 / 3;
		int numEnd = deal_num;
		float zuihoujieguo = 0; // 产液量结果，一个小时的
		for (int i = numStart; i < numEnd; i++) {
			//log.warn("产液量选取点："+ resultList.get(i));
			zuihoujieguo += resultList.get(i);
		}
		//log.debug(numEnd + " " + numStart + ":" + (numEnd - numStart));
		
		if((numEnd-numStart)<=0) {
			zuihoujieguo = 0;
		} else {
			zuihoujieguo /= (numEnd - numStart);
		}
		
		return zuihoujieguo;
	}
}
