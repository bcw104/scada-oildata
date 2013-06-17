package com.ht.scada.oildata.service;

import java.util.Date;
import java.util.List;

import com.ht.scada.oildata.entity.ChouYouGanShouLi;
import com.ht.scada.oildata.entity.WellDGTData;
import com.ht.scada.oildata.entity.WellData;

public interface WellService {

	/**
	 * 获取时间段内数据
	 * @param wellNum
	 * @param datetime 日期时间，精确到小时
	 * @return
	 * @throws Exception
	 * @author 赵磊
	 */
	List<WellData> getWellDataByWellNumAndDatetime(String wellNum, Date startTime, Date endTime) throws Exception;
	
	/**
	 * 通过井号和时间获得历史的油井示功图及相关信息
	 * @param wellNum
	 * @param datetime 日期时间，精确到小时
	 * @return
	 * @throws Exception
	 * @author 赵磊
	 */
	WellData getWellDataByWellNumAndDatetime(String wellNum, Date time);
	
	/**
	 * 通过井号获得最新的油井示功图及相关信息
	 * @param wellNum
	 * @return
	 * @throws Exception
	 * @author 赵磊
	 */
	WellData getLatestWellDataByWellNum(String wellNum) throws Exception;
	
	/**
	 * 通过井号获取抽油杆受力对象列表
	 * @param wellNum
	 * @return
	 */
	List<ChouYouGanShouLi> getLatestCYGShouLi(String wellNum);
	
	/**
	 * 通过井号获得最近的电功图曲线数据
	 * @return
	 * @throws Exception
	 */
	WellDGTData getLatestWellDGTDataByWellNum(String wellNum) throws Exception;
	
	/**
	 * 通过井号获得历史的电功图曲线数据
	 * @return
	 * @throws Exception
	 */
	WellDGTData geWellDGTDataByWellNumAndDatetime(String wellNum, Date time);
		
}
