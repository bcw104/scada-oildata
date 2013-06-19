package com.ht.scada.oildata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.oildata.entity.OilWellDailyDataRecord;

public interface OilWellDailyDataRecordDao extends JpaRepository<OilWellDailyDataRecord, Integer> {
}
