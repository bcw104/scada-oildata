package com.ht.scada.oildata.service.impl;

import java.util.Date;
import java.util.List;

import com.ht.scada.oildata.entity.ChouYouGanShouLi;
import com.ht.scada.oildata.entity.WellDGTData;
import com.ht.scada.oildata.entity.WellData;
import com.ht.scada.oildata.service.WellService;

/**
 * @author 薄成文
 * @author 赵磊
 *
 */
public class WellDataServiceImpl implements WellService {
	
	public void saveWellSGTData(String code, float[] zaihe, float[] weiyi,
			float chongcheng, float chongci) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public WellData getLatestWellDataByWellNum(String wellNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

	public String getLatestProductByWellNum(String wellNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLatestWellFaultByWellNum(String wellNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

	public double getDailyOilProduct(String code, Date date) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WellDGTData getLatestWellDGTDataByWellNum(String wellNum)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public WellData getWellDataByWellNumAndDatetime(String wellNum, Date time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WellData> getWellDataByWellNumAndDatetime(String wellNum,
			Date startTime, Date endTime) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChouYouGanShouLi> getLatestCYGShouLi(String wellNum) {
		// TODO Auto-generated method stub
		return null;
	}
}
