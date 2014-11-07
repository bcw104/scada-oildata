package com.ht.scada.oildata.service;

import com.ht.scada.oildata.model.WellInfoWrapper;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.sql2o.Sql2o;

/**
 * 功图Service
 *
 * @author 赵磊
 */
public interface WellInfoService {

    Sql2o getSql2o();

    void setSql2o(Sql2o sql2o);

    WellInfoWrapper findWellInfoByCode(String code);

    /**
     * 获得系统内所有井的井号(游梁式和高原机器)
     *
     * @return
     */
    List<Map<String, Object>> findAllEndtagsCode();

    /**
     * 根据井号， 获得某口井的基础量油信息 目前包括: 泵径, 含水率, 原油密度, 水密度
     *
     * @param 井号
     * @return [rq, hs, 1, bj, dmyymd]
     */
    Map<String, Object> findBasicCalculateInforsByCode(String code);

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
    void addOneTWellInforRecord(String id, String code, float bengJing,
            float hanShui, float SMD, float YYMD, Date lrqi);
}
