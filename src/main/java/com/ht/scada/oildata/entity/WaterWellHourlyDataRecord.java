package com.ht.scada.oildata.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 水井时数据（也可能按分钟来）
 * @author 赵磊
 *
 */
@Entity
@Table(name="T_Waterwell_Hourly_Record")
public class WaterWellHourlyDataRecord extends AbstractPersistable<Integer> {

	/**
	 * 油井编号
	 */
	private String code;
	
	/**
	 * 水量
	 */
	private float waterProduct;
	
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




	public float getWaterProduct() {
		return waterProduct;
	}


	public void setWaterProduct(float waterProduct) {
		this.waterProduct = waterProduct;
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

    public Date getStatisticsDate() {
        return statisticsDate;
    }

    public void setStatisticsDate(Date statisticsDate) {
        this.statisticsDate = statisticsDate;
    }

    public Date getStatisticsTime() {
        return statisticsTime;
    }

    public void setStatisticsTime(Date statisticsTime) {
        this.statisticsTime = statisticsTime;
    }

    public Date getSaveDatetime() {
        return saveDatetime;
    }

    public void setSaveDatetime(Date saveDatetime) {
        this.saveDatetime = saveDatetime;
    }


	


	

}
