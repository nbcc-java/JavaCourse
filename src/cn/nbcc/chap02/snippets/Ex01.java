/**
 * ��������cn.nbcc.chap02.snippets
 * �ļ�����Ex01.java
 * �����ߣ�֣��
 * ����ʱ�䣺2015-3-17 ����02:29:38
 */
package cn.nbcc.chap02.snippets;

import java.util.Scanner;


public class Ex01 {

	public static void main(String[] args) {
		int total = 0;

		System.out.println("�������ǰ��м���ѧ����");
		Scanner sc = new Scanner(System.in);
		int numberOfStudents = sc.nextInt();

		for (int gradeCounter = 1; gradeCounter <= numberOfStudents; gradeCounter++) {
			System.out.println("������һ��ѧ���ĳɼ�");
			total += sc.nextInt();
		}
		int avg = total / numberOfStudents;
		System.out.println("ƽ���ɼ��ǣ�" + avg);
		sc.close();
	}
}

