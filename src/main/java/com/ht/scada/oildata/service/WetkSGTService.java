package com.ht.scada.oildata.service;

import com.ht.scada.oildata.entity.WetkSGT;
import com.ht.scada.oildata.model.GTSC;
import org.sql2o.Sql2o;

import java.util.Date;
import java.util.List;

/**
 * 威尔泰克示功图
 */
public interface WetkSGTService {
    Sql2o getSql2o();
    void setSql2o(Sql2o sql2o);

    /**
     * 增加记录
     *
     * @param wetkSGT
     */
    void addOneRecord(WetkSGT wetkSGT);

    /**
     * 添加一条功图分析数据
     * @param gtId 功图id
     * @param code 井号
     * @param cjDate 采集时间
     */
    void addOneGTFXRecord(String gtId,String code,Date cjDate,float cc,float cc1,float zdzh,float zxzh);

    /**
     * 获取单井功图计产数据(产液量、产油量)
     * @param code 井号
     */
    GTSC findOneGTFXRecordByCode(String code);

    /**
     * 查询所有记录
     * @return
     */
    List<WetkSGT> getAllRecords();

    /**
     * 根据功图采集时间和井号查询功图计产记录
     * @return
     */
    GTSC findGTSCRecordByJHAndCJSJ(String JH, String CJSJ);
}
