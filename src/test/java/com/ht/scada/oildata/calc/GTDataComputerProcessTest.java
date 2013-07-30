/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.scada.oildata.calc;

import java.util.Map;
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
public class GTDataComputerProcessTest {
    
    public GTDataComputerProcessTest() {
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
     * Test of calcSGTData method, of class GTDataComputerProcess.
     */
    @Test
    public void testCalcSGTData() {
        System.out.println("calcSGTData");
        float[] weiyi = null;
        float[] zaihe = null;
        float chongCi = 0.0F;
        float bengJing = 0.0F;
        float oilDensity = 0.0F;
        float hanShuiLiang = 0.0F;
        GTDataComputerProcess instance = new GTDataComputerProcess();
        Map expResult = null;
//        Map result = instance.calcSGTData(weiyi, zaihe, chongCi, bengJing, oilDensity, hanShuiLiang);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}