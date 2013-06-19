package com.ht.scada.oildata;

import com.alibaba.fastjson.JSON;
import com.ht.scada.oildata.entity.FaultDiagnoseRecord;

import java.io.IOException;

/**
 * 实时数据推送代理, 用于触发故障报警、遥信变位、遥测越限，使用时请注册监听器
 *
 * @author: "薄成文" 13-5-21 下午1:51
 * To change this template use File | Settings | File Templates.
 */
public class OilDataMessageDelegate {

    private OilDataMessageListener listener;

    public void setListener(OilDataMessageListener listener) {
        this.listener = listener;
    }

    /**
     * 收到故障报警信息<br/>
     * 故障记录中的id为字符串类型，客户端收到报警信息时该记录的ID已自动生成，但不保证立即写入数据库。
     * @param message
     */
    public void handleMessage(String message) throws IOException {
        System.out.println("收到故障报警");
        System.out.println(message);
        if (listener != null) {
            FaultDiagnoseRecord record = JSON.parseObject(message, FaultDiagnoseRecord.class);
            System.out.println(record);
            if (record.getResumeTime() == null) {
                // 新故障记录
                listener.faultOccured(record);
            } else {
                // 故障解除
                listener.faultResumed(record);
            }
        }

    }

}
