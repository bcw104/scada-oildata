/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.scada.oildata.service;

import com.ht.scada.oildata.entity.GasWellDailyDataRecord;
import com.ht.scada.oildata.entity.GasWellHourlyDataRecord;
import com.ht.scada.oildata.entity.OilWellDailyDataRecord;
import com.ht.scada.oildata.entity.OilWellHourlyDataRecord;
import com.ht.scada.oildata.entity.WaterWellDailyDataRecord;
import com.ht.scada.oildata.entity.WaterWellHourlyDataRecord;
import com.ht.scada.oildata.entity.ZengYaZhanDailyDataRecord;
import com.ht.scada.oildata.entity.ZhuQiDailyDataRecord;
import com.ht.scada.oildata.entity.ZhuQiHourlyDataRecord;
import com.ht.scada.oildata.entity.ZhuShuiDailyDataRecord;
import com.ht.scada.oildata.entity.ZhuShuiHourlyDataRecord;
import java.util.Date;

/**
 * 任务调度相关服务
 * @author 赵磊
 */
public interface ScheduledService {
    /**
     * 通过井号获取上一时间间隔的油井统计值
     * @param code 井号
     * @param timeInterval 时间间隔（分钟）
     * @param date 统计时间
     * @return OilWellHourlyDataRecord
     */
    OilWellHourlyDataRecord getOilWellHourlyDataRecordByCode(String code, int timeInterval, Date date);
    /**
     * 通过井号获取昨天的油井统计值
     * @param code 井号
     * @return 
     */
    OilWellDailyDataRecord getYesterdayOilWellDailyDataRecordByCode(String code);
    /**
     * 通过井号获取上一时间间隔的水井统计值
     * @param code 井号
     * @param timeInterval 时间间隔（分钟）
     * @param date 统计时间
     * @return WaterWellHourlyDataRecord
     */
    WaterWellHourlyDataRecord getWaterWellHourlyDataRecordByCode(String code, int timeInterval, Date date);
    /**
     * 通过井号获取昨天的水井统计值
     * @param code 井号
     * @return WaterWellDailyDataRecord
     */
    WaterWellDailyDataRecord getYesterdayWaterWellDailyDataRecordByCode(String code);
    /**
     * 通过井号获取上一时间间隔的天然气井统计值
     * @param code 井号
     * @param timeInterval 时间间隔（分钟）
     * @param date 统计时间
     * @return GasWellHourlyDataRecord
     */
    GasWellHourlyDataRecord getGasWellHourlyDataRecordByCode(String code, int timeInterval, Date date);
    /**
     * 通过井号获取昨天的天然气井统计值
     * @param code 井号
     * @return GasWellDailyDataRecord
     */
    GasWellDailyDataRecord getYesterdayGasWellDailyDataRecordByCode(String code);
    /**
     * 通过编号获取昨天的增压站统计值
     * @param code 编号
     * @return ZengYaZhanDailyDataRecord
     */
    ZengYaZhanDailyDataRecord getYesterdayZengYaZhanDailyDataRecordByCode(String code);
     /**
     * 通过编号获取上一时间间隔的注汽站统计值
     * @param code 编号
     * @param timeInterval 时间间隔（分钟）
     * @param date 统计时间
     * @return ZhuQiHourlyDataRecord
     */
    ZhuQiHourlyDataRecord getZhuQiHourlyDataRecordByCode(String code, int timeInterval, Date date);
    /**
     * 通过编号获取昨天的注汽站统计值
     * @param code 编号
     * @return ZhuQiDailyDataRecord
     */
    ZhuQiDailyDataRecord getYesterdayZhuQiDailyDataRecordByCode(String code);
    /**
     * 通过编号获取上一时间间隔的注水站统计值
     * @param code 编号
     * @param timeInterval 时间间隔（分钟）
     * @param date 统计时间
     * @return ZhuShuiHourlyDataRecord
     */
    ZhuShuiHourlyDataRecord getZhuShuiHourlyDataRecordByCode(String code, int timeInterval, Date date);
    /**
     * 通过编号获取昨天的注水站统计值
     * @param code 编号
     * @return ZhuShuiDailyDataRecord
     */
    ZhuShuiDailyDataRecord getYesterdayZhuShuiDailyDataRecordByCode(String code);
    
}
