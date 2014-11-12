package com.ht.scada.oildata.service.impl;

import com.ht.scada.common.tag.util.CommonUtils;
import com.ht.scada.data.kv.VarGroupData;
import com.ht.scada.oildata.entity.WetkSGT;
import com.ht.scada.oildata.model.GTSC;
import com.ht.scada.oildata.service.WetkSGTService;
import com.ht.scada.oildata.util.String2FloatArrayUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.data.Row;

import javax.inject.Inject;
import java.util.*;

/**
 * 需要写sql语句实时
 *
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
        } catch (Exception e) {
            System.out.println("e:" + e.getMessage());//
        }//

    }

    @Override
    public void addOneGTFXRecord(String gtId, String code, Date cjDate, float CC, float CC1, float ZDZH, float ZXZH, Float BJ, Float HS, Float YYMD,Float JSXS) {
        String sql = "INSERT INTO QYSCZH.SCY_SGT_GTFX (ID, JH, CJSJ, GTID, CC, CC1, ZDZH, ZXZH, BJ, HS, YYMD, JSXS) " //
                + "values (:ID,:JH,:CJSJ,:GTID,:CC,:CC1,:ZDZH,:ZXZH, :BJ, :HS, :YYMD,:JSXS) ";//

        try (Connection con = sql2o.open()) {  //
            con.createQuery(sql)  //
                    .addParameter("ID", CommonUtils.getCode())//
                    .addParameter("JH", code)//
                    .addParameter("CJSJ", cjDate)//
                    .addParameter("GTID", gtId)//
                    .addParameter("CC", CC)//
                    .addParameter("CC1", CC1)//
                    .addParameter("ZDZH", ZDZH)//
                    .addParameter("ZXZH", ZXZH)//
                    .addParameter("BJ", BJ)//
                    .addParameter("HS", HS)//
                    .addParameter("YYMD", YYMD)//
                    .addParameter("JSXS", JSXS)
                    .executeUpdate();//
        } catch (Exception e) {
            System.out.println("e:" + e.getMessage());//
        }

    }

    @Override
    public GTSC findOneGTFXRecordByCode(String code) {
        //String sql = "select q.RCYL1 rcyl1,q.RCYL rcyl,s.JH jh,q.CJSJ cjsj,s.WY wy,q.BGT bgt FROM QYSCZH.SCY_SGT_GTCJ s inner join QYSCZH.SCY_SGT_GTFX q on s.JH=:CODE AND q.SCJSBZ = 1 AND q.JH=s.JH ORDER BY q.CJSJ DESC ";//
        String sql = "SELECT" +//
                "  q.RCYL1 rcyl1, " +//
                "  q.RCYL  rcyl, " +//
                "  s.JH    jh, " +//
                "  q.CJSJ  cjsj, " +//
                "  s.WY    wy, " +//
                "  q.BGT   bgt " +//
                " FROM QYSCZH.SCY_SGT_GTCJ s LEFT JOIN QYSCZH.SCY_SGT_GTFX q ON q.JH = s.JH AND s.cjsj = q.cjsj AND s.id = q.gtid " +
                " WHERE s.JH = :CODE and q.cjsj is not null ORDER BY q.CJSJ DESC ";
        try (Connection con = sql2o.open()) {  //
            org.sql2o.Query query = con.createQuery(sql).addParameter("CODE", code);
            return query.executeAndFetchFirst(GTSC.class);
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
                    .addParameter("CODE", JH).addParameter("CJSJ", CJSJ).executeAndFetchFirst(GTSC.class);
        }
    }

    @Override
    public List<GTSC> findGTSCRecordByJHAndTime(String JH, Date startTime, Date endTime) {
        List<GTSC> rtnList = new ArrayList<>();
        String sql = "SELECT GTCJ.JH jh,GTCJ.CJSJ cjsj,GTFX.RCYL rcyl,GTFX.RCYL1 rcyl1,GTCJ.WY wy,GTCJ.ZH zh, " + //
                "GTCJ.ZDZH zdzh,GTCJ.ZXZH zxzh,GTFX.JSBZ jsbz,GTCJ.CC cc,GTCJ.CC1 cc1 FROM QYSCZH.SCY_SGT_GTFX GTFX " +//
                "LEFT JOIN QYSCZH.SCY_SGT_GTCJ GTCJ ON GTFX.GTID=GTCJ.ID WHERE GTFX.SCJSBZ=1 AND GTFX.JH=:JH AND GTCJ.CJSJ>=:startTime AND GTCJ.CJSJ<:endTime ORDER BY cjsj DESC";
        try (Connection con = sql2o.open()) {  //
            org.sql2o.Query query = con.createQuery(sql).addParameter("JH", JH).addParameter("startTime", startTime).addParameter("endTime", endTime);
            List<Row> dataList = query.executeAndFetchTable().rows();
            for (Row row : dataList) {
                GTSC gtsc = new GTSC();
                gtsc.setJH(row.getString("jh"));
                gtsc.setCJSJ(row.getString("cjsj"));
                if (row.getFloat("rcyl") == null) {
                    gtsc.setRCYL(0f);
                } else {
                    gtsc.setRCYL(row.getFloat("rcyl"));
                }
                if (row.getFloat("rcyl1") == null) {
                    gtsc.setRCYL1(0f);
                } else {
                    gtsc.setRCYL1(row.getFloat("rcyl1"));
                }
                gtsc.setWY(row.getString("wy"));
                gtsc.setZH(row.getString("zh"));
                gtsc.setZDZH(row.getFloat("zdzh"));
                gtsc.setZXZH(row.getFloat("zxzh"));
                gtsc.setJSBZ(row.getFloat("jsbz"));
                gtsc.setCC(row.getFloat("cc"));
                gtsc.setCC1(row.getFloat("cc1"));
                rtnList.add(gtsc);
            }
        }
        return rtnList;
    }

    @Override
    public void updateGtfxByJhAndCJSJ(String JH, Date CJSJ) {
        Date endDate = new Date(CJSJ.getTime() + 1000);
        //System.out.println("CJSJ:--" + LocalDateTime.fromDateFields(CJSJ).toString("yyyy-MM-dd HH:mm:ss"));
        String sql = "update qysczh.SCY_SGT_GTFX f set f.jsbz=1 where f.jh=:JH and f.cjsj>=:CJSJ and f.cjsj<:endDate"; // 时间查询时不能直接写"="
        try (Connection con = sql2o.open()) {  //
            con.createQuery(sql)//
                    .addParameter("JH", JH)//
                    .addParameter("CJSJ", CJSJ)//
                    .addParameter("endDate", endDate).executeUpdate();
            con.commit();
        }
        //try (Connection con = sql2o.beginTransaction()) {  //
        //    org.sql2o.Query query = con.createQuery(sql)//
        //            .addParameter("JH", JH)//
        //            .addParameter("CJSJ", CJSJ)//
        //            .addParameter("endDate", endDate);
        //    query.executeUpdate();
        //    con.commit();
        //}
    }

    @Override
    public List<VarGroupData> findArrayDataByCodeAndDateTimeAndType(String code, Date startDate, Date endDate, String arrayType) {
        List<VarGroupData> rtnList = new ArrayList<>();
        //select s.wei_yi_array,s.code,s.datetime,d.dian_liu_array from admin.T_GROUP_YOU_JING_SGT s
        // left join admin.T_GROUP_YOU_JING_DGT d on s.code=d.code and s.datetime=d.DATETIME
        // where s.code='GDGB1X010C' and s.datetime>= to_date('2014-5-15 16:52:16','yyyy-mm-dd hh24:mi:ss')
        // and s.datetime<to_date('2014-8-15 16:52:16','yyyy-mm-dd hh24:mi:ss') order by s.datetime desc
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("select s.wei_yi_array wy, s.code jh, s.datetime cjsj ");
        switch (arrayType) {
            case "DIAN_LIU_ARRAY":
                sqlBuilder.append(" ,d.dian_liu_array qx ");
                break;
            case "GONG_LV_ARRAY": // 有功功率曲线
                sqlBuilder.append(" ,d.gong_lv_array qx ");
                break;
            case "DIAN_GONG_TU_ARRAY": // 变频器输出转矩
                sqlBuilder.append(" ,d.dian_gong_tu_array qx ");
                break;
            case "GONG_LV_YIN_SHU_ARRAY": // 变频器输出功率
                sqlBuilder.append(" ,d.gong_lv_yin_shu_array qx ");
                break;
            //case "qjgl_array": // 起井有功功率
            //    sqlBuilder.append(" ,d.gong_lv_array ");
            //case "qjbxdl_array": // 起井B向电流
            //    sqlBuilder.append(" ,d.gong_lv_array ");
            //case "hui_ya_array": // 200点回压曲线
            //    sqlBuilder.append(" ,d.gong_lv_array ");
        }

        sqlBuilder.append(" from admin.T_GROUP_YOU_JING_SGT s left join  admin.T_GROUP_YOU_JING_DGT d on ");
        sqlBuilder.append(" s.code=d.code and s.datetime=d.DATETIME ");
        sqlBuilder.append(" where s.code=:code ");
        sqlBuilder.append(" and s.datetime>=:startDate ");
        sqlBuilder.append(" and s.datetime<:endDate ");
        sqlBuilder.append(" order by s.datetime desc ");

        try (Connection con = sql2o.open()) {
            org.sql2o.Query query = con.createQuery(sqlBuilder.toString());
            query.addParameter("code", code).addParameter("startDate", startDate).addParameter("endDate", endDate);
            List<Row> dataList = query.executeAndFetchTable().rows();
            for (Row row : dataList) {
                VarGroupData varGroupData = new VarGroupData();
                varGroupData.setDatetime(row.getDate("cjsj"));
                varGroupData.setCode(row.getString("jh"));
                float[] wei_yi_array = String2FloatArrayUtil.string2FloatArrayUtil(row.getString("wy"), ",");
                float[] qx_array = String2FloatArrayUtil.string2FloatArrayUtil(row.getString("qx"), ",");
                Map<String, float[]> map = new HashMap<>();
                map.put("wei_yi_array", wei_yi_array);
                map.put("qx_array", qx_array);
                varGroupData.setArrayValueMap(map);
                rtnList.add(varGroupData);
            }
        }

        return rtnList;
    }

    @Override
    public List<Map<String, Object>> findCloseWellDataByDate(Date dateTime) {
        List<Map<String, Object>> rtnList = new ArrayList<>();

        String sql = "select a.JH jh,a.RQ rq,b.DMMC dmmc,a.BZ bz FROM YS_DBA01@YDK a left join FLA15@YDK b on a.bzdm=b.dm  where a.RQ=:dateTime " + //
                " and a.jh in (select code from t_end_tag where type='YOU_JING') and a.BZDM is not null ";

        try (Connection con = sql2o.open()) {
            org.sql2o.Query query = con.createQuery(sql);
            query.addParameter("dateTime", dateTime);
            List<Row> dataList = query.executeAndFetchTable().rows();
            for (Row row : dataList) {
                Map<String, Object> map = new HashMap<>();
                map.put("dateTime", row.getDate("rq"));
                map.put("code", row.getString("jh"));
                map.put("type", row.getString("dmmc")); // 停井类型
                map.put("cause", row.getString("BZ"));  // 停井原因
                rtnList.add(map);
            }
        }
        return rtnList;
    }

    @Override
    public int updateEstimateRcylToDB(String code, String cyl, String yl) {
        Date dateTime = CommonUtils.getTodayZeroHour();
        String sql = "update T_WELL_DAILY_DATA set cyl=:cyl , yl=:yl where code=:code and date_time=:dateTime";
        try (Connection con = sql2o.open()) {  //
            con.createQuery(sql)//
                    .addParameter("cyl", cyl)//
                    .addParameter("yl", yl)//
                    .addParameter("code", code)//
                    .addParameter("dateTime", dateTime)//
                    .executeUpdate();
            con.commit();
        } catch (Exception e) {
            return 0;
        }

        return 1;
    }
}
