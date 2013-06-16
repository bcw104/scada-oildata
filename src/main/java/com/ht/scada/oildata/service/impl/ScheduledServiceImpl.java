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
import java.util.Date;

/**
 * @author 赵磊
 *
 */
@Transactional
@Service("scheduledService")
public class ScheduledServiceImpl implements ScheduledService {

    @Override
    public OilWellDailyDataRecord getYesterdayOilWellDailyDataRecordByCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OilWellHourlyDataRecord getOilWellHourlyDataRecordByCode(String code, int timeInterval, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }	

    @Override
    public WaterWellHourlyDataRecord getWaterWellHourlyDataRecordByCode(String code, int timeInterval, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WaterWellDailyDataRecord getYesterdayWaterWellDailyDataRecordByCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GasWellHourlyDataRecord getGasWellHourlyDataRecordByCode(String code, int timeInterval, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GasWellDailyDataRecord getYesterdayGasWellDailyDataRecordByCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ZengYaZhanDailyDataRecord getYesterdayZengYaZhanDailyDataRecordByCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ZhuQiHourlyDataRecord getZhuQiHourlyDataRecordByCode(String code, int timeInterval, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ZhuQiDailyDataRecord getYesterdayZhuQiDailyDataRecordByCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ZhuShuiHourlyDataRecord getZhuShuiHourlyDataRecordByCode(String code, int timeInterval, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ZhuShuiDailyDataRecord getYesterdayZhuShuiDailyDataRecordByCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}
