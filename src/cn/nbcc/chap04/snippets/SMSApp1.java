package cn.nbcc.chap04.snippets;
import java.util.Arrays;
import java.util.regex.Pattern;

import cn.nbcc.chap04.entities.Student;
import cn.nbcc.chap04.entities.Teacher;
import cn.nbcc.chap04.entities.User;
public class SMSApp1 {
	public static void main(String[] args) {
		User[] usrs = {
				new Student("001", "����"),
				new Teacher("001", "����ʦ")
		};
		for (User usr : usrs) {
//			usr.login();
			System.out.println(usr);//�ȼ�System.out.println(usr.toString());
		}
		
	}
}

