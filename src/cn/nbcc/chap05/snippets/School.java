/**
 * 所属包：cn.nbcc.chap05.snippets
 * 文件名：School.java
 * 创建者：郑哲
 * 创建时间：2014-5-14 上午09:39:14
 */
package cn.nbcc.chap05.snippets;

import java.util.ArrayList;

public class School {
	
	ArrayList<Student> studentList = new ArrayList<Student>(10);
	
	/**
	 * 注册学生
	 */
	public void enrollStudent(Student s) throws StudentOverflowException
	{
		if (studentList.size()<10) {
			studentList.add(s);
		}else
			throw new StudentOverflowException("学生超过10人");
	}
}

