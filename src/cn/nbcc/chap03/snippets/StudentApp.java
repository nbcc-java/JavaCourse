/**
 * ��������cn.nbcc.chap03.snippets
 * �ļ�����StudentAnonymousClassAppSnippet.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-10-2 ����11:39:36
 */
package cn.nbcc.chap03.snippets;
public class StudentApp {
	public static void main(String[] args) {
		Student s = new Student();
		Student.Address sAddr = s.new Address("�㽭����","315000");
		s.schoolAddress=sAddr;
	}
}

