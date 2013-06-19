package com.ht.scada.oildata.service.impl;

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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.oildata.service.ScheduledService;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 赵磊
 *
 */
@Transactional
@Service("scheduledService1")
public class ScheduledServiceImpl1 implements ScheduledService {

    @Override
    public OilWellHourlyDataRecord getOilWellHourlyDataRecordByCode(String code, int timeInterval, Date date) {
        OilWellHourlyDataRecord oilWell = new OilWellHourlyDataRecord();
        oilWell.setStatisticsDate(date);
        oilWell.setStatisticsTime(date);
        oilWell.setCode(code);
        oilWell.setEleConsume(12.2f);
        oilWell.setHanShui(70);
        oilWell.setLiquidProduct(12.7f);
        oilWell.setOilProduct(10);
        oilWell.setRunTime(timeInterval);
        oilWell.setRunStatus(1);
        oilWell.setZhuQi(34.5f);
        oilWell.setZhuShui(333.7f);
        oilWell.setSaveDatetime(new Date());

        return oilWell;
    }

    @Override
    public OilWellDailyDataRecord getYesterdayOilWellDailyDataRecordByCode(String code) {
        OilWellDailyDataRecord oilWell = new OilWellDailyDataRecord();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        oilWell.setStatisticsDate(cal.getTime());//昨天
        oilWell.setCode(code);
        oilWell.setAvgI(1.2f);
        oilWell.setAvgU(22f);
        oilWell.setBengXiao(0.8f);
        oilWell.setChongCheng(4f);
        oilWell.setChongCi(2.1f);
        oilWell.setDongYeMian(900);
        oilWell.setEleConsume(52);
        oilWell.setHanShui(98);
        oilWell.setHuiYa(0.5f);
        oilWell.setJingKouWenDu(56f);
        oilWell.setLiquidProduct(64);
        oilWell.setOilProduct(58);
        oilWell.setPingHengDu(0.8f);
        oilWell.setRunStatus(0);
        oilWell.setRunTime(23);
        oilWell.setTaoYa(0.5f);
        oilWell.setYouYa(0.5f);
        oilWell.setZhuQi(23.4f);
        oilWell.setZhuShui(66.6f);
        oilWell.setSaveDatetime(new Date());
        return oilWell;
    }

    @Override
    public WaterWellHourlyDataRecord getWaterWellHourlyDataRecordByCode(String code, int timeInterval, Date date) {
        WaterWellHourlyDataRecord waterWellHourlyDataRecord = new WaterWellHourlyDataRecord();
        waterWellHourlyDataRecord.setCode(code);
        waterWellHourlyDataRecord.setStatisticsDate(date);
        waterWellHourlyDataRecord.setStatisticsTime(date);
        waterWellHourlyDataRecord.setEleConsume(12.3f);
        waterWellHourlyDataRecord.setRunStatus(1);
        waterWellHourlyDataRecord.setRunTime(timeInterval);
        waterWellHourlyDataRecord.setWaterProduct(67);
        waterWellHourlyDataRecord.setSaveDatetime(new Date());

        return waterWellHourlyDataRecord;
    }

    @Override
    public WaterWellDailyDataRecord getYesterdayWaterWellDailyDataRecordByCode(String code) {
        WaterWellDailyDataRecord waterWellDailyDataRecord = new WaterWellDailyDataRecord();
        waterWellDailyDataRecord.setCode(code);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        waterWellDailyDataRecord.setStatisticsDate(cal.getTime());//昨天
        waterWellDailyDataRecord.setEleConsume(13.7f);
        waterWellDailyDataRecord.setJingYa(0.5f);
        waterWellDailyDataRecord.setRunStatus(1);
        waterWellDailyDataRecord.setRunTime(22);
        waterWellDailyDataRecord.setSsll(12.3f);
        waterWellDailyDataRecord.setWaterProduct(56.7f);
        waterWellDailyDataRecord.setWenDu(34.2f);
        waterWellDailyDataRecord.setYaLi(1.1f);
        waterWellDailyDataRecord.setYeWei(13.5f);
        waterWellDailyDataRecord.setSaveDatetime(new Date());

        return waterWellDailyDataRecord;
    }

    @Override
    public GasWellHourlyDataRecord getGasWellHourlyDataRecordByCode(String code, int timeInterval, Date date) {
        GasWellHourlyDataRecord gasWellHourlyDataRecord = new GasWellHourlyDataRecord();
        gasWellHourlyDataRecord.setCode(code);
        gasWellHourlyDataRecord.setStatisticsDate(date);
        gasWellHourlyDataRecord.setStatisticsTime(date);
        gasWellHourlyDataRecord.setEleConsume(34.4f);
        gasWellHourlyDataRecord.setGasProduct(23.7f);
        gasWellHourlyDataRecord.setRunStatus(1);
        gasWellHourlyDataRecord.setRunTime(21);
        gasWellHourlyDataRecord.setSaveDatetime(new Date());

        return gasWellHourlyDataRecord;
    }

    @Override
    public GasWellDailyDataRecord getYesterdayGasWellDailyDataRecordByCode(String code) {
        GasWellDailyDataRecord gasWellDailyDataRecord = new GasWellDailyDataRecord();
        gasWellDailyDataRecord.setCode(code);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        gasWellDailyDataRecord.setStatisticsDate(cal.getTime());//昨天
        gasWellDailyDataRecord.setEleConsume(65.7f);
        gasWellDailyDataRecord.setGasProduct(33.3f);
        gasWellDailyDataRecord.setRunStatus(1);
        gasWellDailyDataRecord.setRunTime(24);
        gasWellDailyDataRecord.setSaveDatetime(new Date());

        return gasWellDailyDataRecord;
    }

