package com.ht.scada.oildata.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 注汽时数据（也可能按分钟来）
 * @author 赵磊
 *
 */
@Entity
@Table(name="T_Zhuqi_Hourly_Record")
public class ZhuQiHourlyDataRecord extends AbstractPersistable<Integer> {

	/**
	 * 编号
	 */
	private String code;
	
	/**
	 * 注汽量
	 */
	private float gas;
	
	/**
	 * 开井时间（分钟，即存储间隔）
	 */
	private int runTime;
	/**
	 * 用电量
	 */
	private float eleConsume;
	
	/**
	 * 统计日期
	 */
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date statisticsDate;
        
        /**
         * 统计时间
         */
        @Temporal(javax.persistence.TemporalType.TIME)
        private Date statisticsTime;

        /**
         * 插入时间
         */
        @Temporal(javax.persistence.TemporalType.TIMESTAMP)
        private Date saveDatetime;


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public float getGas() {
		return gas;
	}


	public void setGas(float gas) {
		this.gas = gas;
	}


	public int getRunTime() {
		return runTime;
	}


	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}


	public float getEleConsume() {
		return eleConsume;
	}


	public void setEleConsume(float eleConsume) {
		this.eleConsume = eleConsume;
	}


}
