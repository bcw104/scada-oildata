package com.ht.scada.oildata.service.impl;

import com.ht.scada.common.tag.util.VarGroupEnum;
import com.ht.scada.common.tag.util.VarSubTypeEnum;
import com.ht.scada.data.kv.VarGroupData;
import com.ht.scada.data.service.HistoryDataService;
import com.ht.scada.data.service.RealtimeDataService;
import com.ht.scada.oildata.entity.ChouYouGanShouLi;
import com.ht.scada.oildata.entity.WellDGTData;
import com.ht.scada.oildata.entity.WellData;
import com.ht.scada.oildata.service.WellService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 赵磊
 *
 */
//@Transactional
//@Service("wellDataService")
public class WellDataServiceImpl implements WellService {
	
	@Inject
	private RealtimeDataService realtimeDataService;
	@Inject
	private HistoryDataService historyDataService;
	
	@Override
	public WellData getLatestWellDataByWellNum(String wellNum) throws Exception {
		Map<String, String> map = realtimeDataService.getEndTagVarGroupInfo(wellNum, VarGroupEnum.YOU_JING_SGT.toString());
		if(map != null) {
			WellData wellData = new WellData();
			wellData.setCode(wellNum);
			wellData.setChongCheng(Float.valueOf(map.get(VarSubTypeEnum.CHONG_CHENG.toString().toLowerCase())));
			wellData.setChongCi(Float.valueOf(map.get(VarSubTypeEnum.CHONG_CI.toString().toLowerCase())));
			wellData.setChongChengTime(60/wellData.getChongCi());
			wellData.setShangChongChengTime(60/Float.valueOf(map.get(VarSubTypeEnum.SHANG_XING_CHONG_CI.toString().toLowerCase())));
			wellData.setXiaChongChengTime(60/Float.valueOf(map.get(VarSubTypeEnum.XIA_XING_CHONG_CI.toString().toLowerCase())));
			wellData.setMinZaihe(Float.valueOf(map.get(VarSubTypeEnum.ZUI_XIAO_ZAI_HE.toString().toLowerCase())));
			wellData.setMaxZaihe(Float.valueOf(map.get(VarSubTypeEnum.ZUI_DA_ZAI_HE.toString().toLowerCase())));
			
			float[] weiyi = null;//TODO:realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.WEI_YI_ARRAY.toString().toLowerCase());
			float[] zaihe = null;//TODO:realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.ZAI_HE_ARRAY.toString().toLowerCase());
			wellData.setWeiyi(weiyi);
			wellData.setZaihe(zaihe);
			
			wellData.setFalutDiagnoseInfo("正常");//TODO
			wellData.setChanYeLiang(50.6f);//TODO
			wellData.setPingHengDu(0.8f);//TODO
			wellData.setBengXiao(0.8f);//TODO
			
			String zengZongDianNeng = realtimeDataService.getEndTagVarInfo(wellNum, VarSubTypeEnum.DL_ZX_Z.toString().toLowerCase());
			wellData.setDianBiaoNum(Float.valueOf(zengZongDianNeng));//正向有功总电能
			
			wellData.setNenghaoShang(34.5f);//TODO
			wellData.setNenghaoXia(32.5f);//TODO
			wellData.setRiHaoDian(42.1f);//TODO  从生产动态数据库里取
			
			return wellData;
		}
		return null;
	}
	
