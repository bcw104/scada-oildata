package com.ht.scada.oildata.service;

import com.ht.scada.data.entity.FaultDiagnoseRecord;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bcw
 * Date: 13-4-26
 * Time: 下午2:19
 * To change this template use File | Settings | File Templates.
 */
public interface AlarmService {
    /**
     * 返回当前的故障诊断记录
     * @param code
     * @return
     */
    public List<FaultDiagnoseRecord> getCurrentFaultDiagnoseRecord(String code);
}
