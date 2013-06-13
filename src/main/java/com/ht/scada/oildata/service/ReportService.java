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

/**
 * 报表相关service
 * @author 赵磊
 *
 */
public interface ReportService {
	void insertOilWellDailyDataRecord(OilWellDailyDataRecord oilWellDailyDataRecord);
	void insertOilWellHourlyDataRecord(OilWellHourlyDataRecord oilWellHourlyDataRecord);
	
	void insertGasWellDailyDataRecord(GasWellDailyDataRecord gasWellDailyDataRecord);
	void insertGasWellHourlyDataRecord(GasWellHourlyDataRecord gasWellHourlyDataRecord);
	
	void insertWaterWellDailyDataRecord(WaterWellDailyDataRecord waterWellDailyDataRecord);
	void insertWaterWellHourlyDataRecord(WaterWellHourlyDataRecord waterWellHourlyDataRecord);
	
	void insertZhuShuiDailyDataRecord(ZhuShuiDailyDataRecord zhuShuiDailyDataRecord);
	void insertZhuShuiHourlyDataRecord(ZhuShuiHourlyDataRecord zhuShuiHourlyDataRecord);
	
	void insertZhuQiDailyDataRecord(ZhuQiDailyDataRecord zhuQiDailyDataRecord);
	void insertZhuQiHourlyDataRecord(ZhuQiHourlyDataRecord zhuQiHourlyDataRecord);

	void insertZengYaZhanDailyDataRecord(ZengYaZhanDailyDataRecord zengYaZhanDailyDataRecord);
	
}
