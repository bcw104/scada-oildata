package com.ht.scada.oildata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.oildata.entity.ZhuShuiHourlyDataRecord;

public interface ZhuShuiHourlyDataRecordDao extends JpaRepository<ZhuShuiHourlyDataRecord, Integer> {
}
