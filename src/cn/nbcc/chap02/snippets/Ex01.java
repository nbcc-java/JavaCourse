/**
 * 所属包：cn.nbcc.chap02.snippets
 * 文件名：Ex01.java
 * 创建者：郑哲
 * 创建时间：2015-3-17 下午02:29:38
 */
package cn.nbcc.chap02.snippets;

import java.util.Scanner;


public class Ex01 {

	public static void main(String[] args) {
		int total = 0;

		System.out.println("请问你们班有几名学生？");
		Scanner sc = new Scanner(System.in);
		int numberOfStudents = sc.nextInt();

		for (int gradeCounter = 1; gradeCounter <= numberOfStudents; gradeCounter++) {
			System.out.println("请输入一名学生的成绩");
			total += sc.nextInt();
		}
		int avg = total / numberOfStudents;
		System.out.println("平均成绩是：" + avg);
		sc.close();
	}
}

