package com.ht.scada.oildata.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.oildata.dao.GasWellDailyDataRecordDao;
import com.ht.scada.oildata.dao.GasWellHourlyDataRecordDao;
import com.ht.scada.oildata.dao.OilWellDailyDataRecordDao;
import com.ht.scada.oildata.dao.OilWellHourlyDataRecordDao;
import com.ht.scada.oildata.dao.WaterWellDailyDataRecordDao;
import com.ht.scada.oildata.dao.WaterWellHourlyDataRecordDao;
import com.ht.scada.oildata.dao.ZengYaZhanDailyDataRecordDao;
import com.ht.scada.oildata.dao.ZhuQiDailyDataRecordDao;
import com.ht.scada.oildata.dao.ZhuQiHourlyDataRecordDao;
import com.ht.scada.oildata.dao.ZhuShuiDailyDataRecordDao;
import com.ht.scada.oildata.dao.ZhuShuiHourlyDataRecordDao;
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
import com.ht.scada.oildata.service.ReportService;

/**
 * @author 赵磊
 *
 */
@Transactional
@Service("reportService")
public class ReportServiceImpl implements ReportService {
	@Inject
	private OilWellDailyDataRecordDao oilWellDailyDataRecordDao;
	@Inject
	private OilWellHourlyDataRecordDao oilWellHourlyDataRecordDao;
	@Inject
	private GasWellDailyDataRecordDao gasWellDailyDataRecordDao;
	@Inject
	private GasWellHourlyDataRecordDao gasWellHourlyDataRecordDao;
	@Inject
	private WaterWellDailyDataRecordDao waterWellDailyDataRecordDao;
	@Inject
	private WaterWellHourlyDataRecordDao waterWellHourlyDataRecordDao;
	@Inject
	private ZengYaZhanDailyDataRecordDao zengYaZhanDailyDataRecordDao;
	@Inject
	private ZhuShuiDailyDataRecordDao zhuShuiDailyDataRecordDao;
	@Inject
	private ZhuShuiHourlyDataRecordDao zhuShuiHourlyDataRecordDao;
	@Inject
	private ZhuQiDailyDataRecordDao zhuQiDailyDataRecordDao;
	@Inject
	private ZhuQiHourlyDataRecordDao zhuQiHourlyDataRecordDao;
	

	@Override
	public void insertOilWellDailyDataRecord(
			OilWellDailyDataRecord oilWellDailyDataRecord) {
		oilWellDailyDataRecordDao.save(oilWellDailyDataRecord);
	}

	@Override
	public void insertOilWellHourlyDataRecord(
			OilWellHourlyDataRecord oilWellHourlyDataRecord) {
		oilWellHourlyDataRecordDao.save(oilWellHourlyDataRecord);
	}

	@Override
	public void insertGasWellDailyDataRecord(
			GasWellDailyDataRecord gasWellDailyDataRecord) {
		gasWellDailyDataRecordDao.save(gasWellDailyDataRecord);
	}

	@Override
	public void insertGasWellHourlyDataRecord(
			GasWellHourlyDataRecord gasWellHourlyDataRecord) {
		gasWellHourlyDataRecordDao.save(gasWellHourlyDataRecord);
	}

	@Override
	public void insertWaterWellDailyDataRecord(
			WaterWellDailyDataRecord waterWellDailyDataRecord) {
		waterWellDailyDataRecordDao.save(waterWellDailyDataRecord);
	}

	@Override
	public void insertWaterWellHourlyDataRecord(
			WaterWellHourlyDataRecord waterWellHourlyDataRecord) {
		waterWellHourlyDataRecordDao.save(waterWellHourlyDataRecord);
	}

	@Override
	public void insertZhuShuiDailyDataRecord(
			ZhuShuiDailyDataRecord zhuShuiDailyDataRecord) {
		zhuShuiDailyDataRecordDao.save(zhuShuiDailyDataRecord);
	}

	@Override
	public void insertZhuShuiHourlyDataRecord(
			ZhuShuiHourlyDataRecord zhuShuiHourlyDataRecord) {
		zhuShuiHourlyDataRecordDao.save(zhuShuiHourlyDataRecord);
	}

	@Override
	public void insertZhuQiDailyDataRecord(
			ZhuQiDailyDataRecord zhuQiDailyDataRecord) {
		zhuQiDailyDataRecordDao.save(zhuQiDailyDataRecord);
	}

	@Override
	public void insertZhuQiHourlyDataRecord(
			ZhuQiHourlyDataRecord zhuQiHourlyDataRecord) {
		zhuQiHourlyDataRecordDao.save(zhuQiHourlyDataRecord);
	}

	@Override
	public void insertZengYaZhanDailyDataRecord(
			ZengYaZhanDailyDataRecord zengYaZhanDailyDataRecord) {
		zengYaZhanDailyDataRecordDao.save(zengYaZhanDailyDataRecord);
	}
	
	
}
