package cn.nbcc.chap04.snippets;
import cn.nbcc.chap04.entities.Student;
import cn.nbcc.chap04.entities.Teacher;
import cn.nbcc.chap04.entities.User;
public class SMSApp2 {
	public static void main(String[] args) {
		Student s1 = new Student("001", "张三");
		Student s2 = new Student("001", "张三");
		System.out.println(s1.equals(s2));
	}
}

