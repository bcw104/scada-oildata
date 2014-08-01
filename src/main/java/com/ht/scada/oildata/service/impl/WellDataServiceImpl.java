package com.ht.scada.oildata.service.impl;

import com.ht.scada.common.tag.service.EndTagExtInfoService;
import com.ht.scada.common.tag.util.*;
import com.ht.scada.data.kv.VarGroupData;
import com.ht.scada.data.service.HistoryDataService;
import com.ht.scada.data.service.RealtimeDataService;
import com.ht.scada.oildata.calc.GTDataComputerProcess;
import com.ht.scada.oildata.calc.GTReturnKeyEnum;
import com.ht.scada.oildata.entity.ChouYouGanShouLi;
import com.ht.scada.oildata.entity.WellDGTData;
import com.ht.scada.oildata.entity.WellData;
import com.ht.scada.oildata.service.WellService;
import com.ht.scada.oildata.util.String2FloatArrayUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 赵磊
 * @author 陈志强
 *
 */
@Transactional
@Service("wellService")
public class WellDataServiceImpl implements WellService {

    @Inject
    private RealtimeDataService realtimeDataService;
    @Inject
    private HistoryDataService historyDataService;
    @Inject
    private EndTagExtInfoService endTagExtInfoService;

    @Override
    public WellData getLatestWellDataByWellNum(String wellNum) {
        Map<String, String> map = realtimeDataService.getEndTagVarGroupInfo(wellNum, VarGroupEnum.YOU_JING_SGT.toString());
        if (map != null) {
            WellData wellData = new WellData();

            float[] weiyi = String2FloatArrayUtil.string2FloatArrayUtil(realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.WEI_YI_ARRAY.toString().toLowerCase()), ",");
            float[] zaihe = String2FloatArrayUtil.string2FloatArrayUtil(realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.ZAI_HE_ARRAY.toString().toLowerCase()), ",");
            wellData.setWeiyi(weiyi);
            wellData.setZaihe(zaihe);

            //1)	井号
            wellData.setCode(wellNum);
            //2)	运行模式：变速  根据上下行冲次是否相等判断
            String shangxingchongci = realtimeDataService.getEndTagVarInfo(wellNum, VarSubTypeEnum.SHANG_XING_CHONG_CI.toString().toLowerCase());
            String xiaxingchongci = realtimeDataService.getEndTagVarInfo(wellNum, VarSubTypeEnum.XIA_XING_CHONG_CI.toString().toLowerCase());
            if (xiaxingchongci != null && shangxingchongci != null) {
                if (shangxingchongci.equals(xiaxingchongci)) {
                    wellData.setRunModel("匀速");
                }else {
                    wellData.setRunModel("变速");
                }
            } else if (xiaxingchongci != null || shangxingchongci != null) {
                wellData.setRunModel("变速");
            } else {
                wellData.setRunModel("匀速");
            }

            //3)	油井冲次值
            String chongCiStr = map.get(VarSubTypeEnum.CHONG_CI.toString().toLowerCase());
            wellData.setChongCi(CommonUtils.string2Float(chongCiStr,2));
            //4)	上冲程频率【变速】 5)	下冲程频率【变速】  合为一个频率
            String exportFrequency = realtimeDataService.getEndTagVarInfo(wellNum, VarSubTypeEnum.BIAN_PIN_QI_SHU_CHU_PIN_LV.toString().toLowerCase());
                wellData.setExportFrequency(CommonUtils.string2Float(exportFrequency,2));
            //6)	上行冲次值【变速】
            wellData.setShangChongChengTime(CommonUtils.string2Float(shangxingchongci,2));