	@Override
	public WellData getWellDataByWellNumAndDatetime(String wellNum, Date time) {
		VarGroupData sgtData = historyDataService.getVarGroupData(wellNum, VarGroupEnum.YOU_JING_SGT, time);
		VarGroupData dianData = historyDataService.getVarGroupData(wellNum, VarGroupEnum.DIAN_YM, time);
		if(sgtData != null && dianData != null) {
			WellData wellData = new WellData();
			wellData.setCode(wellNum);
			wellData.setChongCheng(Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.CHONG_CHENG.toString().toLowerCase())));
			wellData.setChongCi(Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.CHONG_CI.toString().toLowerCase())));
			wellData.setChongChengTime(60/wellData.getChongCi());
			wellData.setShangChongChengTime(60/Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.SHANG_XING_CHONG_CI.toString().toLowerCase())));
			wellData.setXiaChongChengTime(60/Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.XIA_XING_CHONG_CI.toString().toLowerCase())));
			wellData.setMinZaihe(Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.ZUI_XIAO_ZAI_HE.toString().toLowerCase())));
			wellData.setMaxZaihe(Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.ZUI_DA_ZAI_HE.toString().toLowerCase())));
			
			float[] weiyi = sgtData.getArrayValueMap().get(VarSubTypeEnum.WEI_YI_ARRAY.toString().toLowerCase());
			float[] zaihe = sgtData.getArrayValueMap().get(VarSubTypeEnum.ZAI_HE_ARRAY.toString().toLowerCase());
			wellData.setWeiyi(weiyi);
			wellData.setZaihe(zaihe);
			
			wellData.setFalutDiagnoseInfo("正常");//TODO
			wellData.setChanYeLiang(50.6f);//TODO
			wellData.setPingHengDu(0.8f);//TODO
			wellData.setBengXiao(0.8f);//TODO
			
			Double zengZongDianNeng = dianData.getYmValueMap().get(VarSubTypeEnum.DL_ZX_Z.toString().toLowerCase());
			wellData.setDianBiaoNum(zengZongDianNeng.floatValue());//正向有功总电能
			
			wellData.setRiHaoDian(42.1f);//TODO  从生产动态数据库里取
			wellData.setNenghaoShang(34.5f);//TODO
			wellData.setNenghaoXia(32.5f);//TODO
			
			return wellData;
		}

		return null;
	}
	
	@Override
	public List<WellData> getWellDataByWellNumAndDatetime(String wellNum,
			Date startTime, Date endTime) throws Exception {
		List<VarGroupData> sgtDataList = historyDataService.getVarGroupData(wellNum, VarGroupEnum.YOU_JING_SGT, startTime, endTime, 20);
		VarGroupData dianData = historyDataService.getVarGroupData(wellNum, VarGroupEnum.DIAN_YM, endTime);
		if(sgtDataList != null && !sgtDataList.isEmpty()) {
			List<WellData> wellDataList = new ArrayList<>();
			for(VarGroupData sgtData : sgtDataList) {
				WellData wellData = new WellData();
				wellData.setCode(wellNum);
				wellData.setChongCheng(Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.CHONG_CHENG.toString().toLowerCase())));
				wellData.setChongCi(Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.CHONG_CI.toString().toLowerCase())));
				wellData.setChongChengTime(60/wellData.getChongCi());
				wellData.setShangChongChengTime(60/Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.SHANG_XING_CHONG_CI.toString().toLowerCase())));
				wellData.setXiaChongChengTime(60/Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.XIA_XING_CHONG_CI.toString().toLowerCase())));
				wellData.setMinZaihe(Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.ZUI_XIAO_ZAI_HE.toString().toLowerCase())));
				wellData.setMaxZaihe(Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.ZUI_DA_ZAI_HE.toString().toLowerCase())));
				
				float[] weiyi = sgtData.getArrayValueMap().get(VarSubTypeEnum.WEI_YI_ARRAY.toString().toLowerCase());
				float[] zaihe = sgtData.getArrayValueMap().get(VarSubTypeEnum.ZAI_HE_ARRAY.toString().toLowerCase());
				wellData.setWeiyi(weiyi);
				wellData.setZaihe(zaihe);
				
				wellData.setFalutDiagnoseInfo("正常");//TODO
				wellData.setChanYeLiang(50.6f);//TODO
				wellData.setPingHengDu(0.8f);//TODO
				wellData.setBengXiao(0.8f);//TODO
				
				Double zengZongDianNeng = dianData.getYmValueMap().get(VarSubTypeEnum.DL_ZX_Z.toString().toLowerCase());
				wellData.setDianBiaoNum(zengZongDianNeng.floatValue());//正向有功总电能
				
				wellData.setRiHaoDian(42.1f);//TODO  从生产动态数据库里取
				wellData.setNenghaoShang(34.5f);//TODO
				wellData.setNenghaoXia(32.5f);//TODO
				
				wellDataList.add(wellData);
			}
			
			return wellDataList;
		}
		
		return null;
	}

	@Override
	public WellDGTData getLatestWellDGTDataByWellNum(String wellNum)
			throws Exception {
		WellDGTData wellDGTData = new WellDGTData();
		float[] weiyi = null;//realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.WEI_YI_ARRAY.toString().toLowerCase());
		float[] ib = null;//realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.DIAN_LIU_ARRAY.toString().toLowerCase());
		float[] power = null;//realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.GONG_LV_ARRAY.toString().toLowerCase());
		float[] power_factor = null;//realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.GONG_LV_YIN_SHU_ARRAY.toString().toLowerCase());
		float[] dgt = null;//realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.DIAN_GONG_TU_ARRAY.toString().toLowerCase());
		
		wellDGTData.setWeiyi(weiyi);
		wellDGTData.setIb(ib);
		wellDGTData.setPower(power);
		wellDGTData.setPower_factor(power_factor);
		wellDGTData.setDgt(dgt);
		
		return wellDGTData;
	}

	@Override
	public WellDGTData geWellDGTDataByWellNumAndDatetime(String wellNum,
			Date time) {
		VarGroupData sgtData = historyDataService.getVarGroupData(wellNum, VarGroupEnum.YOU_JING_SGT, time);
		VarGroupData dgtData = historyDataService.getVarGroupData(wellNum, VarGroupEnum.YOU_JING_DGT, time);
		WellDGTData wellDGTData = new WellDGTData();
		float[] weiyi = sgtData.getArrayValueMap().get(VarSubTypeEnum.WEI_YI_ARRAY.toString().toLowerCase());
		float[] ib = dgtData.getArrayValueMap().get(VarSubTypeEnum.DIAN_LIU_ARRAY.toString().toLowerCase());
		float[] power = dgtData.getArrayValueMap().get(VarSubTypeEnum.GONG_LV_ARRAY.toString().toLowerCase());
		float[] power_factor = dgtData.getArrayValueMap().get(VarSubTypeEnum.GONG_LV_YIN_SHU_ARRAY.toString().toLowerCase());
		float[] dgt = dgtData.getArrayValueMap().get(VarSubTypeEnum.DIAN_GONG_TU_ARRAY.toString().toLowerCase());
		
		wellDGTData.setWeiyi(weiyi);
		wellDGTData.setIb(ib);
		wellDGTData.setPower(power);
		wellDGTData.setPower_factor(power_factor);
		wellDGTData.setDgt(dgt);
		
		return wellDGTData;
	}
	
	@Override
	public List<ChouYouGanShouLi> getLatestCYGShouLi(String wellNum) {
		List<ChouYouGanShouLi> cygslList = new ArrayList<>();
		ChouYouGanShouLi cyg1 = new ChouYouGanShouLi();
		cyg1.setIndex("一级杆");
		cyg1.setMaxZaiHe("89.1");
		cyg1.setMinZaihe("12.1");
		
		ChouYouGanShouLi cyg2 = new ChouYouGanShouLi();
		cyg2.setIndex("二级杆");
		cyg2.setMaxZaiHe("83.1");
		cyg2.setMinZaihe("22.1");
		
		cygslList.add(cyg1);
		cygslList.add(cyg2);
		
		return cygslList;
	}
}
