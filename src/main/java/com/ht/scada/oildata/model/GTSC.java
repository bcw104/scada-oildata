package com.ht.scada.oildata.model;

/**
 * 威尔泰克功图算产
 * Created with IntelliJ IDEA.
 * User: 陈志强
 * Date: 2014/8/2
 * Time: 11:59
 */
public class GTSC {
    private float RCYL1;//  产液量
    private float RCYL; //  产油量
    private String JH;  //  井号
    private String CJSJ;  //  采集时间
    private String WY;   //  泵功图（位移）
    private String BGT;  //  泵功图（载荷）

    public float getRCYL1() {
        return RCYL1;
    }

    public void setRCYL1(float RCYL1) {
        this.RCYL1 = RCYL1;
    }

    public float getRCYL() {
        return RCYL;
    }

    public void setRCYL(float RCYL) {
        this.RCYL = RCYL;
    }

    public String getWY() {
        return WY;
    }

    public void setWY(String WY) {
        this.WY = WY;
    }

    public String getBGT() {
        return BGT;
    }

    public void setBGT(String BGT) {
        this.BGT = BGT;
    }

    public String getJH() {
        return JH;
    }

    public void setJH(String JH) {
        this.JH = JH;
    }

    public String getCJSJ() {
        return CJSJ;
    }

    public void setCJSJ(String CJSJ) {
        this.CJSJ = CJSJ;
    }
}
