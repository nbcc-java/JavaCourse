/**
 * ��������cn.nbcc.chap05.snippets
 * �ļ�����School.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-14 ����09:39:14
 */
package cn.nbcc.chap05.snippets;

import java.util.ArrayList;

public class School {
	
	ArrayList<Student> studentList = new ArrayList<Student>(10);
	
	/**
	 * ע��ѧ��
	 */
	public void enrollStudent(Student s) throws StudentOverflowException
	{
		if (studentList.size()<10) {
			studentList.add(s);
		}else
			throw new StudentOverflowException("ѧ������10��");
	}
}

