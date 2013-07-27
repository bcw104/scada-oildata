/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.scada.oildata.calc;

/**
 * 功图返回参数key
 *
 * @author 赵磊
 */
public enum GTReturnKeyEnum {

    LIQUID_PRODUCT("产液量", "Float"), OIL_PRODUCT("产油量", "Float"), 
    CHONG_CHENG("冲程", "Float"), YOU_XIAO_CHONG_CHENG("有效冲程", "Float"),BENG_XIAO("泵效","Float"),
    MAX_ZAIHE("最大载荷", "FLoat"), MIN_ZAIHE("最小载荷", "Float"),AVG_ZAIHE_SHANG("平均上载荷", "Float"),AVG_ZAIHE_XIA("平均下载荷", "Float"),ZAIHE_CHA("载荷差", "Float"),
    AREA_YXCC("面积有效冲程","Float"), AREA_PRODUCT("面积产液量", "Float"),
    GT_AREA("功图面积","Float"),GT_AREA_LI_LUN("理论功图面积","Float"),
    FAULT_DIAGNOSE_INFO("故障诊断信息","String"), FAULT_DIAGNOSE_LEVEL("故障程度","Integer"),
    POINT_AX("左上位移", "Float"),POINT_BX("上死点位移", "Float"),POINT_CX("右下位移", "Float"),POINT_DX("下死点位移", "Float"),
    POINT_AY("左上载荷", "Float"),POINT_BY("上死点载荷", "Float"),POINT_CY("右下载荷", "Float"),POINT_DY("下死点载荷", "Float"),
    PING_HENG_DU("平衡度","Float"),
    
    ;
    
    
    private String value;
    private String classType;

    private GTReturnKeyEnum(String value, String classType) {
        this.value = value;
        this.classType = classType;
    }

    private GTReturnKeyEnum(String value) {
        this.value = value;
    }

    private GTReturnKeyEnum() {
        this(null, null);
    }

    public String getValue() {
        return value;
    }

    public static GTReturnKeyEnum getByValue(String value) {
        for (GTReturnKeyEnum type : GTReturnKeyEnum.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return null;
    }
}
