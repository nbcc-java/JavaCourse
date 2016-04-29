/**
 * ��������cn.nbcc.chap05.snippets
 * �ļ�����ExceptionDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-14 ����08:44:32
 */
package cn.nbcc.chap05.snippets;

import java.util.Scanner;

public class ExceptionDemo {
	
	public static void main(String[] args) {
		int denominator = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print( "Please enter an integer numerator: " );
		int numerator = scanner.nextInt();
		System.out.print( "Please enter an integer denominator: " );
		denominator = scanner.nextInt();
		int result = quotient( numerator, denominator );
		System.out.printf(
				"\nResult: %d / %d = %d\n", numerator, denominator, result );
		
	}

	private static int quotient(int numerator, int denominator) {
		int res = 0;
		try {
			res  = numerator/denominator;
		} catch (Exception e) {
			//�����쳣
			if (denominator==0) {
				System.out.println("��������Ϊ0");
			}else
				e.printStackTrace();
		}
		
		return res;
	}


}

