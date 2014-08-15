package com.ht.scada.oildata.service.impl;

import com.ht.scada.common.tag.util.CommonUtils;
import com.ht.scada.oildata.entity.WetkSGT;
import com.ht.scada.oildata.model.GTSC;
import com.ht.scada.oildata.service.WetkSGTService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * @author 陈志强
 */
@Transactional
@Service("wetkSGTService")
public class WetkSGTServiceImpl implements WetkSGTService {
    @Inject
    protected Sql2o sql2o;

    @Override
    public Sql2o getSql2o() {
        return sql2o;
    }

    @Inject
    @Override
    public void setSql2o(Sql2o sql2o) {
        this.sql2o = sql2o;
    }




    @Override
    public void addOneRecord(WetkSGT wetkSGT) {
        String sql = "Insert into QYSCZH.SCY_SGT_GTCJ (ID,JH,CJSJ,CC,CC1,SXCC1,XXCC1,WY,DL,GL," //
                + "ZH,BPQSCGL,ZJ,ZDZH,ZXZH,BZGT,GLYS,YGGL,WGGL) " //
                + "values ( :ID, :JH, :CJSJ, :CC, :CC1, :SXCC1, :XXCC1, :WY, :DL, :GL, "//
                + " :ZH, :BPQSCGL, :ZJ, :ZDZH, :ZXZH, :BZGT, :GLYS, :YGGL, :WGGL) ";//
        //int lastId = getAllRecords().size();    // 获得当前 CS端登陆者的最大ID， 2014.6.24日迁移数据库时添加 //
        try (Connection con = sql2o.open()) {  //
            con.createQuery(sql)  //
                    .addParameter("ID", wetkSGT.getID()) //
                    .addParameter("JH", wetkSGT.getJH())//
                    .addParameter("CJSJ", wetkSGT.getCJSJ())//
                    .addParameter("CC", wetkSGT.getCC())//
                    .addParameter("CC1", wetkSGT.getCC1())//
                    .addParameter("SXCC1", wetkSGT.getSXCC1())//
                    .addParameter("XXCC1", wetkSGT.getXXCC1())//
                    .addParameter("WY", wetkSGT.getWY())//
                    .addParameter("DL", wetkSGT.getDL())//
                    .addParameter("GL", wetkSGT.getGL())//
                    .addParameter("ZH", wetkSGT.getZH())//
                    .addParameter("BPQSCGL", wetkSGT.getBPQSCGL())//
                    .addParameter("ZJ", wetkSGT.getZJ())//
                    .addParameter("ZDZH", wetkSGT.getZDZH())//
                    .addParameter("ZXZH", wetkSGT.getZXZH())//
                    .addParameter("BZGT", wetkSGT.getBZGT())//
                    .addParameter("GLYS", wetkSGT.getGLYS())//
                    .addParameter("YGGL", wetkSGT.getYGGL())//
                    .addParameter("WGGL", wetkSGT.getWGGL())//
                    .executeUpdate();//
        }catch (Exception e) {
            System.out.println("e:" + e.getMessage());//
        }//

    }

    @Override
    public void addOneGTFXRecord(String gtId,String code,Date cjDate,float CC,float CC1,float ZDZH,float ZXZH) {
        String sql = "INSERT INTO QYSCZH.SCY_SGT_GTFX (ID, JH, CJSJ, GTID, CC, CC1, ZDZH, ZXZH) " //
        + "values (:ID,:JH,:CJSJ,:GTID,:CC,:CC1,:ZDZH,:ZXZH) ";//

        try (Connection con = sql2o.open()) {  //
            con.createQuery(sql)  //
                    .addParameter("ID", CommonUtils.getCode())
                    .addParameter("JH",code)
                    .addParameter("CJSJ",cjDate)
                    .addParameter("GTID", gtId)
                    .addParameter("CC", CC)
                    .addParameter("CC1",CC1)
                    .addParameter("ZDZH",ZDZH)
                    .addParameter("ZXZH", ZXZH)
                    .executeUpdate();//
        } catch (Exception e) {
            System.out.println("e:" + e.getMessage());//
        }

    }

    @Override
    public GTSC findOneGTFXRecordByCode(String code) {
        // RCYL1 产液量、RCYL 产油量
        String sql = "select q.RCYL1,q.RCYL,s.JH,q.CJSJ,s.WY,q.BGT FROM QYSCZH.SCY_SGT_GTCJ s inner join QYSCZH.SCY_SGT_GTFX q on s.JH=:CODE AND q.SCJSBZ = 1 AND q.JH=s.JH ORDER BY q.CJSJ DESC ";//
        try (Connection con = sql2o.open()) {  //
            return con.createQuery(sql)  //
                    .addParameter("CODE", code)
                    .executeAndFetchFirst(GTSC.class);
        }
    }

    @Override
    public List<WetkSGT> getAllRecords() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * from QYSCZH.SCY_SGT_GTCJ")//
                    .setAutoDeriveColumnNames(true)//
                    .executeAndFetch(WetkSGT.class);
        }
    }

    @Override
    public GTSC findGTSCRecordByJHAndCJSJ(String JH, String CJSJ) {
        String sql = "SELECT RCYL1,RCYL,JH,CJSJ FROM QYSCZH.SCY_SGT_GTFX WHERE JH=:CODE AND CJSJ=TO_DATE(:CJSJ,'YYYY-MM-DD HH24:MI:SS')";//
        try (Connection con = sql2o.open()) {  //
            return con.createQuery(sql)  //
                    .addParameter("CODE", JH)
                    .addParameter("CJSJ", CJSJ)
                    .executeAndFetchFirst(GTSC.class);
        }
    }
}
