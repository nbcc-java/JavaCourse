/**
 * 所属包：cn.nbcc.util
 * 文件名：Sphere.java
 * 创建者：郑哲
 * 创建时间：2014-4-21 上午09:28:21
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

