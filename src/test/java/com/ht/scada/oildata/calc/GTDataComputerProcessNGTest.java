/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ht.scada.oildata.calc;

import java.util.Map;
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
public class GTDataComputerProcessNGTest {
    
    public GTDataComputerProcessNGTest() {
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
     * calcSGTData方法的测试 (属于类GTDataComputerProcess)。
     */
    @Test
    public void testCalcSGTData() {
        System.out.println("calcSGTData");
        float[] weiyi = {0.000f,0.016f,0.045f,0.083f,0.134f,0.201f,0.258f,0.321f,0.382f,0.449f,0.515f,0.585f,0.649f,0.716f,0.776f,0.837f,0.903f,0.977f,1.040f,1.107f,1.167f,1.234f,1.294f,1.377f,1.441f,1.511f,1.571f,1.632f,1.698f,1.768f,1.835f,1.899f,1.959f,2.019f,2.093f,2.156f,2.229f,2.290f,2.353f,2.417f,2.484f,2.557f,2.627f,2.687f,2.751f,2.814f,2.875f,2.945f,3.021f,3.085f,3.145f,3.205f,3.272f,3.342f,3.415f,3.485f,3.546f,3.606f,3.670f,3.743f,3.810f,3.876f,3.937f,4.000f,4.064f,4.131f,4.204f,4.267f,4.331f,4.395f,4.458f,4.525f,4.598f,4.662f,4.725f,4.789f,4.849f,4.922f,4.992f,5.059f,5.120f,5.183f,5.247f,5.317f,5.387f,5.453f,5.520f,5.581f,5.647f,5.708f,5.781f,5.845f,5.905f,5.953f,5.984f,6.013f,6.032f,6.042f,6.042f,6.042f,6.016f,5.994f,5.956f,5.915f,5.848f,5.784f,5.717f,5.657f,5.593f,5.533f,5.466f,5.409f,5.339f,5.269f,5.209f,5.145f,5.081f,5.021f,4.954f,4.887f,4.824f,4.757f,4.703f,4.633f,4.570f,4.500f,4.439f,4.379f,4.321f,4.252f,4.185f,4.115f,4.054f,3.997f,3.930f,3.870f,3.800f,3.736f,3.670f,3.606f,3.549f,3.488f,3.422f,3.352f,3.285f,3.225f,3.161f,3.097f,3.034f,2.967f,2.897f,2.837f,2.779f,2.713f,2.649f,2.585f,2.519f,2.452f,2.388f,2.334f,2.267f,2.194f,2.124f,2.064f,1.997f,1.943f,1.876f,1.819f,1.749f,1.682f,1.619f,1.562f,1.501f,1.434f,1.368f,1.301f,1.231f,1.164f,1.110f,1.043f,0.980f,0.910f,0.846f,0.789f,0.728f,0.665f,0.598f,0.531f,0.468f,0.407f,0.344f,0.287f,0.220f,0.156f,0.105f,0.061f,0.032f,0.010f,0.010f,0.004f};
        float[] zaihe = {26.48f,28.11f,30.23f,32.50f,33.51f,34.03f,33.52f,33.80f,33.39f,33.52f,33.52f,33.48f,33.49f,33.37f,33.42f,33.40f,33.47f,33.37f,33.35f,33.37f,33.48f,33.61f,33.56f,33.48f,33.42f,33.47f,33.45f,33.51f,33.42f,33.47f,33.41f,33.40f,33.42f,33.39f,33.42f,33.52f,33.51f,33.53f,33.55f,33.58f,33.73f,33.76f,33.83f,33.88f,33.83f,33.72f,33.61f,33.55f,33.65f,33.66f,33.68f,33.73f,33.67f,33.65f,33.62f,33.68f,33.69f,33.59f,33.58f,33.56f,33.62f,33.58f,33.60f,33.59f,33.56f,33.63f,33.70f,33.72f,33.73f,33.76f,33.93f,33.93f,33.85f,33.80f,33.86f,33.90f,33.87f,33.77f,33.80f,33.82f,33.79f,33.81f,33.79f,33.76f,33.70f,33.61f,33.68f,33.72f,33.74f,33.67f,33.67f,33.62f,33.62f,33.52f,33.48f,33.48f,33.35f,33.37f,32.71f,31.93f,30.57f,28.67f,26.70f,25.79f,25.41f,25.91f,25.46f,25.84f,25.64f,25.72f,25.84f,25.65f,25.83f,25.60f,25.77f,25.76f,25.79f,25.84f,25.78f,25.80f,25.76f,25.77f,25.79f,25.78f,25.75f,25.73f,25.67f,25.66f,25.70f,25.74f,25.86f,25.79f,25.73f,25.67f,25.63f,25.63f,25.59f,25.62f,25.69f,25.73f,25.76f,25.72f,25.67f,25.73f,25.81f,25.84f,25.83f,25.79f,25.83f,25.83f,25.80f,25.84f,25.88f,25.90f,25.85f,25.87f,25.87f,25.84f,25.66f,25.70f,25.69f,25.76f,25.70f,25.70f,25.73f,25.69f,25.57f,25.60f,25.62f,25.76f,25.79f,25.88f,25.88f,25.86f,25.80f,25.83f,25.80f,25.83f,25.81f,25.83f,25.86f,25.87f,25.87f,26.00f,26.01f,26.03f,25.86f,25.80f,25.87f,25.80f,25.80f,25.73f,25.87f,25.93f,25.96f,26.04f,26.11f,26.21f,26.20f,26.38f};
        float[] power = {2.3f,0.8f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,0.0f,2.4f,3.7f,5.0f,6.5f,8.2f,9.6f,9.8f,9.8f,9.4f,10.2f,9.4f,9.7f,9.5f,10.2f,10.0f,9.2f,9.8f,10.1f,10.4f,9.7f,9.4f,9.7f,9.6f,9.9f,9.5f,9.3f,9.9f,10.0f,9.7f,10.0f,9.6f,10.0f,9.6f,9.4f,10.0f,10.1f,10.0f,9.5f,9.3f,9.6f,9.8f,9.5f,9.1f,9.7f,9.2f,10.1f,9.9f,9.4f,9.0f,9.8f,9.9f,9.8f,9.3f,9.2f,10.1f,10.0f,9.1f,9.9f,9.7f,9.8f,9.5f,9.3f,9.6f,9.8f,9.1f,9.3f,9.8f,9.9f,9.2f,9.2f,9.6f,9.9f,9.5f,9.2f,8.7f,9.7f,9.7f,8.9f,9.4f,9.9f,9.7f,9.0f,8.7f,9.8f,10.0f,9.2f,9.4f,9.6f,9.8f,9.4f,9.0f,9.5f,9.8f,8.9f,8.5f,7.6f,6.7f,5.9f,4.2f,3.1f,3.7f};
        float chongCi = 1.17F;
        float bengJing = 56F;
        float oilDensity = 0.8F;
        float hanShuiLiang = 90F;
        GTDataComputerProcess instance = new GTDataComputerProcess();
        Map expResult = null;
        Map result = instance.calcSGTData(weiyi, zaihe, power, chongCi, bengJing, oilDensity, hanShuiLiang);
        assertEquals(result, expResult);
        // TODO 检查生成的测试代码并删除失败的默认调用。
        fail("\u6d4b\u8bd5\u7528\u4f8b\u4e3a\u539f\u578b\u3002");
    }
}