package com.ht.scada.oildata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.oildata.entity.GasWellHourlyDataRecord;

public interface GasWellHourlyDataRecordDao extends JpaRepository<GasWellHourlyDataRecord, Integer> {
}
