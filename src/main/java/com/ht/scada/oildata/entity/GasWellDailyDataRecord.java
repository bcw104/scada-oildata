package com.ht.scada.oildata.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Date;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * 天然气井日数据，24:00更新
 * @author 赵磊
 *
 */
@Entity
@Table(name="T_Gaswell_Daily_Record")
public class GasWellDailyDataRecord extends AbstractPersistable<Integer> {

	/**
	 * 井编号
	 */
	private String code;
	
	/**
	 * 产气量
	 */
        @Column(columnDefinition="DECIMAL(10,3)")
	private float gasProduct;
	
	/**
	 * 一日开井状态(1为开井，0为停井。开井时间大于23就认为开井)
	 */
	private int runStatus;
        /**
	 * 日开井时间（小时）
	 */
        @Column(columnDefinition="DECIMAL(10,2)")
	private float runTime;
	/**
	 * 用电量
	 */
        @Column(columnDefinition="DECIMAL(10,3)")
	private float eleConsume;
	


	/**
	 * 统计日期
	 */
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date statisticsDate;
        
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


	public float getGasProduct() {
		return gasProduct;
	}


	public void setGasProduct(float gasProduct) {
		this.gasProduct = gasProduct;
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

    public Date getStatisticsDate() {
        return statisticsDate;
    }

    public void setStatisticsDate(Date statisticsDate) {
        this.statisticsDate = statisticsDate;
    }

    public Date getSaveDatetime() {
        return saveDatetime;
    }

    public void setSaveDatetime(Date saveDatetime) {
        this.saveDatetime = saveDatetime;
    }

    public float getRunTime() {
        return runTime;
    }

    public void setRunTime(float runTime) {
        this.runTime = runTime;
    }


	

	
}
