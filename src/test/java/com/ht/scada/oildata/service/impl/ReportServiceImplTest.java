package com.ht.scada.oildata.service.impl;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ht.scada.oildata.entity.OilWellDailyDataRecord;
import com.ht.scada.oildata.service.ReportService;

public class ReportServiceImplTest {
	private ReportService reportService;

	@BeforeTest
	public void beforeTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		reportService = (ReportServiceImpl) context.getBean("reportService"); 
	}

	@Test
	public void insertRecord() {
		OilWellDailyDataRecord oilWell = new OilWellDailyDataRecord();
		oilWell.setCode("test");
		oilWell.setAvgI(1.2f);
		oilWell.setAvgU(22f);
		oilWell.setBengXiao(0.8f);
		oilWell.setChongCheng(4f);
		oilWell.setChongCi(2.1f);
		oilWell.setDatetime(new Date());
		oilWell.setDongYeMian(900);
		oilWell.setEleConsume(52);
		oilWell.setHanShui(98);
		oilWell.setHuiYa(0.5f);
		oilWell.setJingKouWenDu(56f);
		oilWell.setLiquidProduct(64);
		oilWell.setOilProduct(58);
		oilWell.setPingHengDu(0.8f);
		oilWell.setRunStatus(0);
		oilWell.setRunTime(23);
		oilWell.setTaoYa(0.5f);
		oilWell.setYouYa(0.5f);
		oilWell.setZhuQi(23.4f);
		oilWell.setZhuShui(66.6f);
		
		reportService.insertOilWellDailyDataRecord(oilWell);

	}
}
