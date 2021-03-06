package com.ht.scada.oildata.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Date;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * 天然气井日数据，24:00更新
 *
 * @author 赵磊
 *
 */
@Entity
@Table(name = "T_Waterwell_Daily_Record")
public class WaterWellDailyDataRecord extends AbstractPersistable<Integer> {

    /**
     * 井编号
     */
    private String code;
    /**
     * 水量
     */
    @Column(columnDefinition="DECIMAL(10,3)")
    private float waterProduct;
    /**
     * 一日开井状态(1为开井，0为停井。开井时间大于23就认为开井)
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
    /**
     * *****************补充生产管理**********************
     */
    /**
     * 日均外输压力
     */
    @Column(columnDefinition="DECIMAL(10,2)")
    private float yaLi;
    /**
     * 日均井口压力
     */
    @Column(columnDefinition="DECIMAL(10,2)")
    private float jingYa;
    /**
     * 日均水温
     */
    @Column(columnDefinition="DECIMAL(10,2)")
    private float wenDu;
    /**
     * 日均液位
     */
    @Column(columnDefinition="DECIMAL(10,2)")
    private float yeWei;
    /**
     * 日均瞬时流量
     */
    @Column(columnDefinition="DECIMAL(10,2)")
    private float ssll;
    /**
     * 日开井时间
     */
    @Column(columnDefinition="DECIMAL(10,2)")
    private float runTime;

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

    public float getYaLi() {
        return yaLi;
    }

    public void setYaLi(float yaLi) {
        this.yaLi = yaLi;
    }

    public float getJingYa() {
        return jingYa;
    }

    public void setJingYa(float jingYa) {
        this.jingYa = jingYa;
    }

    public float getWenDu() {
        return wenDu;
    }

    public void setWenDu(float wenDu) {
        this.wenDu = wenDu;
    }

    public float getYeWei() {
        return yeWei;
    }

    public void setYeWei(float yeWei) {
        this.yeWei = yeWei;
    }

    public float getSsll() {
        return ssll;
    }

    public void setSsll(float ssll) {
        this.ssll = ssll;
    }

    public float getRunTime() {
        return runTime;
    }

    public void setRunTime(float runTime) {
        this.runTime = runTime;
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
