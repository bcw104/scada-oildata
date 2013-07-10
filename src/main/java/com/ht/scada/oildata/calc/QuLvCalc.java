package com.ht.scada.oildata.calc;

/**
 * 计算曲率
 *
 * @author 赵磊
 *
 */
public class QuLvCalc {

    private float ki[];
    private float ski[];
    private int flagnum;

    /**
     * 求曲率
     *
     * @param pointArray
     * @return
     */
    public float[] getQuLv(Point pointArray[]) {
        if (pointArray == null || pointArray.length == 0) {
            return null;
        }
        // 计算曲率
        flagnum = pointArray.length;
        ki = new float[flagnum];


        float li1_0 = (float) Math.sqrt(Math.pow(pointArray[0].getY()
                - pointArray[flagnum - 1].getY(), 2)
                + Math.pow(
                pointArray[0].getX() - pointArray[flagnum - 1].getX(),
                2));
        float li_0 = (float) Math.sqrt(Math.pow(pointArray[1].getY()
                - pointArray[0].getY(), 2)
                + Math.pow(pointArray[1].getX() - pointArray[0].getX(), 2));
        float l1i_0 = (float) Math.sqrt(Math.pow(pointArray[flagnum - 1].getY()
                - pointArray[1].getY(), 2)
                + Math.pow(
                pointArray[flagnum - 1].getX() - pointArray[1].getX(),
                2));
        float p_0 = (li1_0 + li_0 + l1i_0) / 2;
        float s_0 = (float) Math.sqrt(p_0 * (p_0 - li1_0) * (p_0 - li_0)
                * (p_0 - l1i_0));
        ki[0] = 4 * s_0 / (li1_0 * li_0 * l1i_0);

        float li1_n1 = (float) Math
                .sqrt(Math.pow(pointArray[flagnum - 1].getY()
                - pointArray[flagnum - 2].getY(), 2)
                + Math.pow(pointArray[flagnum - 1].getX()
                - pointArray[flagnum - 2].getX(), 2));
        float li_n1 = (float) Math.sqrt(Math.pow(pointArray[0].getY()
                - pointArray[flagnum - 1].getY(), 2)
                + Math.pow(
                pointArray[0].getX() - pointArray[flagnum - 1].getX(),
                2));
        float l1i_n1 = (float) Math.sqrt(Math.pow(
                pointArray[flagnum - 2].getY() - pointArray[0].getY(), 2)
                + Math.pow(
                pointArray[flagnum - 2].getX() - pointArray[0].getX(),
                2));
        float p_n1 = (li1_n1 + l1i_n1 + li_n1) / 2;
        float s_n1 = (float) Math.sqrt(p_n1 * (p_n1 - li1_n1) * (p_n1 - li_n1)
                * (p_n1 - l1i_n1));
        ki[flagnum - 1] = 4 * s_n1 / (li1_n1 * li_n1 * l1i_n1);

        for (int i = 1; i < flagnum - 1; i++) {
            float li1 = (float) Math.sqrt(Math.pow(pointArray[i].getY()
                    - pointArray[i - 1].getY(), 2)
                    + Math.pow(pointArray[i].getX() - pointArray[i - 1].getX(),
                    2));
            float li = (float) Math.sqrt(Math.pow(pointArray[i + 1].getY()
                    - pointArray[i].getY(), 2)
                    + Math.pow(pointArray[i + 1].getX() - pointArray[i].getX(),
                    2));
            float l1i = (float) Math
                    .sqrt(Math.pow(
                    pointArray[i - 1].getY() - pointArray[i + 1].getY(),
                    2)
                    + Math.pow(pointArray[i - 1].getX()
                    - pointArray[i + 1].getX(), 2));
            float p = (li1 + li + l1i) / 2;
            float s = (float) Math.sqrt(p * (p - li1) * (p - li) * (p - l1i));
            ki[i] = 4 * s / (li1 * li * l1i);
        }
        return ki;
    }

    /**
     * 求曲率变化量
     *
     * @param pointArray
     * @return
     */
    public float[] getQuLvBHL(Point pointArray[]) {
        if (pointArray == null || pointArray.length == 0) {
            return null;
        }
        if (ki == null) {
            getQuLv(pointArray);
        }
        ski = new float[flagnum];
        for (int i = 0; i < flagnum - 1; i++) {
            ski[i] = Math.abs(ki[i + 1] - ki[i]);
        }
        ski[flagnum - 1] = Math.abs(ki[0] - ki[flagnum - 1]);
        return ski;
    }

