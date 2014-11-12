/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.scada.oildata.service.impl;

import com.ht.scada.oildata.model.WellInfoWrapper;
import com.ht.scada.oildata.service.WellInfoService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

/**
 *
 * @author 赵磊 2014-8-3 15:03:50
 */
@Transactional
@Service("wellInfoService")
public class WellInfoServiceImpl implements WellInfoService {

    @Inject
    protected Sql2o sql2o;

    @Override
    public Sql2o getSql2o() {
        return sql2o;
    }

    @Override
    public void setSql2o(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public WellInfoWrapper findWellInfoByCode(String code) {
        String sql = "SELECT beng_jing,han_shui,yymd FROM T_WELL_INFO WHERE CODE =:CODE ORDER BY LRSJ DESC ";//
        try (Connection con = sql2o.open()) {  //
            return con.createQuery(sql)
                    .addParameter("CODE", code)
                    .executeAndFetchFirst(WellInfoWrapper.class);
        }
    }

    /**
     * 获得系统内所有井的井号(游梁式和高原机器)
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> findAllEndtagsCode() {
        String sql = "SELECT code FROM t_end_tag WHERE TYPE ='YOU_JING' and SUB_TYPE = 'YOU_LIANG_SHI' or SUB_TYPE='GAO_YUAN_JI'";//
        List<Map<String, Object>> list;
        try (Connection con = sql2o.open()) { //
            list = con.createQuery(sql)
                    .executeAndFetchTable().asList();

        }
        return list;
    }

    /**
     * 根据井号， 获得某口井的基础量油信息 目前包括: 泵径, 含水率, 原油密度, 水密度
     *
     * @param 井号
     * @return [rq, hs, 1, bj, dmyymd]
     */
    @Override
    public Map<String, Object> findBasicCalculateInforsByCode(String code) {

        String sql = "select * from (select s.BJ, s.HS,s.RQ, q.DMYYMD, 1 from ys_dba01@ydk s "
                + "inner join ys_dfc05@ydk q on s.JH=:CODE "
                + "and q.jcd=:CODE  where s.BJ is not null and s.HS "
                + "is not null and q.DMYYMD is not null order by s.RQ DESC, q.HYRQ DESC) where rownum<=1";

        List<Map<String, Object>> list;
        try (Connection con = sql2o.open()) { //
            list = con.createQuery(sql)
                    .addParameter("CODE", code)
                    .executeAndFetchTable().asList();

        }
        if(list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 插入一条self量油信息
     *
     * @param id
     * @param code
     * @param bengJing
     * @param hanShui
     * @param SMD
     * @param YYMD
     * @param lrqi
     */
    @Override
    public void addOneTWellInforRecord(String id, String code, float bengJing,
            float hanShui, float SMD, float YYMD, Date lrqi) {
        String sql = "Insert into T_WELL_INFO "
                + "(ID, code, BENG_JING, HAN_SHUI, SMD, YYMD, LRSJ) "
                + "values (:ID, :CODE, :BENG_JING, :HAN_SHUI, :SMD, :YYMD, :LRSY)";

        try (Connection con = sql2o.open()) {  			//
            con.createQuery(sql) //
                    .addParameter("ID", id) //
                    .addParameter("CODE", code) //
                    .addParameter("BENG_JING", bengJing)//
                    .addParameter("HAN_SHUI", hanShui) //
                    .addParameter("SMD", SMD) //
                    .addParameter("YYMD", YYMD) //
                    .addParameter("LRSY", lrqi) //
                    .executeUpdate();//
        } catch (Exception e) {
            System.out.println("e:" + e.getMessage());//
        }

    }
}
