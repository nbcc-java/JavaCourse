/**
 * ��������cn.nbcc.util
 * �ļ�����App.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-4-21 ����09:00:03
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
		//�ݹ鷽�����Ҫ��
		//01���ҵ����ƹ�ʽ
		//02���ҵ�����
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
			System.out.println("��"+pole1+"�ᵽ"+pole3);
		}
		else{
			//һ�����
			tower(n-1,pole1,pole3,pole2);
			System.out.println("��"+pole1+"�ᵽ"+pole3);
			tower(n-1,pole2,pole1,pole3);
		}
	}
}

