package com.ht.scada.oildata.service.impl;

import javax.inject.Inject;

import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import com.ht.scada.oildata.entity.WellData;
import com.ht.scada.oildata.service.WellService;

@ContextConfiguration(locations = "classpath:test-context.xml")
public class WellDataServiceImplTest {
	@Inject
	private WellService wellService;

  @Test
  public void getLatestWellDataByWellNum() {
	  try {
		System.out.println(wellService == null);
		WellData wellData = wellService.getLatestWellDataByWellNum("y93p5");
		System.out.println(wellData.getCode());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
