package com.ht.scada.oildata.calc;
/**
 * DFT滤波
 * @author 赵磊
 *
 */
public class DFT {

	public  static void calc(float[] zaihe) {
		int npt = 200;
		float[] XR = new float[npt];
		float[] XI = new float[npt];
		float[] YR = new float[npt];
		float[] YI = new float[npt];
		float WN = (float) (-2 * 3.1415926 / npt);
		int N = 15;
		
		for (int k = 0; k < npt; k++) {
			XR[k] = 0;
			XI[k] = 0;
			float wk = k * WN;
			
			for (int n = 0; n < npt; n++) {
				float c = (float) Math.cos(n * wk);
				float s = (float) Math.sin(n * wk);
				XR[k] = XR[k] + zaihe[n] * c;
				XI[k] = XI[k] + zaihe[n] * s;
			}
		}
		for(int i = N;i<npt-N;i++) {
			XR[i] = 0;
			XI[i] = 0;
		}		
		for (int k = 0; k < npt; k++) {
			YR[k] = 0;
			YI[k] = 0;
			float wk = - k * WN;

			for (int n = 0; n < npt; n++) {
				float c = (float) Math.cos(n * wk);
				float s = (float) Math.sin(n * wk);
				YR[k] = YR[k] + XR[n] * c + XI[n]*s;
				YI[k] = YI[k] + XR[n] * s + XI[n]*c;
			}
		}

		for(int i = 0;i<npt;i++) {
			zaihe[i] = (float) Math.pow(Math.pow(YR[i],2) + Math.pow(YI[i], 2),0.5);
			zaihe[i]/=npt;
			//System.out.println(zaihe[i]);
		}
	}
}
