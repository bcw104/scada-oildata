package com.ht.scada.oildata.calc;

/**
 * 坐标点
 * @author 赵磊
 *
 */
public class Point{
	private float x;	//X坐标
	private float y;	//Y坐标
	private double arCos;	//与P0点的角度
	private int index;	//索引
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public double getArCos() {
		return arCos;
	}
	public void setArCos(double arCos) {
		this.arCos = arCos;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

}