    /**
     * 求5点平均曲率变化量
     *
     * @param pointArray
     * @return
     */
    public float[] getQuLvPJBHL(Point pointArray[]) {
        if (pointArray == null || pointArray.length == 0) {
            return null;
        }
        if (ski == null) {
            getQuLvBHL(pointArray);
        }
        float[] ski5 = new float[flagnum];
        ski5[0] = (ski[2] + ski[1] + ski[0] + ski[flagnum - 1] + ski[flagnum - 2]) / 5;
        ski5[1] = (ski[3] + ski[2] + ski[1] + ski[0] + ski[flagnum - 1]) / 5;
        ski5[flagnum - 1] = (ski[1] + ski[0] + ski[flagnum - 1]
                + ski[flagnum - 2] + ski[flagnum - 3]) / 5;
        ski5[flagnum - 2] = (ski[0] + ski[flagnum - 1] + ski[flagnum - 2]
                + ski[flagnum - 3] + ski[flagnum - 4]) / 5;
        for (int i = 3; i < flagnum - 2; i++) {
            ski5[i] = (ski[i + 2] + ski[i + 1] + ski[i] + ski[i - 1] + ski[i - 2]) / 5;
        }
        return ski5;
    }

    public float[] getCommonQulv(float weiyi[], float zaihe[]) {
        // 计算曲率
        int flagnum = weiyi.length;
        float ki[] = new float[flagnum];

        float li1_0 = (float) Math.sqrt(Math.pow(zaihe[0]
                - zaihe[flagnum - 1], 2)
                + Math.pow(
                weiyi[0] - weiyi[flagnum - 1],
                2));
        float li_0 = (float) Math.sqrt(Math.pow(zaihe[1]
                - zaihe[0], 2)
                + Math.pow(weiyi[1] - weiyi[0], 2));
        float l1i_0 = (float) Math.sqrt(Math.pow(zaihe[flagnum - 1]
                - zaihe[1], 2)
                + Math.pow(
                weiyi[flagnum - 1] - weiyi[1],
                2));
        float p_0 = (li1_0 + li_0 + l1i_0) / 2;
        float s_0 = (float) Math.sqrt(p_0 * (p_0 - li1_0) * (p_0 - li_0)
                * (p_0 - l1i_0));
        ki[0] = 4 * s_0 / (li1_0 * li_0 * l1i_0);

        float li1_n1 = (float) Math
                .sqrt(Math.pow(zaihe[flagnum - 1]
                - zaihe[flagnum - 2], 2)
                + Math.pow(weiyi[flagnum - 1]
                - weiyi[flagnum - 2], 2));
        float li_n1 = (float) Math.sqrt(Math.pow(zaihe[0]
                - zaihe[flagnum - 1], 2)
                + Math.pow(
                weiyi[0] - weiyi[flagnum - 1],
                2));
        float l1i_n1 = (float) Math.sqrt(Math.pow(
                zaihe[flagnum - 2] - zaihe[0], 2)
                + Math.pow(
                weiyi[flagnum - 2] - weiyi[0],
                2));
        float p_n1 = (li1_n1 + l1i_n1 + li_n1) / 2;
        float s_n1 = (float) Math.sqrt(p_n1 * (p_n1 - li1_n1) * (p_n1 - li_n1)
                * (p_n1 - l1i_n1));
        ki[flagnum - 1] = 4 * s_n1 / (li1_n1 * li_n1 * l1i_n1);

        for (int i = 1; i < flagnum - 1; i++) {
            float li1 = (float) Math.sqrt(Math.pow(zaihe[i]
                    - zaihe[i - 1], 2)
                    + Math.pow(weiyi[i] - weiyi[i - 1],
                    2));
            float li = (float) Math.sqrt(Math.pow(zaihe[i + 1]
                    - zaihe[i], 2)
                    + Math.pow(weiyi[i + 1] - weiyi[i],
                    2));
            float l1i = (float) Math
                    .sqrt(Math.pow(
                    zaihe[i - 1] - zaihe[i + 1],
                    2)
                    + Math.pow(weiyi[i - 1]
                    - weiyi[i + 1], 2));
            float p = (li1 + li + l1i) / 2;
            float s = (float) Math.sqrt(p * (p - li1) * (p - li) * (p - l1i));
            ki[i] = 4 * s / (li1 * li * l1i);
        }
        return ki;
    }
}
