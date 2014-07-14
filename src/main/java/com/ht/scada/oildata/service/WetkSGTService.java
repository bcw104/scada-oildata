package com.ht.scada.oildata.service;

import com.ht.scada.oildata.entity.WetkSGT;
import org.sql2o.Sql2o;

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
     * 查询所有记录
     * @return
     */
    List<WetkSGT> getAllRecords();
}
