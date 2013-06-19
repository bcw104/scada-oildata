package com.ht.scada.oildata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.oildata.entity.GasWellDailyDataRecord;

public interface GasWellDailyDataRecordDao extends JpaRepository<GasWellDailyDataRecord, Integer> {
}
