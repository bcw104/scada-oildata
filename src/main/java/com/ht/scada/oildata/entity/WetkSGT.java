package com.ht.scada.oildata.entity;

import javax.persistence.Table;
import java.util.Date;

/**
 * 威尔泰克功图数据
 * Created with IntelliJ IDEA.
 * User: 陈志强
 * Date: 2014/7/5
 * Time: 10:14
 */
@Table(name="SCY_SGT_GTCJ")
public class WetkSGT{
    private String ID;
    //JH	 井号
    private String JH;
    //CJSJ  采集时间
    private Date CJSJ;
    //CC	冲程
    private float CC;
    //CC1	冲次
    private float CC1;
    //SXCC1	上行冲次
    private float SXCC1;
    //XXCC1	下行冲次
    private float XXCC1;
    //WY	位移
    private String WY;
    //DL	电流
    private String DL;
    //GL	有功功率采集数据
    private String GL;
    //ZH	 	载荷
    private String ZH;
    //BPQSCGL		变频器输出功率
    private String BPQSCGL;
    //ZJ	转矩
    private String ZJ;
    //ZDZH	最大载荷
    private float ZDZH;
    //ZXZH	最小载荷
    private float ZXZH;
    //BZGT		标准功图ID（为空）
    private Integer BZGT;
    //GLYS	功率因数
    private float GLYS;
    //YGGL	有功功率
    private float YGGL;
    //WGGL	无功功率
    private float WGGL;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getJH() {
        return JH;
    }

    public void setJH(String JH) {
        this.JH = JH;
    }

    public Date getCJSJ() {
        return CJSJ;
    }

    public void setCJSJ(Date CJSJ) {
        this.CJSJ = CJSJ;
    }

    public float getCC() {
        return CC;
    }

    public void setCC(float CC) {
        this.CC = CC;
    }

    public float getCC1() {
        return CC1;
    }

    public void setCC1(float CC1) {
        this.CC1 = CC1;
    }

    public float getSXCC1() {
        return SXCC1;
    }

    public void setSXCC1(float SXCC1) {
        this.SXCC1 = SXCC1;
    }

    public float getXXCC1() {
        return XXCC1;
    }

    public void setXXCC1(float XXCC1) {
        this.XXCC1 = XXCC1;
    }

    public String getWY() {
        return WY;
    }

    public void setWY(String WY) {
        this.WY = WY;
    }

    public String getDL() {
        return DL;
    }

    public void setDL(String DL) {
        this.DL = DL;
    }

    public String getGL() {
        return GL;
    }

    public void setGL(String GL) {
        this.GL = GL;
    }

    public String getZH() {
        return ZH;
    }

    public void setZH(String ZH) {
        this.ZH = ZH;
    }

    public String getBPQSCGL() {
        return BPQSCGL;
    }

    public void setBPQSCGL(String BPQSCGL) {
        this.BPQSCGL = BPQSCGL;
    }

    public String getZJ() {
        return ZJ;
    }

    public void setZJ(String ZJ) {
        this.ZJ = ZJ;
    }

    public float getZDZH() {
        return ZDZH;
    }

    public void setZDZH(float ZDZH) {
        this.ZDZH = ZDZH;
    }

    public float getZXZH() {
        return ZXZH;
    }

    public void setZXZH(float ZXZH) {
        this.ZXZH = ZXZH;
    }

    public Integer getBZGT() {
        return BZGT;
    }

    public void setBZGT(Integer BZGT) {
        this.BZGT = BZGT;
    }

    public float getGLYS() {
        return GLYS;
    }

    public void setGLYS(float GLYS) {
        this.GLYS = GLYS;
    }

    public float getYGGL() {
        return YGGL;
    }

    public void setYGGL(float YGGL) {
        this.YGGL = YGGL;
    }

    public float getWGGL() {
        return WGGL;
    }

    public void setWGGL(float WGGL) {
        this.WGGL = WGGL;
    }
}
