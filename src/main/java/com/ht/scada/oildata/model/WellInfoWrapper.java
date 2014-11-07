/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.scada.oildata.model;

/**
 * 油井信息
 *
 * @author 赵磊 2014-8-3 15:20:52
 */
public class WellInfoWrapper {
    private String beng_jing;
    private String han_shui;
    private String yymd;

    public String getBeng_jing() {
        return beng_jing;
    }

    public void setBeng_jing(String beng_jing) {
        this.beng_jing = beng_jing;
    }

    public String getHan_shui() {
        return han_shui;
    }

    public void setHan_shui(String han_shui) {
        this.han_shui = han_shui;
    }

    public String getYymd() {
        return yymd;
    }

    public void setYymd(String yymd) {
        this.yymd = yymd;
    }
}
