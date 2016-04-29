package cn.nbcc.chap04.snippets;
import cn.nbcc.chap04.entities.Student;
import cn.nbcc.chap04.entities.Teacher;
import cn.nbcc.chap04.entities.User;
public class SMSApp {
	public static void main(String[] args) {
		Student s = new Student("001", "张三");
		Teacher t = new Teacher("001", "王老师");
		User u = new Student("002", "李四");
//		User[] usrs= { 
//				new Student("001", "张三"),
//				new Teacher("001", "王老师")
//		};
		System.out.println(t instanceof User);
		System.out.println(s instanceof User);
		System.out.println(u instanceof Student);
		System.out.println(u instanceof Teacher);
	}
}

