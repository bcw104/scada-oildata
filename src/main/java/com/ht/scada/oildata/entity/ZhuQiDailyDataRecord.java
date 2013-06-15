package com.ht.scada.oildata.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 注汽日数据
 * @author 赵磊
 *
 */
@Entity
@Table(name="T_ZhuQi_Daily_Record")
public class ZhuQiDailyDataRecord extends AbstractPersistable<Integer> {

	/**
	 * 编号
	 */
	private String code;
	
	/**
	 * 注汽量
	 */
	private float gas;
	
	/**
	 * 状态（1为开井，0为停井。开井时间大于23就认为开井）
	 */
	private int runStatus;
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
         * 插入时间
         */
        @Temporal(javax.persistence.TemporalType.TIMESTAMP)
        private Date saveDatetime;
	
	/****************注汽报表补充*******************/
	/**
	 * 运行时间
	 */
	private float runTime;
	/**
	 * 日均瞬时注汽流量
	 */
	private float ssll;
	/**
	 * 日均压力
	 */
	private float yaLi;
	/**
	 * 日均温度
	 */
	private float wenDu;
	/**
	 * 日均干度
	 */
	private float ganDu;

	

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


	public float getGanDu() {
		return ganDu;
	}


	public void setGanDu(float ganDu) {
		this.ganDu = ganDu;
	}


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


	
	

}
