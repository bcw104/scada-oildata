package com.ht.scada.oildata.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 油井时数据（也可能按分钟来）
 * @author 赵磊
 *
 */
@Entity
@Table(name="T_Oilwell_Hourly_Record")
public class OilWellHourlyDataRecord extends AbstractPersistable<Integer> {

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
	 * 开井时间（分钟，即存储间隔）
	 */
	private int runTime;
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


	public int getRunTime() {
		return runTime;
	}


	public void setRunTime(int runTime) {
		this.runTime = runTime;
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
