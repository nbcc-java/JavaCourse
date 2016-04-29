/**
 * 所属包：cn.nbcc.util
 * 文件名：App.java
 * 创建者：郑哲
 * 创建时间：2014-4-21 上午09:00:03
 */
package cn.nbcc.util.app;

import java.util.Scanner;

import cn.nbcc.util.Light;
import cn.nbcc.util.Some;
import cn.nbcc.util.Sphere;

public class App {
	
	public static void main(String[] args) {
		
//		System.out.println("Enter the row num:");
//		Scanner scanner = new Scanner(System.in);
		tower(8,"A","B","C");
		//递归方法设计要点
		//01、找到递推公式
		//02、找到出口
	}

	/**
	 * @param i
	 * @param string
	 * @param string2
	 * @param string3
	 */
	private static void tower(int n, String pole1, String pole2,
			String pole3) {
		if (n==1) {
			System.out.println("从"+pole1+"搬到"+pole3);
		}
		else{
			//一般情况
			tower(n-1,pole1,pole3,pole2);
			System.out.println("从"+pole1+"搬到"+pole3);
			tower(n-1,pole2,pole1,pole3);
		}
	}
}

