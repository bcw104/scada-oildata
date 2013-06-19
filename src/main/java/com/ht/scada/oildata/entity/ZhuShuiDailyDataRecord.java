package com.ht.scada.oildata.entity;

import java.util.Date;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 注水日数据
 * @author 赵磊
 *
 */
@Entity
@Table(name="T_Zhushui_Daily_Record")
public class ZhuShuiDailyDataRecord extends AbstractPersistable<Integer> {

	/**
	 * 编号
	 */
	private String code;
	
	/**
	 * 注水量
	 */
        @Column(columnDefinition="DECIMAL(10,3)")
	private float water;
	
	/**
	 * 状态（1为开井，0为停井。开井时间大于23就认为开井）
	 */
	private int runStatus;
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
	
	/***************补充生产管理报表*****************/
	/**
	 * 运行时间
	 */
        @Column(columnDefinition="DECIMAL(10,2)")
	private float runTime;
	/**
	 * 日均瞬时流量
	 */
        @Column(columnDefinition="DECIMAL(10,2)")
	private float ssll;
	/**
	 * 日均压力
	 */
        @Column(columnDefinition="DECIMAL(10,2)")
	private float yaLi;
	/**
	 * 日均温度
	 */
        @Column(columnDefinition="DECIMAL(10,2)")
	private float wenDu;
	


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public float getWater() {
		return water;
	}


	public void setWater(float water) {
		this.water = water;
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


	


	public float getRunTime() {
		return runTime;
	}


	public void setRunTime(float runTime) {
		this.runTime = runTime;
	}


	public float getSsll() {
		return ssll;
	}


	public void setSsll(float ssll) {
		this.ssll = ssll;
	}


	public float getYaLi() {
		return yaLi;
	}


	public void setYaLi(float yaLi) {
		this.yaLi = yaLi;
	}


	public float getWenDu() {
		return wenDu;
	}


	public void setWenDu(float wenDu) {
		this.wenDu = wenDu;
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

}
