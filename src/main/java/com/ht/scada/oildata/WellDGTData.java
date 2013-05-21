package com.ht.scada.oildata;

import java.util.Date;

/**
 * 电功图数据
 * @author 赵磊
 *
 */
public class WellDGTData {
	/**
	 * 井号，可以是中文或英文，如草13-113、C13-P32
	 */
	private String code;
	
	/**
	 * 位移，横坐标
	 */
	private float[] weiyi;
	
	/**
	 * 电流
	 */
	private float[] ib;
	/**
	 * 功率
	 */
	private float[] power;
	/**
	 * 功率因数
	 */
	private float[] power_factor;
	/**
	 * 电功图
	 */
	private float[] dgt;
	/**
	 * 数据时间
	 */
	private Date time;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public float[] getWeiyi() {
		return weiyi;
	}
	public void setWeiyi(float[] weiyi) {
		this.weiyi = weiyi;
	}
	public float[] getIb() {
		return ib;
	}
	public void setIb(float[] ib) {
		this.ib = ib;
	}
	public float[] getPower() {
		return power;
	}
	public void setPower(float[] power) {
		this.power = power;
	}
	public float[] getPower_factor() {
		return power_factor;
	}
	public void setPower_factor(float[] power_factor) {
		this.power_factor = power_factor;
	}
	public float[] getDgt() {
		return dgt;
	}
	public void setDgt(float[] dgt) {
		this.dgt = dgt;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	

}