    @Override
    public ZengYaZhanDailyDataRecord getYesterdayZengYaZhanDailyDataRecordByCode(String code) {
        ZengYaZhanDailyDataRecord zengYaZhanDailyDataRecord = new ZengYaZhanDailyDataRecord();
        zengYaZhanDailyDataRecord.setCode(code);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        zengYaZhanDailyDataRecord.setStatisticsDate(cal.getTime());//昨天
        zengYaZhanDailyDataRecord.setEleConsume(65.7f);
        zengYaZhanDailyDataRecord.setChuWenDu(32);
        zengYaZhanDailyDataRecord.setDddf(95);
        zengYaZhanDailyDataRecord.setLjll(45);
        zengYaZhanDailyDataRecord.setRuWenDu(65);
        zengYaZhanDailyDataRecord.setSsll(12.8f);
        zengYaZhanDailyDataRecord.setWenDu1(12);
        zengYaZhanDailyDataRecord.setWenDu2(23);
        zengYaZhanDailyDataRecord.setYaLi(1.7f);
        zengYaZhanDailyDataRecord.setYeWei(16.8f);
        zengYaZhanDailyDataRecord.setRunStatus(1);
        zengYaZhanDailyDataRecord.setRunTime(24);
        zengYaZhanDailyDataRecord.setSaveDatetime(new Date());

        return zengYaZhanDailyDataRecord;
    }

    @Override
    public ZhuQiHourlyDataRecord getZhuQiHourlyDataRecordByCode(String code, int timeInterval, Date date) {
        ZhuQiHourlyDataRecord zhuQiHourlyDataRecord = new ZhuQiHourlyDataRecord();
        zhuQiHourlyDataRecord.setCode(code);
        zhuQiHourlyDataRecord.setStatisticsDate(date);
        zhuQiHourlyDataRecord.setStatisticsTime(date);
        zhuQiHourlyDataRecord.setEleConsume(34.4f);
        zhuQiHourlyDataRecord.setGas(222.f);
        zhuQiHourlyDataRecord.setRunStatus(1);
        zhuQiHourlyDataRecord.setRunTime(21);
        zhuQiHourlyDataRecord.setSaveDatetime(new Date());

        return zhuQiHourlyDataRecord;
    }

    @Override
    public ZhuQiDailyDataRecord getYesterdayZhuQiDailyDataRecordByCode(String code) {
        ZhuQiDailyDataRecord zhuQiDailyDataRecord = new ZhuQiDailyDataRecord();
        zhuQiDailyDataRecord.setCode(code);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        zhuQiDailyDataRecord.setStatisticsDate(cal.getTime());//昨天
        zhuQiDailyDataRecord.setEleConsume(65.7f);
        zhuQiDailyDataRecord.setGanDu(12.5f);
        zhuQiDailyDataRecord.setGas(222.7f);
        zhuQiDailyDataRecord.setSsll(12.666f);
        zhuQiDailyDataRecord.setWenDu(12);
        zhuQiDailyDataRecord.setYaLi(1.888f);
        zhuQiDailyDataRecord.setRunStatus(1);
        zhuQiDailyDataRecord.setRunTime(24);
        zhuQiDailyDataRecord.setSaveDatetime(new Date());

        return zhuQiDailyDataRecord;
    }

    @Override
    public ZhuShuiHourlyDataRecord getZhuShuiHourlyDataRecordByCode(String code, int timeInterval, Date date) {
        ZhuShuiHourlyDataRecord zhuShuiHourlyDataRecord = new ZhuShuiHourlyDataRecord();
        zhuShuiHourlyDataRecord.setCode(code);
        zhuShuiHourlyDataRecord.setStatisticsDate(date);
        zhuShuiHourlyDataRecord.setStatisticsTime(date);
        zhuShuiHourlyDataRecord.setEleConsume(34.4f);
        zhuShuiHourlyDataRecord.setWater(111.6f);
        zhuShuiHourlyDataRecord.setRunStatus(1);
        zhuShuiHourlyDataRecord.setRunTime(21);
        zhuShuiHourlyDataRecord.setSaveDatetime(new Date());

        return zhuShuiHourlyDataRecord;
    }

    @Override
    public ZhuShuiDailyDataRecord getYesterdayZhuShuiDailyDataRecordByCode(String code) {
        ZhuShuiDailyDataRecord zhuShuiDailyDataRecord = new ZhuShuiDailyDataRecord();
        zhuShuiDailyDataRecord.setCode(code);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        zhuShuiDailyDataRecord.setStatisticsDate(cal.getTime());//昨天
        zhuShuiDailyDataRecord.setEleConsume(65.7f);
        zhuShuiDailyDataRecord.setSsll(12.6f);
        zhuShuiDailyDataRecord.setWater(2222.7f);
        zhuShuiDailyDataRecord.setWenDu(34.9f);
        zhuShuiDailyDataRecord.setYaLi(34.7f);
        zhuShuiDailyDataRecord.setRunStatus(1);
        zhuShuiDailyDataRecord.setRunTime(24);
        zhuShuiDailyDataRecord.setSaveDatetime(new Date());

        return zhuShuiDailyDataRecord;
    }
}
