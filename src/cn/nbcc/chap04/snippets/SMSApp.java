package cn.nbcc.chap04.snippets;
import cn.nbcc.chap04.entities.Student;
import cn.nbcc.chap04.entities.Teacher;
import cn.nbcc.chap04.entities.User;
public class SMSApp {
	public static void main(String[] args) {
		Student s = new Student("001", "����");
		Teacher t = new Teacher("001", "����ʦ");
		User u = new Student("002", "����");
//		User[] usrs= { 
//				new Student("001", "����"),
//				new Teacher("001", "����ʦ")
//		};
		System.out.println(t instanceof User);
		System.out.println(s instanceof User);
		System.out.println(u instanceof Student);
		System.out.println(u instanceof Teacher);
	}
}

