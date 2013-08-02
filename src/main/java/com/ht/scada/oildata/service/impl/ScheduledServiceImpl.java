package com.ht.scada.oildata.service.impl;


import com.ht.scada.common.tag.entity.EndTagExtInfo;
import com.ht.scada.common.tag.service.EndTagExtInfoService;
import com.ht.scada.common.tag.util.EndTagExtNameEnum;
import com.ht.scada.common.tag.util.VarSubTypeEnum;
import com.ht.scada.data.service.RealtimeDataService;
import com.ht.scada.oildata.entity.GasWellDailyDataRecord;
import com.ht.scada.oildata.entity.GasWellHourlyDataRecord;
import com.ht.scada.oildata.entity.OilWellDailyDataRecord;
import com.ht.scada.oildata.entity.OilWellHourlyDataRecord;
import com.ht.scada.oildata.entity.WaterWellDailyDataRecord;
import com.ht.scada.oildata.entity.WaterWellHourlyDataRecord;
import com.ht.scada.oildata.entity.WellData;
import com.ht.scada.oildata.entity.ZengYaZhanDailyDataRecord;
import com.ht.scada.oildata.entity.ZhuQiDailyDataRecord;
import com.ht.scada.oildata.entity.ZhuQiHourlyDataRecord;
import com.ht.scada.oildata.entity.ZhuShuiDailyDataRecord;
import com.ht.scada.oildata.entity.ZhuShuiHourlyDataRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.oildata.service.ScheduledService;
import com.ht.scada.oildata.service.WellService;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

/**
 * @author 赵磊
 *
 */
@Transactional
@Service("scheduledService")
public class ScheduledServiceImpl implements ScheduledService {
	@Inject
	private RealtimeDataService realtimeDataService;
	@Inject
	private EndTagExtInfoService endTagExtInfoService;
        @Inject
        private WellService wellService;

    @Override
    public OilWellDailyDataRecord getYesterdayOilWellDailyDataRecordByCode(String code) {
    	OilWellDailyDataRecord oilWell = new OilWellDailyDataRecord();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        oilWell.setStatisticsDate(cal.getTime());//昨天
        oilWell.setCode(code);
        WellData wellData = wellService.getLatestWellDataByWellNum(code);
        
        oilWell.setAvgI(0.2f);
        oilWell.setAvgU(212f);
        oilWell.setBengXiao(wellData.getBengXiao());
        oilWell.setChongCheng(wellData.getChongCheng());
        oilWell.setChongCi(wellData.getChongCi());
        oilWell.setDongYeMian(900);
        oilWell.setEleConsume(wellData.getRiHaoDian());
        EndTagExtInfo extInfo = endTagExtInfoService.getByCodeAndKeyName(code, EndTagExtNameEnum.HAN_SHUI_LV.toString());  
        oilWell.setHanShui(extInfo == null?0:Float.valueOf(extInfo.getValue()));
        
        oilWell.setLiquidProduct(wellData.getChanYeLiang());
        oilWell.setOilProduct(oilWell.getLiquidProduct()*(1-oilWell.getHanShui()));
        
        oilWell.setHuiYa(0f);
        oilWell.setJingKouWenDu(35.2f);
        oilWell.setTaoYa(0f);
        oilWell.setYouYa(0f);

        oilWell.setPingHengDu(wellData.getPingHengDu());
        String runStatus = realtimeDataService.getEndTagVarInfo(code, VarSubTypeEnum.QI_TING_ZHUANG_TAI.toString().toLowerCase());
        if(runStatus.equals("true")) {
        	oilWell.setRunStatus(1);
        	oilWell.setRunTime(24);
        } else {
        	oilWell.setRunStatus(0);
        	oilWell.setRunTime(23);
        }

        
        oilWell.setZhuQi(0);
        oilWell.setZhuShui(0);
        oilWell.setSaveDatetime(new Date());
        return oilWell;
    }

    @Override
    public OilWellHourlyDataRecord getOilWellHourlyDataRecordByCode(String code, int timeInterval, Date date) {
    	OilWellHourlyDataRecord oilWell = new OilWellHourlyDataRecord();
    	
        oilWell.setStatisticsDate(date);
        oilWell.setStatisticsTime(date);
        oilWell.setCode(code);
        
        WellData wellData = wellService.getLatestWellDataByWellNum(code);
        
        oilWell.setEleConsume(wellData.getRiHaoDian()*24*60/timeInterval);
        
        EndTagExtInfo extInfo = endTagExtInfoService.getByCodeAndKeyName(code, EndTagExtNameEnum.HAN_SHUI_LV.toString());  
        oilWell.setHanShui(extInfo == null?0:Float.valueOf(extInfo.getValue()));	//含水率
        
        oilWell.setLiquidProduct(wellData.getChanYeLiang()*24*60/timeInterval);
        oilWell.setOilProduct(oilWell.getLiquidProduct()*(1-oilWell.getHanShui()));
        
        String runStatus = realtimeDataService.getEndTagVarInfo(code, VarSubTypeEnum.QI_TING_ZHUANG_TAI.toString().toLowerCase());
        if(runStatus.equals("true")) {
        	oilWell.setRunStatus(1);
        	oilWell.setRunTime(timeInterval);
        } else {
        	oilWell.setRunStatus(0);
        	oilWell.setRunTime(0);
        }
        
        oilWell.setZhuQi(0);
        oilWell.setZhuShui(0);
        
        oilWell.setSaveDatetime(new Date());

        return oilWell;
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
