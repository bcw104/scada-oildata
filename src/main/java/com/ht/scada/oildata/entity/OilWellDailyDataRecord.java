package com.ht.scada.oildata.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 油井日数据，24:00更新
 * @author 赵磊
 *
 */
@Entity
@Table(name="T_Oilwell_Daily_Record")
public class OilWellDailyDataRecord extends AbstractPersistable<Integer> {

	/**
	 * 油井编号
	 */
	private String code;
	
	/**
	 * 产油量
	 */
	private float oilProduct;
	/**
	 * 产液量
	 */
	private float liquidProduct;
	/**
	 * 一日开井状态(1为开井，0为停井。开井时间大于23就认为开井)
	 */
	private int runStatus;
	/**
	 * 用电量
	 */
	private float eleConsume;
	
	/**
	 * 含水
	 */
	private float hanShui;
	/**
	 * 注汽量
	 */
	private float zhuShui;
	/**
	 * 注水量
	 */
	private float zhuQi;


	/**
	 * 时间
	 */
	private Date datetime;
	
	/************** 补充日报表 *****************/
	
	/**
	 * 冲程
	 */
	private float chongCheng;
	/**
	 * 冲次
	 */
	private float chongCi;
	/**
	 * 油压
	 */
	private float youYa;
	/**
	 * 套压
	 */
	private float taoYa;
	/**
	 * 回压
	 */
	private float huiYa;
	/**
	 * 动液面
	 */
	private float dongYeMian;
	/**
	 * 泵效
	 */
	private float bengXiao;
	/**
	 * 平衡度
	 */
	private float pingHengDu;
	/**
	 * 井口温度
	 */
	private float jingKouWenDu;
	/**
	 * 日平均电压
	 */
	private float avgU;
	/**
	 * 日平均电流
	 */
	private float avgI;
	/**
	 * 日开井时间
	 */
	private float runTime;
	
	


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public float getOilProduct() {
		return oilProduct;
	}


	public void setOilProduct(float oilProduct) {
		this.oilProduct = oilProduct;
	}


	public float getLiquidProduct() {
		return liquidProduct;
	}


	public void setLiquidProduct(float liquidProduct) {
		this.liquidProduct = liquidProduct;
	}


	public int getRunStatus() {
		return runStatus;
	}


	public void setRunStatus(int runStatus) {
		this.runStatus = runStatus;
	}


	public float getEleConsume() {
		return eleConsume;
	}


	public void setEleConsume(float eleConsume) {
		this.eleConsume = eleConsume;
	}


	public float getHanShui() {
		return hanShui;
	}


	public void setHanShui(float hanShui) {
		this.hanShui = hanShui;
	}


	public float getZhuShui() {
		return zhuShui;
	}


	public void setZhuShui(float zhuShui) {
		this.zhuShui = zhuShui;
	}


	public float getZhuQi() {
		return zhuQi;
	}


	public void setZhuQi(float zhuQi) {
		this.zhuQi = zhuQi;
	}


	public Date getDatetime() {
		return datetime;
	}


	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}


	public float getChongCheng() {
		return chongCheng;
	}


	public void setChongCheng(float chongCheng) {
		this.chongCheng = chongCheng;
	}


	public float getChongCi() {
		return chongCi;
	}


	public void setChongCi(float chongCi) {
		this.chongCi = chongCi;
	}


	public float getYouYa() {
		return youYa;
	}


	public void setYouYa(float youYa) {
		this.youYa = youYa;
	}


	public float getTaoYa() {
		return taoYa;
	}


	public void setTaoYa(float taoYa) {
		this.taoYa = taoYa;
	}


	public float getHuiYa() {
		return huiYa;
	}


	public void setHuiYa(float huiYa) {
		this.huiYa = huiYa;
	}


	public float getDongYeMian() {
		return dongYeMian;
	}


	public void setDongYeMian(float dongYeMian) {
		this.dongYeMian = dongYeMian;
	}


	public float getBengXiao() {
		return bengXiao;
	}


	public void setBengXiao(float bengXiao) {
		this.bengXiao = bengXiao;
	}


	public float getPingHengDu() {
		return pingHengDu;
	}


	public void setPingHengDu(float pingHengDu) {
		this.pingHengDu = pingHengDu;
	}


	public float getJingKouWenDu() {
		return jingKouWenDu;
	}


	public void setJingKouWenDu(float jingKouWenDu) {
		this.jingKouWenDu = jingKouWenDu;
	}


	public float getAvgU() {
		return avgU;
	}


	public void setAvgU(float avgU) {
		this.avgU = avgU;
	}


	public float getAvgI() {
		return avgI;
	}


	public void setAvgI(float avgI) {
		this.avgI = avgI;
	}


	public float getRunTime() {
		return runTime;
	}


	public void setRunTime(float runTime) {
		this.runTime = runTime;
	}
	
	


}
