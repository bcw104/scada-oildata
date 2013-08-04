/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.scada.oildata.calc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zhao
 */
public class PhdCalcTest {
    
    public PhdCalcTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of dianLiuCalc method, of class PhdCalc.
     */
    //@Test
    public void testDianLiuCalc() {
        System.out.println("dianLiuCalc");
        float expResult = 0.0F;
        float result = PhdCalc.dianLiuCalc();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gongLvCalc method, of class PhdCalc.
     */
    @Test
    public void testGongLvCalc() {
        System.out.println("gongLvCalc");
        float[] power = null;
        int maxFlag = 0;
        int minFlag = 0;
        float expResult = 0.0F;
        float result = PhdCalc.gongLvCalc(power, maxFlag, minFlag);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}