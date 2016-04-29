/**
 * ��������cn.nbcc.chap05.project
 * �ļ�����SMSApp.java
 * �����ߣ�֣��
 * ����ʱ�䣺2016��4��28�� ����10:18:03
 */
package cn.nbcc.chap04.project;

import cn.nbcc.chap04.entities.Student;
import cn.nbcc.chap04.entities.Student.Grade;
import cn.nbcc.chap04.tasks.HonorsGradingStrategy;

public class SMSApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Student s = new Student("001", "����");
		s.addGrade(Grade.A);
		s.addGrade(Grade.B);
		System.out.printf("%s isn't hornor and his GPA is %.2f%n",s.getName(),s.getGPA());
		
		s.setGradingStrategy(new HonorsGradingStrategy());
		System.out.printf("Now %s is hornor and his GPA is %.2f%n",s.getName(),s.getGPA());
		

	}

}

