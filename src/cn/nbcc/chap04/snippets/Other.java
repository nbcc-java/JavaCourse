/**
 * ��������cn.nbcc.chap04.snippets
 * �ļ�����Other.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-5 ����09:45:21
 */
package cn.nbcc.chap04.snippets;
public class Other extends Some {
	int n;
	
	public Other() {
		n=2;
	}
	public void doService() {
		super.doService();
	}
	
	public void doOtherService() {
		System.out.println("Do other service");
	}
	
	public static void main(String[] args) {
		Some some = new Other();
		System.out.println(some.n);
		
		
//		some.doService();			//��̬�󶨣���������ִ���ڸ���ʵ�ʰ󶨶��󣬶�̬ѡ�������Ӧ����
	}

}

