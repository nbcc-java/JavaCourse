/**
 * ��������cn.nbcc.chap02.snippets
 * �ļ�����ScopeDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-4 ����11:49:05
 */
package cn.nbcc.chap02.snippets;
public class ScopeDemo {
	static int count=0;
	int x = 1;
	public static void main(String[] args) {
		//int x=1;//�������x��������
		{
			int x=2;
			System.out.println(x);
		}
		{
			int x=3;
			System.out.println(x);
		}
		ScopeDemo s = new ScopeDemo();
		System.out.println(s.x);
		System.out.println(ScopeDemo.count);
	}
	private void someMethod() {
		System.out.println(x);
	}
}

