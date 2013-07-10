package com.ht.scada.oildata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.oildata.entity.TestSGT;

public interface TestSGTDao extends JpaRepository<TestSGT, Integer> {
	
}
