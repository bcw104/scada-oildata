package com.ht.scada.oildata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.oildata.entity.ZhuShuiDailyDataRecord;

public interface ZhuShuiDailyDataRecordDao extends JpaRepository<ZhuShuiDailyDataRecord, Integer> {
}
