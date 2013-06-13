package com.ht.scada.oildata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.oildata.entity.WaterWellDailyDataRecord;

public interface WaterWellDailyDataRecordDao extends JpaRepository<WaterWellDailyDataRecord, Integer> {
}
