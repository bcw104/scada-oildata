package com.ht.scada.oildata.entity;

/**
 * 抽油杆受力
 * @author 赵磊
 *
 */
public class ChouYouGanShouLi {
	
	private String index;	//“一级杆”、“二级杆”
	private String MaxZaiHe;	//最大载荷
	private String MinZaihe;	//最小载荷
	
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getMaxZaiHe() {
		return MaxZaiHe;
	}
	public void setMaxZaiHe(String maxZaiHe) {
		MaxZaiHe = maxZaiHe;
	}
	public String getMinZaihe() {
		return MinZaihe;
	}
	public void setMinZaihe(String minZaihe) {
		MinZaihe = minZaihe;
	}

}
