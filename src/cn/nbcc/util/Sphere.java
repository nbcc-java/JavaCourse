/**
 * ��������cn.nbcc.util
 * �ļ�����Sphere.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-4-21 ����09:28:21
 */
package cn.nbcc.util;
public class Sphere {
	double r;
	public double sphereVolume() {
		double volume =(4.0/3.0)*Math.PI*Math.pow(r,3);
		return volume;
		
		
	}
	public Sphere(double r){
		this.r=r;
	}

}

