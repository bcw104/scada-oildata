package com.ht.scada.oildata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.oildata.entity.ZhuQiHourlyDataRecord;

public interface ZhuQiHourlyDataRecordDao extends JpaRepository<ZhuQiHourlyDataRecord, Integer> {
}
