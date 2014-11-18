package com.ht.scada.oildata.service;

import com.ht.scada.data.kv.VarGroupData;
import com.ht.scada.oildata.entity.WetkSGT;
import com.ht.scada.oildata.model.GTSC;
import org.sql2o.Sql2o;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    /**
     * 获取时间段内所有功图数据
     * @param JH 井号
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    List<GTSC> findGTSCRecordByJHAndTime(String JH, Date startTime, Date endTime);

    /**
     * 根据井号和采集时间更新功图分析表内的计算标记，0：有效功图，1：无效功图
     * @param JH
     * @param CJSJ
     */
    void updateGtfxByJhAndCJSJ(String JH, Date CJSJ);

    /**
     * 根据曲线类型、时间和井号获取数组数据
     * @param code
     * @param startDate
     * @param endDate
     * @param arrayType
     * @return
     */
    List<VarGroupData> findArrayDataByCodeAndDateTimeAndType(String code, Date startDate, Date endDate, String arrayType);

    /**
     * 根据日期获取源点库关井数据
     * @param dateTime
     * @return
     */
    List<Map<String,Object>> findCloseWellDataByDate(Date dateTime);

    /**
     * 更新威尔泰克数据表中油井的产液量和产油量
     * @param code
     * @param cyl
     * @param yl
     * @return
     */
    int updateEstimateRcylToDB(String code,String cyl,String yl);

    /**
     * 更新源点数据表中油井的产液量和产油量
     * @param code
     * @param cyl
     * @param yl
     * @return
     */
    int updateEstimateRcylToYDDB(String code,String cyl,String yl);

    /**
     * 获取油井的电机信息
     * @param code
     * @return
     */
    List<Map<String, Object>> getDianJiInfoByCode(String code);

    List<Map<String, Object>> getEndTagVideoInfoByCode(String code);
}
