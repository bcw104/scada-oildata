package com.ht.scada.oildata.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.data.jpa.domain.AbstractPersistable;
/**
 * 示功图测试类
 * @author 赵磊
 *
 */
@Entity
@Table(name="T_Test_SGT")
public class TestSGT extends AbstractPersistable<Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1624162499848144160L;
	private float chongCheng;
	private float chongCi;
	private float chongCiShang;
	private float chongCiXia;
	private float maxZaihe;
	private float minZaihe;
	@Lob
	private String weiyi;
	@Lob
	private String zaihe;
	
	private float weiyiSum;
	private float zaiheSum;
	
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date date;
	
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
	public float getChongCiShang() {
		return chongCiShang;
	}
	public void setChongCiShang(float chongCiShang) {
		this.chongCiShang = chongCiShang;
	}
	public float getChongCiXia() {
		return chongCiXia;
	}
	public void setChongCiXia(float chongCiXia) {
		this.chongCiXia = chongCiXia;
	}
	public float getMaxZaihe() {
		return maxZaihe;
	}
	public void setMaxZaihe(float maxZaihe) {
		this.maxZaihe = maxZaihe;
	}
	public float getMinZaihe() {
		return minZaihe;
	}
	public void setMinZaihe(float minZaihe) {
		this.minZaihe = minZaihe;
	}
	public String getWeiyi() {
		return weiyi;
	}
	public void setWeiyi(String weiyi) {
		this.weiyi = weiyi;
	}
	public String getZaihe() {
		return zaihe;
	}
	public void setZaihe(String zaihe) {
		this.zaihe = zaihe;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getWeiyiSum() {
		return weiyiSum;
	}
	public void setWeiyiSum(float weiyiSum) {
		this.weiyiSum = weiyiSum;
	}
	public float getZaiheSum() {
		return zaiheSum;
	}
	public void setZaiheSum(float zaiheSum) {
		this.zaiheSum = zaiheSum;
	}
	
	

}
