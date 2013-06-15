package com.ht.scada.oildata.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 增压站日数据
 * @author 赵磊
 *
 */
@Entity
@Table(name="T_Zengyazhan_Daily_Record")
public class ZengYaZhanDailyDataRecord extends AbstractPersistable<Integer> {

	/**
	 * 编号
	 */
	private String code;

	
	/**
	 * 状态（1为开井，0为停井。开井时间大于23就认为开井）
	 */
	private int runStatus;
	/**
	 * 日运行时间
	 */
	private float runTime;
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
	/**
	 * 日均入口温度
	 */
	private float ruWenDu;
	/**
	 * 日均出口温度
	 */
	private float chuWenDu;
	/**
	 * 日均压力
	 */
	private float yaLi;
	/**
	 * 日均累计流量
	 */
	private float ljll;
	/**
	 * 日均瞬时流量
	 */
	private float ssll;
	/**
	 * 日均缓冲罐液位
	 */
	private float yeWei;
	/**
	 * 环境温度1
	 */
	private float wenDu1;
	/**
	 * 环境温度2
	 */
	private float wenDu2;
	/**
	 * 电动蝶阀值
	 */
	private int dddf;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getRunStatus() {
		return runStatus;
	}
	public void setRunStatus(int runStatus) {
		this.runStatus = runStatus;
	}
	public float getRunTime() {
		return runTime;
	}
	public void setRunTime(float runTime) {
		this.runTime = runTime;
	}
	public float getEleConsume() {
		return eleConsume;
	}
	public void setEleConsume(float eleConsume) {
		this.eleConsume = eleConsume;
	}
	
	public float getRuWenDu() {
		return ruWenDu;
	}
	public void setRuWenDu(float ruWenDu) {
		this.ruWenDu = ruWenDu;
	}
	public float getChuWenDu() {
		return chuWenDu;
	}
	public void setChuWenDu(float chuWenDu) {
		this.chuWenDu = chuWenDu;
	}
	public float getYaLi() {
		return yaLi;
	}
	public void setYaLi(float yaLi) {
		this.yaLi = yaLi;
	}
	public float getLjll() {
		return ljll;
	}
	public void setLjll(float ljll) {
		this.ljll = ljll;
	}
	public float getSsll() {
		return ssll;
	}
	public void setSsll(float ssll) {
		this.ssll = ssll;
	}
	public float getYeWei() {
		return yeWei;
	}
	public void setYeWei(float yeWei) {
		this.yeWei = yeWei;
	}
	public float getWenDu1() {
		return wenDu1;
	}
	public void setWenDu1(float wenDu1) {
		this.wenDu1 = wenDu1;
	}
	public float getWenDu2() {
		return wenDu2;
	}
	public void setWenDu2(float wenDu2) {
		this.wenDu2 = wenDu2;
	}
	public int getDddf() {
		return dddf;
	}
	public void setDddf(int dddf) {
		this.dddf = dddf;
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
