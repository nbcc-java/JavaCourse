/**
 * 所属包：cn.nbcc.chap05.snippets
 * 文件名：ExceptionDemo.java
 * 创建者：郑哲
 * 创建时间：2014-5-14 上午08:44:32
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
			//捕获异常
			if (denominator==0) {
				System.out.println("除数不能为0");
			}else
				e.printStackTrace();
		}
		
		return res;
	}


}

