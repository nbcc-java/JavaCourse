/**
 * 所属包：cn.nbcc.chap05.project
 * 文件名：SMSApp.java
 * 创建者：郑哲
 * 创建时间：2016年4月28日 下午10:18:03
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
		
		Student s = new Student("001", "张三");
		s.addGrade(Grade.A);
		s.addGrade(Grade.B);
		System.out.printf("%s isn't hornor and his GPA is %.2f%n",s.getName(),s.getGPA());
		
		s.setGradingStrategy(new HonorsGradingStrategy());
		System.out.printf("Now %s is hornor and his GPA is %.2f%n",s.getName(),s.getGPA());
		

	}

}

