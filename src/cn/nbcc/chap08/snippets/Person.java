/**
 * ��������cn.nbcc.chap08.snippets
 * �ļ�����Person.java
 * �����ߣ�֣��
 * ����ʱ�䣺2015-5-29 ����04:38:30
 */
package cn.nbcc.chap08.snippets;
public class Person implements Runnable{
	
	int curNum = 1;
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	/**
	 * ����
	 */
	public void numberOff() {
		System.out.println(name+"say��"+curNum);
		curNum=(curNum++%10)+1;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (condition) {
			
		}
	}

}

