/**
 * ��������cn.nbcc.chap07.snippets
 * �ļ�����Student.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-28 ����11:14:05
 */
package cn.nbcc.chap07.snippets;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = -6660389868596838378L;
	String name="����";
	transient int age=24;
	
	public String toString() {
		return name+","+age;
	}
}

