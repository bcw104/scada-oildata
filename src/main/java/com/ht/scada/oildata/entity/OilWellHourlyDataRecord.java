package com.ht.scada.oildata.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

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
	 * 启停状态(1为启，0为停)
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

    public int getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(int runStatus) {
        this.runStatus = runStatus;
    }

   

}
