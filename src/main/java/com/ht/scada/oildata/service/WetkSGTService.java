package com.ht.scada.oildata.service;

import com.ht.scada.oildata.entity.WetkSGT;
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
    void addOneGTFXRecord(String gtId,String code,Date cjDate);

    /**
     * 查询所有记录
     * @return
     */
    List<WetkSGT> getAllRecords();
}
