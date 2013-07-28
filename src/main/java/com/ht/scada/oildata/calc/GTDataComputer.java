package com.ht.scada.oildata.calc;

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
         * @param power                                功率(可以为null)
	 * @param chongCi				冲次
	 * @param bengJing				泵径(mm)
	 * @param oilDensity                            原油密度
	 * @param hanShuiLiang                          含水量(%)
	 * @return 
	 */
	public Map<GTReturnKeyEnum, Object> calcSGTData(float weiyi[], float zaihe[],float power[],
			float chongCi, float bengJing, float oilDensity, float hanShuiLiang);
}
