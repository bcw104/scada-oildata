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

    LIQUID_PRODUCT("产液量"), OIL_PRODUCT("产油量"), CHONG_CHENG("冲程"), MAX_ZAIHE("最大载荷"), MIN_ZAIHE("最小载荷"), YOU_XIAO_CHONG_CHENG("有效冲程");
    
    
    private String value;

    private GTReturnKeyEnum(String value) {
        this.value = value;
    }

    private GTReturnKeyEnum() {
        this(null);
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
