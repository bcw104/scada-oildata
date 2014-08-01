package com.ht.scada.oildata.entity;

import com.ht.scada.common.tag.entity.EndTagExtInfo;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

/**
 * 单元物性采集：与油井一对一
 * Created with IntelliJ IDEA.
 * User: 陈志强
 * Date: 2014/8/1
 * Time: 11:02
 */

@Entity
@Table(name="T_Unit_Physical_Collection")
public class UnitPhysicalCollection  extends AbstractPersistable<Integer> {
    private String DYDM; // 单元代码
    private int YYMD;    // 原油密度
    private int SMD;     // 水密度
    private int TRQXDMD; // 天然气相对密度
    private int YSQYB;   // 原始溶解气油比
    private int BHYL;    // 饱和压力
    private int DCYL;    // 地层压力
    private int YCZS;    // 油层中部深度
    private int YCZW;    // 油层中部温度

    public String getDYDM() {
        return DYDM;
    }

    public void setDYDM(String DYDM) {
        this.DYDM = DYDM;
    }

    public int getYYMD() {
        return YYMD;
    }

    public void setYYMD(int YYMD) {
        this.YYMD = YYMD;
    }

    public int getSMD() {
        return SMD;
    }

    public void setSMD(int SMD) {
        this.SMD = SMD;
    }

    public int getTRQXDMD() {
        return TRQXDMD;
    }

    public void setTRQXDMD(int TRQXDMD) {
        this.TRQXDMD = TRQXDMD;
    }

    public int getYSQYB() {
        return YSQYB;
    }

    public void setYSQYB(int YSQYB) {
        this.YSQYB = YSQYB;
    }

    public int getBHYL() {
        return BHYL;
    }

    public void setBHYL(int BHYL) {
        this.BHYL = BHYL;
    }

    public int getDCYL() {
        return DCYL;
    }

    public void setDCYL(int DCYL) {
        this.DCYL = DCYL;
    }

    public int getYCZS() {
        return YCZS;
    }

    public void setYCZS(int YCZS) {
        this.YCZS = YCZS;
    }

    public int getYCZW() {
        return YCZW;
    }

    public void setYCZW(int YCZW) {
        this.YCZW = YCZW;
    }
}