            //7)	下行冲次值【变速】
            wellData.setXiaChongChengTime(CommonUtils.string2Float(xiaxingchongci,2));
            //8)	油井冲程值
            String chongChengStr = map.get(VarSubTypeEnum.CHONG_CHENG.toString().toLowerCase());
            wellData.setChongCheng(CommonUtils.string2Float(chongChengStr,2));
            //9)	示功图最大载荷值
            String maxZaiheStr = map.get(VarSubTypeEnum.ZUI_DA_ZAI_HE.toString().toLowerCase());
            wellData.setMaxZaihe(CommonUtils.string2Float(maxZaiheStr,2));
            //10)	示功图最小载荷值
            String minZaiheStr = map.get(VarSubTypeEnum.ZUI_XIAO_ZAI_HE.toString().toLowerCase());
            wellData.setMinZaihe(CommonUtils.string2Float(minZaiheStr,2));
            //11)	上载线【隐藏】
            //12)	下载线【隐藏】
            //13)	上冲程能耗值  有
            wellData.setNenghaoShang(0); // TODO 暂时先写0
            //14)	下冲程能耗值   有
            wellData.setNenghaoXia(0);
            //15)	功图诊断（异常【突出】）
            String falutDiagnoseInfo = realtimeDataService.getEndTagVarInfo(wellNum, RedisKeysEnum.FALUT_DIAGNOSE_INFO.toString());
            wellData.setFalutDiagnoseInfo(falutDiagnoseInfo);
            // 16） 产液量
            String oliProductStr = realtimeDataService.getEndTagVarInfo(wellNum, RedisKeysEnum.RI_YUGU_CYL.toString());
            wellData.setChanYeLiang(CommonUtils.string2Float(oliProductStr,2));
            // 17） 功图时间
            String dateTime = realtimeDataService.getEndTagVarInfo(wellNum, RedisKeysEnum.GT_DATETIME.toString());
            if (dateTime!=null){
                wellData.setTime(CommonUtils.string2Date(dateTime));
            }else {
                wellData.setTime(new Date());
            }

            //if (wellData.getChongCi() < 0) {
            //    System.out.print("冲次为0");
            //    return null;
            //}

            //wellData.setChongChengTime(60 / wellData.getChongCi());
//            wellData.setShangChongChengTime(60 / Float.valueOf(map.get(VarSubTypeEnum.SHANG_XING_CHONG_CI.toString().toLowerCase())));
//            wellData.setXiaChongChengTime(60 / Float.valueOf(map.get(VarSubTypeEnum.XIA_XING_CHONG_CI.toString().toLowerCase())));
//            wellData.setShangChongChengTime(wellData.getChongChengTime()/2);
//            wellData.setXiaChongChengTime(wellData.getChongChengTime()/2);

