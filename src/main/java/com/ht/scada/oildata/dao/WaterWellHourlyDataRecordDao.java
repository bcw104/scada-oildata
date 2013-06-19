package com.ht.scada.oildata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.oildata.entity.WaterWellHourlyDataRecord;

public interface WaterWellHourlyDataRecordDao extends JpaRepository<WaterWellHourlyDataRecord, Integer> {
}
