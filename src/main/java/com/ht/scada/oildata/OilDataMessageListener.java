package com.ht.scada.oildata;

import com.ht.scada.oildata.entity.FaultDiagnoseRecord;

/**
 * 实时数据监听器，实现故障报警、遥测越限、遥信变位消息的监听
 * @author: 薄成文 13-5-22 下午4:40
 */
public interface OilDataMessageListener {

    /**
     * 发生故障报警
     * @param record
     */
    void faultOccured(FaultDiagnoseRecord record);

}
