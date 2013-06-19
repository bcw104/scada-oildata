package com.ht.scada.oildata.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Date;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

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
        @Column(columnDefinition="DECIMAL(10,3)") 
	private float oilProduct;
	/**
	 * 产液量
	 */
        @Column(columnDefinition="DECIMAL(10,3)") 
	private float liquidProduct;
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
	 * 含水
	 */
        @Column(columnDefinition="DECIMAL(10,4)") 
	private float hanShui;
	/**
	 * 注汽量
	 */
        @Column(columnDefinition="DECIMAL(10,3)") 
	private float zhuShui;
	/**
	 * 注水量
	 */
        @Column(columnDefinition="DECIMAL(10,3)") 
	private float zhuQi;


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
        
        
	
	/************** 补充日报表 *****************/
	
	/**
	 * 冲程
	 */
        @Column(columnDefinition="DECIMAL(10,2)") 
	private float chongCheng;
	/**
	 * 冲次
	 */
        @Column(columnDefinition="DECIMAL(10,2)") 
	private float chongCi;
	/**
	 * 油压
	 */
        @Column(columnDefinition="DECIMAL(10,3)")
	private float youYa;
	/**
	 * 套压
	 */
        @Column(columnDefinition="DECIMAL(10,3)")
	private float taoYa;
	/**
	 * 回压
	 */
        @Column(columnDefinition="DECIMAL(10,3)")
	private float huiYa;
	/**
	 * 动液面
	 */
        @Column(columnDefinition="DECIMAL(10,2)")
	private float dongYeMian;
	/**
	 * 泵效
	 */
        @Column(columnDefinition="DECIMAL(10,4)") 
	private float bengXiao;
	/**
	 * 平衡度
	 */
        @Column(columnDefinition="DECIMAL(10,3)") 
	private float pingHengDu;
	/**
	 * 井口温度
	 */
        @Column(columnDefinition="DECIMAL(10,2)") 
	private float jingKouWenDu;
	/**
	 * 日平均电压
	 */
        @Column(columnDefinition="DECIMAL(10,2)") 
	private float avgU;
	/**
	 * 日平均电流
	 */
        @Column(columnDefinition="DECIMAL(10,2)") 
	private float avgI;
	/**
	 * 日开井时间（小时）
	 */
        @Column(columnDefinition="DECIMAL(10,2)") 
	private float runTime;
	
	


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




	public float getChongCheng() {
		return chongCheng;
	}


	public void setChongCheng(float chongCheng) {
		this.chongCheng = chongCheng;
	}


	public float getChongCi() {
		return chongCi;
	}


	public void setChongCi(float chongCi) {
		this.chongCi = chongCi;
	}


	public float getYouYa() {
		return youYa;
	}


	public void setYouYa(float youYa) {
		this.youYa = youYa;
	}


	public float getTaoYa() {
		return taoYa;
	}


	public void setTaoYa(float taoYa) {
		this.taoYa = taoYa;
	}


	public float getHuiYa() {
		return huiYa;
	}


	public void setHuiYa(float huiYa) {
		this.huiYa = huiYa;
	}


	public float getDongYeMian() {
		return dongYeMian;
	}


	public void setDongYeMian(float dongYeMian) {
		this.dongYeMian = dongYeMian;
	}


	public float getBengXiao() {
		return bengXiao;
	}


	public void setBengXiao(float bengXiao) {
		this.bengXiao = bengXiao;
	}


	public float getPingHengDu() {
		return pingHengDu;
	}


	public void setPingHengDu(float pingHengDu) {
		this.pingHengDu = pingHengDu;
	}


	public float getJingKouWenDu() {
		return jingKouWenDu;
	}


	public void setJingKouWenDu(float jingKouWenDu) {
		this.jingKouWenDu = jingKouWenDu;
	}


	public float getAvgU() {
		return avgU;
	}


	public void setAvgU(float avgU) {
		this.avgU = avgU;
	}


	public float getAvgI() {
		return avgI;
	}


	public void setAvgI(float avgI) {
		this.avgI = avgI;
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
