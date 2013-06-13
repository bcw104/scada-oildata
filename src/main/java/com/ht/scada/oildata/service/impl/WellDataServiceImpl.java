package com.ht.scada.oildata.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.common.tag.type.entity.VarSubType;
import com.ht.scada.common.tag.util.VarGroupEnum;
import com.ht.scada.common.tag.util.VarSubTypeEnum;
import com.ht.scada.data.service.RealtimeDataService;
import com.ht.scada.oildata.entity.ChouYouGanShouLi;
import com.ht.scada.oildata.entity.WellDGTData;
import com.ht.scada.oildata.entity.WellData;
import com.ht.scada.oildata.service.WellService;

/**
 * @author 赵磊
 *
 */
@Transactional
@Service("wellDataService")
public class WellDataServiceImpl implements WellService {
	
	//@Inject
	private RealtimeDataService realtimeDataService;
	
	public void saveWellSGTData(String code, float[] zaihe, float[] weiyi,
			float chongcheng, float chongci) {
		// TODO Auto-generated method stub
		
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
	public WellData getLatestWellDataByWellNum(String wellNum) throws Exception {
		Map<String, String> map = realtimeDataService.getEndTagVarGroupInfo(wellNum, VarGroupEnum.YOU_JING_SGT.toString());
		if(map != null) {
			WellData wellData = new WellData();
			wellData.setCode(wellNum);
			wellData.setChongCheng(Float.valueOf(map.get(VarSubTypeEnum.CHONG_CHENG.toString())));
			wellData.setChongCi(Float.valueOf(map.get(VarSubTypeEnum.CHONG_CI.toString())));
			wellData.setChongChengTime(60/wellData.getChongCi());
			wellData.setShangChongChengTime(60/Float.valueOf(map.get(VarSubTypeEnum.SHANG_XING_CHONG_CI.toString())));
			wellData.setXiaChongChengTime(60/Float.valueOf(map.get(VarSubTypeEnum.XIA_XING_CHONG_CI.toString())));
			wellData.setMinZaihe(Float.valueOf(map.get(VarSubTypeEnum.ZUI_XIAO_ZAI_HE.toString())));
			wellData.setMaxZaihe(Float.valueOf(map.get(VarSubTypeEnum.ZUI_DA_ZAI_HE.toString())));
			
			String[] weiyiStr = map.get(VarSubTypeEnum.WEI_YI_ARRAY.toString()).split(",");
			String[] zaiheStr = map.get(VarSubTypeEnum.ZAI_HE_ARRAY.toString()).split(",");
			float[] weiyi = new float[weiyiStr.length];
			for(int i = 0;i<weiyiStr.length;i++) {
				weiyi[i] = Float.valueOf(weiyiStr[i]);
			}
			float[] zaihe = new float[zaiheStr.length];
			for(int i = 0;i<zaiheStr.length;i++) {
				zaihe[i] = Float.valueOf(zaiheStr[i]);
			}
			wellData.setWeiyi(weiyi);
			wellData.setZaihe(zaihe);
			
			wellData.setFalutDiagnoseInfo("正常");//TODO
			wellData.setChanYeLiang(50.6f);//TODO
			wellData.setPingHengDu(0.8f);//TODO
			wellData.setBengXiao(0.8f);//TODO
			
			String zengZongDianNeng = realtimeDataService.getEndTagVarInfo(wellNum, VarSubTypeEnum.DL_ZX_Z.toString());
			wellData.setDianBiaoNum(Float.valueOf(zengZongDianNeng));//正向有功总电能
			wellData.setRiHaoDian(42.1f);//TODO  从生产动态数据库里取
			
			wellData.setNenghaoShang(34.5f);//TODO
			wellData.setNenghaoXia(32.5f);//TODO
			
			return wellData;
		}
		return null;
	}
	
	@Override
	public WellData getWellDataByWellNumAndDatetime(String wellNum, Date time) {
		
		return null;
	}
	
	@Override
	public List<WellData> getWellDataByWellNumAndDatetime(String wellNum,
			Date startTime, Date endTime) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WellDGTData getLatestWellDGTDataByWellNum(String wellNum)
			throws Exception {
		WellDGTData wellDGTData = new WellDGTData();
		float[] weiyi = realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.WEI_YI_ARRAY.toString());
		float[] ib = realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.DIAN_LIU_ARRAY.toString());
		float[] power = realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.GONG_LV_ARRAY.toString());
		float[] power_factor = realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.GONG_LV_YIN_SHU_ARRAY.toString());
		float[] dgt = realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.DIAN_GONG_TU_ARRAY.toString());
		
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
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<ChouYouGanShouLi> getLatestCYGShouLi(String wellNum) {
		// TODO Auto-generated method stub
		return null;
	}
}
