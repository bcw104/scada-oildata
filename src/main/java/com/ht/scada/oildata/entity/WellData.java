package com.ht.scada.oildata.entity;

import java.util.Date;



/**
 * 油井数据，包括示功图数据、最大载荷、最小载荷、冲程时间、冲次、冲程、光杆功率等
 * 
 * @author 赵磊
 * 
 */
public class WellData {

    /**
	 * 井号，可以是中文或英文，如草13-113、C13-P32
	 */
	private String code;
	/**
	 * 载荷，示功图纵坐标
	 */
	private float[] zaihe;
	/**
	 * 位移，示功图横坐标
	 */
	private float[] weiyi;
	/**
	 * 冲程时间(s)
	 */
	private float chongChengTime;
	/**
	 * 冲次
	 */
	private float chongCi;
	/**
	 * 冲程
	 */
	private float chongCheng;
	/**
	 * 最小载荷
	 */
	private float maxZaihe;
	/**
	 * 最大载荷
	 */
	private float minZaihe;
	
	/**
	 * 故障诊断信息
	 */
	private String falutDiagnoseInfo;
	
	/**
	 * 平衡度
	 */
	private float pingHengDu;
	/**
	 * 产液量
	 */
	private float chanYeLiang;
	/**
	 * 泵效
	 */
	private float bengXiao;
	/**
	 * 上冲程时间
	 */
	private float shangChongChengTime;
	/**
	 * 下冲程时间
	 */
	private float xiaChongChengTime;
	/**
	 * 日耗电量
	 */
	private float riHaoDian;
	/**
	 * 电表读数
	 */
	private float dianBiaoNum;
	/**
	 * 上冲程能耗
	 */
	private float nenghaoShang;
	/**
	 * 下冲程能耗
	 */
	private float nenghaoXia;
	
	/**
	 * 时间
	 */
	private Date time;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float[] getZaihe() {
		return zaihe;
	}

	public void setZaihe(float[] zaihe) {
		this.zaihe = zaihe;
	}

	public float[] getWeiyi() {
		return weiyi;
	}

	public void setWeiyi(float[] weiyi) {
		this.weiyi = weiyi;
	}

	public float getChongChengTime() {
		return chongChengTime;
	}

	public void setChongChengTime(float chongChengTime) {
		this.chongChengTime = chongChengTime;
	}

	public float getChongCi() {
		return chongCi;
	}

	public void setChongCi(float chongCi) {
		this.chongCi = chongCi;
	}

	public float getChongCheng() {
		return chongCheng;
	}

	public void setChongCheng(float chongCheng) {
		this.chongCheng = chongCheng;
	}

	public float getMaxZaihe() {
		return maxZaihe;
	}

	public void setMaxZaihe(float maxZaihe) {
		this.maxZaihe = maxZaihe;
	}

	public float getMinZaihe() {
		return minZaihe;
	}

	public void setMinZaihe(float minZaihe) {
		this.minZaihe = minZaihe;
	}

	public String getFalutDiagnoseInfo() {
		return falutDiagnoseInfo;
	}

	public void setFalutDiagnoseInfo(String falutDiagnoseInfo) {
		this.falutDiagnoseInfo = falutDiagnoseInfo;
	}

	public float getPingHengDu() {
		return pingHengDu;
	}

	public void setPingHengDu(float pingHengDu) {
		this.pingHengDu = pingHengDu;
	}

	public float getChanYeLiang() {
		return chanYeLiang;
	}

	public void setChanYeLiang(float chanYeLiang) {
		this.chanYeLiang = chanYeLiang;
	}

	public float getBengXiao() {
		return bengXiao;
	}

	public void setBengXiao(float bengXiao) {
		this.bengXiao = bengXiao;
	}

	public float getShangChongChengTime() {
		return shangChongChengTime;
	}

	public void setShangChongChengTime(float shangChongChengTime) {
		this.shangChongChengTime = shangChongChengTime;
	}

	public float getXiaChongChengTime() {
		return xiaChongChengTime;
	}

	public void setXiaChongChengTime(float xiaChongChengTime) {
		this.xiaChongChengTime = xiaChongChengTime;
	}

	public float getRiHaoDian() {
		return riHaoDian;
	}

	public void setRiHaoDian(float riHaoDian) {
		this.riHaoDian = riHaoDian;
	}

	public float getDianBiaoNum() {
		return dianBiaoNum;
	}

	public void setDianBiaoNum(float dianBiaoNum) {
		this.dianBiaoNum = dianBiaoNum;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public float getNenghaoXia() {
		return nenghaoXia;
	}

	public void setNenghaoXia(float nenghaoXia) {
		this.nenghaoXia = nenghaoXia;
	}

	public float getNenghaoShang() {
		return nenghaoShang;
	}

	public void setNenghaoShang(float nenghaoShang) {
		this.nenghaoShang = nenghaoShang;
	}
	
	
	
}