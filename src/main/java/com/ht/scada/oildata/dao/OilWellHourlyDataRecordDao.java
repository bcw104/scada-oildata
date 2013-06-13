package com.ht.scada.oildata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.oildata.entity.OilWellHourlyDataRecord;

public interface OilWellHourlyDataRecordDao extends JpaRepository<OilWellHourlyDataRecord, Integer> {
}