            //float[] power = String2FloatArrayUtil.string2FloatArrayUtil(realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.GONG_LV_ARRAY.toString().toLowerCase()), ",");
            //GTDataComputerProcess gtData = new GTDataComputerProcess();
            //String bengJingStr = endTagExtInfoService.getByCodeAndKeyName(wellNum, EndTagExtNameEnum.BENG_JING.toString()).getValue();
            //String miDuStr = endTagExtInfoService.getByCodeAndKeyName(wellNum, EndTagExtNameEnum.MI_DU.toString()).getValue();
            //String hanShuiLvStr = endTagExtInfoService.getByCodeAndKeyName(wellNum, EndTagExtNameEnum.HAN_SHUI_LV.toString()).getValue();
            //float bengJing, oilDensity,hanShuiLiang;
            //if (bengJingStr != null) {
            //    bengJing = Float.valueOf(endTagExtInfoService.getByCodeAndKeyName(wellNum, EndTagExtNameEnum.BENG_JING.toString()).getValue());
            //}else {
            //    bengJing = 0f;
            //}
            //if (miDuStr != null) {
            //    oilDensity = Float.valueOf(endTagExtInfoService.getByCodeAndKeyName(wellNum, EndTagExtNameEnum.MI_DU.toString()).getValue());
            //}else {
            //    oilDensity = 0f;
            //}
            //if (hanShuiLvStr != null) {
            //    hanShuiLiang = Float.valueOf(endTagExtInfoService.getByCodeAndKeyName(wellNum, EndTagExtNameEnum.HAN_SHUI_LV.toString()).getValue());
            //}else {
            //    hanShuiLiang = 0f;
            //}
            //
            ////Map<GTReturnKeyEnum, Object> calcMap = gtData.calcSGTData(weiyi, zaihe, power, wellData.getChongCi(), bengJing, oilDensity, hanShuiLiang);
            //if (bengJing == 0){
            //    bengJing = 70f;
            //}
            //if (oilDensity == 0){
            //    oilDensity = 1f;
            //}
            //if (hanShuiLiang == 0){
            //    hanShuiLiang = 0.9f;
            //}
            //Map<GTReturnKeyEnum, Object> calcMap;
            //if (weiyi != null && zaihe != null && weiyi.length > 0 && zaihe.length > 0) {
            //    boolean flag = false;
            //    for (int i = 0; i < weiyi.length; i++) {
            //        if (weiyi[i] != 0) {
            //            flag = true;
            //        }
            //    }
            //    if (flag) {
            //        calcMap = gtData.calcSGTData(weiyi, zaihe, null, wellData.getChongCi(), bengJing, oilDensity, hanShuiLiang);
            //        wellData.setChanYeLiang((Float) calcMap.get(GTReturnKeyEnum.LIQUID_PRODUCT) * 24);
            //    }
            //}
            //System.out.println("功图计算完毕！");
            //wellData.setFalutDiagnoseInfo((String) calcMap.get(GTReturnKeyEnum.FAULT_DIAGNOSE_INFO));
            //wellData.setPingHengDu((Float) calcMap.get(GTReturnKeyEnum.PING_HENG_DU));
            //wellData.setBengXiao((Float) calcMap.get(GTReturnKeyEnum.BENG_XIAO));
            //
            //String zengZongDianNeng = realtimeDataService.getEndTagVarInfo(wellNum, VarSubTypeEnum.DL_ZX_Z.toString().toLowerCase());
            //wellData.setDianBiaoNum(Float.valueOf(zengZongDianNeng));//正向有功总电能
            //System.out.println("电表读数：" + wellData.getDianBiaoNum());
            //
            //wellData.setNenghaoShang((Float) calcMap.get(GTReturnKeyEnum.NENG_HAO_SHANG));
            //wellData.setNenghaoXia((Float) calcMap.get(GTReturnKeyEnum.NENG_HAO_XIA));
            //wellData.setRiHaoDian((Float) calcMap.get(GTReturnKeyEnum.NENG_HAO_RI));
            //wellData.setTime(new Date());

            return wellData;
        }
        return null;
    }

    @Override
    public WellData getWellDataByWellNumAndDatetime(String wellNum, Date time) {
        VarGroupData sgtData = historyDataService.getVarGroupData(wellNum, VarGroupEnum.YOU_JING_SGT, time);
        VarGroupData dianData = historyDataService.getVarGroupData(wellNum, VarGroupEnum.DIAN_YM, time);
        VarGroupData dgtData = historyDataService.getVarGroupData(wellNum, VarGroupEnum.YOU_JING_DGT, time);
        if (sgtData != null && dianData != null) {
            WellData wellData = new WellData();
            wellData.setCode(wellNum);
            wellData.setChongCheng(Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.CHONG_CHENG.toString().toLowerCase())));

            if (wellData.getChongCi() <= 0) {
                System.out.print("冲次为0");
                return null;
            }
            wellData.setChongCi(Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.CHONG_CI.toString().toLowerCase())));
            wellData.setChongChengTime(60 / wellData.getChongCi());
