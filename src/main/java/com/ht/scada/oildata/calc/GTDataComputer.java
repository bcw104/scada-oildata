package com.htong.alg;

import java.util.Map;
/**
 * 功图相关算法
 * @author 赵磊
 *
 */
public interface GTDataComputer {
	/**
	 * 
	 * @param weiyi					位移
	 * @param zaihe					载荷
	 * @param chongCi				冲次
	 * @param bengjing				泵径(mm)
	 * @param oilDensity                            油密度
	 * @param hanshuiliang                          含水量(%)
	 * @return 
	 */
	public Map<String, Object> calcSGTData(float weiyi[], float zaihe[],
			float chongCi, float bengjing, float oilDensity, float hanshuiliang);
}
