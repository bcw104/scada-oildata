package com.ht.scada.oildata.service.impl;

import com.ht.scada.oildata.entity.FaultDiagnoseRecord;
import com.ht.scada.oildata.service.AlarmService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 作者: "薄成文"
 * 日期: 13-5-16 下午1:28
 * To change this template use File | Settings | File Templates.
 */
@Service("alarmService")
public class AlarmServiceImpl implements AlarmService {
    @Override
    public List<FaultDiagnoseRecord> getCurrentFaultDiagnoseRecord(String code) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
