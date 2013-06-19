package com.ht.scada.oildata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.oildata.entity.ZengYaZhanDailyDataRecord;

public interface ZengYaZhanDailyDataRecordDao extends JpaRepository<ZengYaZhanDailyDataRecord, Integer> {
}
