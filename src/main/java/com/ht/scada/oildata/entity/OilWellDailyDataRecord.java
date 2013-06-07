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
	 * 注汽
	 */
	private float zhuShui;
	/**
	 * 注水
	 */
	private float zhuQi;


	/**
	 * 时间
	 */
	private Date datetime;


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


}
