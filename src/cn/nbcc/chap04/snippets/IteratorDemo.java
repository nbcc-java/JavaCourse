/**
 * ��������cn.nbcc.chap04.snippets
 * �ļ�����IteratorDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-10 ����11:23:27
 */
package cn.nbcc.chap04.snippets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.nbcc.chap04.entities.Student;

public class IteratorDemo {

	public static void main(String[] args) {
		
		getStudentsGPA();

	}

	public static double getStudentsGPA() {
		List<Student> students = new ArrayList<Student>();
		double total = 0;
		int count = 0;
		for (Iterator<Student> it = students.iterator(); it.hasNext();) {
			Student student = (Student) it.next();
			count++;
			total+=student.getGPA();
		}
		if (count==0) {
			return 0.0;
		}
		return total/count;
	}

}

