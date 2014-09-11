/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.scada.oildata.calc;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author zhao
 */
public class PhdCalcNGTest {
    
    public PhdCalcNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * dianLiuCalc方法的测试 (属于类PhdCalc)。
     */
    @Test
    public void testDianLiuCalc() {
        System.out.println("dianLiuCalc");
        float expResult = 0.0F;
//        float result = PhdCalc.dianLiuCalc();
//        assertEquals(result, expResult, 0.0);
        // TODO 检查生成的测试代码并删除失败的默认调用。
        fail("\u6d4b\u8bd5\u7528\u4f8b\u4e3a\u539f\u578b\u3002");
    }

    /**
     * gongLvCalc方法的测试 (属于类PhdCalc)。
     */
    @Test
    public void testGongLvCalc() {
        System.out.println("gongLvCalc");
        float[] power = null;
        int maxFlag = 0;
        int minFlag = 0;
        float expResult = 0.0F;
        float result[] = PhdCalc.gongLvCalc(power, maxFlag, minFlag);
        assertEquals(result[0], expResult, 0.0);
        // TODO 检查生成的测试代码并删除失败的默认调用。
        fail("\u6d4b\u8bd5\u7528\u4f8b\u4e3a\u539f\u578b\u3002");
    }
}