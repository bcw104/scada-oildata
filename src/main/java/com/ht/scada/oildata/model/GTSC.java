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
    private float RCYL;//  产油量

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
}
