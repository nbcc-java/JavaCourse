/**
 * ��������cn.nbcc.chap04.entities
 * �ļ�����Teacher.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-8 ����04:04:59
 */
package cn.nbcc.chap04.entities;
public class Teacher extends User {

	public Teacher(String id, String name) {
		super(id, name);
	}
	@Override
	public void login() {
		super.login();
		System.out.println("�л�����ʦ��ͼ����");
	}
}