//            wellData.setShangChongChengTime(60 / Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.SHANG_XING_CHONG_CI.toString().toLowerCase())));
//            wellData.setXiaChongChengTime(60 / Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.XIA_XING_CHONG_CI.toString().toLowerCase())));
            wellData.setShangChongChengTime(wellData.getChongChengTime()/2);
            wellData.setXiaChongChengTime(wellData.getChongChengTime()/2);
            wellData.setMinZaihe(Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.ZUI_XIAO_ZAI_HE.toString().toLowerCase())));
            wellData.setMaxZaihe(Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.ZUI_DA_ZAI_HE.toString().toLowerCase())));

            float[] weiyi = sgtData.getArrayValueMap().get(VarSubTypeEnum.WEI_YI_ARRAY.toString().toLowerCase());
            float[] zaihe = sgtData.getArrayValueMap().get(VarSubTypeEnum.ZAI_HE_ARRAY.toString().toLowerCase());
            wellData.setWeiyi(weiyi);
            wellData.setZaihe(zaihe);

            float[] power = dgtData.getArrayValueMap().get(VarSubTypeEnum.GONG_LV_ARRAY.toString().toLowerCase());
            GTDataComputerProcess gtData = new GTDataComputerProcess();
            float bengJing = Float.valueOf(endTagExtInfoService.getByCodeAndKeyName(wellNum, EndTagExtNameEnum.BENG_JING.toString()).getValue());
            float oilDensity = Float.valueOf(endTagExtInfoService.getByCodeAndKeyName(wellNum, EndTagExtNameEnum.MI_DU.toString()).getValue());
            float hanShuiLiang = Float.valueOf(endTagExtInfoService.getByCodeAndKeyName(wellNum, EndTagExtNameEnum.HAN_SHUI_LV.toString()).getValue());

            Map<GTReturnKeyEnum, Object> calcMap = gtData.calcSGTData(weiyi, zaihe, power, wellData.getChongCi(), bengJing, oilDensity, hanShuiLiang);

            wellData.setFalutDiagnoseInfo((String) calcMap.get(GTReturnKeyEnum.FAULT_DIAGNOSE_INFO));
            wellData.setChanYeLiang((Float) calcMap.get(GTReturnKeyEnum.LIQUID_PRODUCT));
            wellData.setPingHengDu((Float) calcMap.get(GTReturnKeyEnum.PING_HENG_DU));
            wellData.setBengXiao((Float) calcMap.get(GTReturnKeyEnum.BENG_XIAO));


            Double zengZongDianNeng = dianData.getYmValueMap().get(VarSubTypeEnum.DL_ZX_Z.toString().toLowerCase());

            wellData.setNenghaoShang((Float) calcMap.get(GTReturnKeyEnum.NENG_HAO_SHANG));
            wellData.setNenghaoXia((Float) calcMap.get(GTReturnKeyEnum.NENG_HAO_XIA));
            wellData.setRiHaoDian((Float) calcMap.get(GTReturnKeyEnum.NENG_HAO_RI));
            wellData.setTime(time);

            return wellData;
        }

        return null;
    }

    @Override
    public List<WellData> getWellDataByWellNumAndDatetime(String wellNum,
            Date startTime, Date endTime) {
        List<VarGroupData> sgtDataList = historyDataService.getVarGroupData(wellNum, VarGroupEnum.YOU_JING_SGT, startTime, endTime, 20);
        VarGroupData dianData = historyDataService.getVarGroupData(wellNum, VarGroupEnum.DIAN_YM, endTime);
        List<VarGroupData> dgtDataList = historyDataService.getVarGroupData(wellNum, VarGroupEnum.YOU_JING_DGT, startTime, endTime, 20);
        if (sgtDataList != null && !sgtDataList.isEmpty()) {
            List<WellData> wellDataList = new ArrayList<>();
            int n = sgtDataList.size();

            for (int i = 0; i < n; i++) {
                VarGroupData sgtData = sgtDataList.get(i);
                VarGroupData dgtData = dgtDataList.get(i);

                WellData wellData = new WellData();
                wellData.setCode(wellNum);
                wellData.setChongCheng(Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.CHONG_CHENG.toString().toLowerCase())));
                wellData.setChongCi(Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.CHONG_CI.toString().toLowerCase())));
                if (wellData.getChongCi() <= 0) {
                    System.out.print("冲次为0");
                    continue;
                }

                wellData.setChongChengTime(60 / wellData.getChongCi());
                wellData.setShangChongChengTime(60 / Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.SHANG_XING_CHONG_CI.toString().toLowerCase())));
                wellData.setXiaChongChengTime(60 / Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.XIA_XING_CHONG_CI.toString().toLowerCase())));
                wellData.setMinZaihe(Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.ZUI_XIAO_ZAI_HE.toString().toLowerCase())));
                wellData.setMaxZaihe(Float.valueOf(sgtData.getYcValueMap().get(VarSubTypeEnum.ZUI_DA_ZAI_HE.toString().toLowerCase())));

                float[] weiyi = sgtData.getArrayValueMap().get(VarSubTypeEnum.WEI_YI_ARRAY.toString().toLowerCase());
                float[] zaihe = sgtData.getArrayValueMap().get(VarSubTypeEnum.ZAI_HE_ARRAY.toString().toLowerCase());
                wellData.setWeiyi(weiyi);
                wellData.setZaihe(zaihe);

                float[] power = dgtData.getArrayValueMap().get(VarSubTypeEnum.GONG_LV_ARRAY.toString().toLowerCase());
                GTDataComputerProcess gtData = new GTDataComputerProcess();
                float bengJing = Float.valueOf(endTagExtInfoService.getByCodeAndKeyName(wellNum, EndTagExtNameEnum.BENG_JING.toString()).getValue());
                float oilDensity = Float.valueOf(endTagExtInfoService.getByCodeAndKeyName(wellNum, EndTagExtNameEnum.MI_DU.toString()).getValue());
                float hanShuiLiang = Float.valueOf(endTagExtInfoService.getByCodeAndKeyName(wellNum, EndTagExtNameEnum.HAN_SHUI_LV.toString()).getValue());

                Map<GTReturnKeyEnum, Object> calcMap = gtData.calcSGTData(weiyi, zaihe, power, wellData.getChongCi(), bengJing, oilDensity, hanShuiLiang);

                wellData.setFalutDiagnoseInfo((String) calcMap.get(GTReturnKeyEnum.FAULT_DIAGNOSE_INFO));
                wellData.setChanYeLiang((Float) calcMap.get(GTReturnKeyEnum.LIQUID_PRODUCT));
                wellData.setPingHengDu((Float) calcMap.get(GTReturnKeyEnum.PING_HENG_DU));
                wellData.setBengXiao((Float) calcMap.get(GTReturnKeyEnum.BENG_XIAO));


                Double zengZongDianNeng = dianData.getYmValueMap().get(VarSubTypeEnum.DL_ZX_Z.toString().toLowerCase());

                wellData.setNenghaoShang((Float) calcMap.get(GTReturnKeyEnum.NENG_HAO_SHANG));
                wellData.setNenghaoXia((Float) calcMap.get(GTReturnKeyEnum.NENG_HAO_XIA));
                wellData.setRiHaoDian((Float) calcMap.get(GTReturnKeyEnum.NENG_HAO_RI));
                
                wellData.setTime(sgtData.getDatetime());

                wellDataList.add(wellData);
            }

            return wellDataList;
        }

        return null;
    }

    @Override
    public WellDGTData getLatestWellDGTDataByWellNum(String wellNum) {
        WellDGTData wellDGTData = new WellDGTData();
        float[] weiyi = String2FloatArrayUtil.string2FloatArrayUtil(realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.WEI_YI_ARRAY.toString().toLowerCase()), ",");
        float[] ib = String2FloatArrayUtil.string2FloatArrayUtil(realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.DIAN_LIU_ARRAY.toString().toLowerCase()), ",");
        float[] power = String2FloatArrayUtil.string2FloatArrayUtil(realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.GONG_LV_ARRAY.toString().toLowerCase()), ",");
        float[] power_factor = String2FloatArrayUtil.string2FloatArrayUtil(realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.GONG_LV_YIN_SHU_ARRAY.toString().toLowerCase()), ",");
        float[] dgt = String2FloatArrayUtil.string2FloatArrayUtil(realtimeDataService.getEndTagVarYcArray(wellNum, VarSubTypeEnum.DIAN_GONG_TU_ARRAY.toString().toLowerCase()), ",");

        if(ib != null && power != null && power_factor != null && dgt !=null) {
            ib[ib.length -1] = ib[0];
            power[power.length - 1] = power[0];
            power_factor[power.length - 1] = power_factor[0];
            dgt[power.length - 1] = dgt[0];
        }
        
        wellDGTData.setWeiyi(weiyi);
        wellDGTData.setIb(ib);
        wellDGTData.setPower(power);
        wellDGTData.setPower_factor(power_factor);
        wellDGTData.setDgt(dgt);
        wellDGTData.setTime(new Date());

        return wellDGTData;
//        return null;
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
        
        wellDGTData.setTime(time);

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
