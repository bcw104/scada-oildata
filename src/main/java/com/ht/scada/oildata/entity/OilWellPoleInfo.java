package com.ht.scada.oildata.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 抽油机井杆管结构维护信息
 *
 * Created with IntelliJ IDEA.
 * User: 陈志强
 * Date: 2014/8/1
 * Time: 15:52
 */

@Entity
@Table(name="T_Oil_Well_Pole_Info")
public class OilWellPoleInfo   extends AbstractPersistable<Integer> {
    private String JH;//井号
    private float BS;//泵深
    private float BJ;//  泵径
    private int BLX;//泵类型，1-管式泵 2-杆式泵 3-防砂卡泵
    private int BJB;//泵级别，1-Ⅰ级泵 2-Ⅱ级泵 3-Ⅲ级泵
    private float ZSC;//  柱塞长
    private float YGNJ;//油管内径
    private float YGWJ;//  油管外径
    private int YJGJB;//一级杆级别
    private float YJGGJ;//  一级杆杆径
    private float YJGCD;//一级杆长度
    private int EJGJB;//  二级杆级别
    private float EJGGJ;//二级杆杆径
    private float EJGCD;//  二级杆长度
    private int SJGJB;//三级杆级别
    private float SJGGJ;// 三级杆杆径
    private float SJGCD;//三级杆长度
    private int MD;//是否锚定(0未锚定，1锚定)

}
