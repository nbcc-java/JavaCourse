/**
 * ��������cn.nbcc.chap02.snippets
 * �ļ�����RandomDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-4 ����07:58:35
 */
package cn.nbcc.chap02.snippets;

import java.util.Random;

public class RandomDemo2 {
	public static void main(String[] args) {
		
		final long seed = 100L;
		Random random1 = new Random(seed);
		boolean flips = random1.nextBoolean();
		if (flips) {
			//True����Ӳ������
			System.out.println("����");
		}else {
			System.out.println("����");
		}
		//ʹ��ϵͳʱ����Ϊ�����������������
		Random random2 = new Random();
		flips = random2.nextBoolean();
		if (flips) {
			//True����Ӳ������
			System.out.println("����");
		}else {
			System.out.println("����");
		}
	}
}

