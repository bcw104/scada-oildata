package com.ht.scada.oildata.calc;

import java.util.List;

/**
 * Melkman求凸包算法
 * 
 * @author 赵磊
 * 
 */
public class Melkman {
	private Point[] pointArray;//坐标数组
	private final int N;	//数据个数
	private int D[]; // 数组索引

	public Melkman(List<Point> pList) {
		this.pointArray = new Point[pList.size()];
		N = pList.size();
		int k = 0;
		for (Point p : pList) {
			pointArray[k++] = p;
		}
		D = new int[N];
	}

	/**
	 * 求凸包点
	 * 
	 * @return 所求凸包点
	 */
	public Point[] getTubaoPoint() {
		// 获得最小的Y，作为P0点
		float minY = pointArray[0].getY();
		int j = 0;
		for (int i = 1; i < N; i++) {
			if (pointArray[i].getY() < minY) {
				minY = pointArray[i].getY();
				j = i;
			}
		}
		swap(0, j);

		// 计算除第一顶点外的其余顶点到第一点的线段与x轴的夹角
		for (int i = 1; i < N; i++) {
			pointArray[i].setArCos(angle(i));
		}

		selectSort(1, N-1);//从小到大排序
		
		D[0] = 0;	//D[0]
		D[1] = 1;	//D[1]
		int top = 2;
		for (int i = 3; i < N; i++) {
			//非左转 则退栈
			while (isLeft(pointArray[D[top - 2]], pointArray[D[top - 1]],
					pointArray[i]) <= 0 && top>1) {
				top--;
			}
			D[top++] = i;
		}

		// 凸包构造完成，D数组里0至top-1内就是凸包的序列
		Point[] resultPoints = new Point[top];
		int index = 0;
		for (int i = 0; i < top; i++) {
			resultPoints[index++] = pointArray[D[i]];
		}
		return resultPoints;
	}

	/**
	 * 判断ba相对ao是不是左转
	 * 
	 * @return 大于0则左转
	 */
	private float isLeft(Point o, Point a, Point b) {
		float aoX = a.getX() - o.getX();
		float aoY = a.getY() - o.getY();
		float baX = b.getX() - a.getX();
		float baY = b.getY() - a.getY();
		return aoX * baY - aoY * baX;
	}

	/**
	 * 实现数组交换
	 * 
	 * @param i
	 * @param j
	 */
	private void swap(int i, int j) {
		Point tempPoint = new Point();
		tempPoint.setX(pointArray[j].getX());
		tempPoint.setY(pointArray[j].getY());
		tempPoint.setArCos(pointArray[j].getArCos());
		tempPoint.setIndex(pointArray[j].getIndex());

		pointArray[j].setX(pointArray[i].getX());
		pointArray[j].setY(pointArray[i].getY());
		pointArray[j].setArCos(pointArray[i].getArCos());
		pointArray[j].setIndex(pointArray[i].getIndex());

		pointArray[i].setX(tempPoint.getX());
		pointArray[i].setY(tempPoint.getY());
		pointArray[i].setArCos(tempPoint.getArCos());
		pointArray[i].setIndex(tempPoint.getIndex());
	}
	
	/**
	 * 选择排序
	 * @param start
	 * @param end
	 */
	private void selectSort(int start, int end) {
		for(int i=0;i<end-start;i++) {
			for(int j = i;j<end;j++) {
				if(pointArray[i].getArCos()>pointArray[j+1].getArCos()){
					swap(i, j+1);
				}
			}
		}
	}

	/**
	 * 角度计算
	 * @param i 指针
	 * @return
	 */
	private double angle(int i) {
		double j, k, m, h;
		j = pointArray[i].getX() - pointArray[0].getX();
		k = pointArray[i].getY() - pointArray[0].getY();
		m = Math.sqrt(j * j + k * k); // 得到顶点i 到第一顶点的线段长度
		h = Math.acos(j / m); // 得到该线段与x轴的角度
		return h;
	}
}
