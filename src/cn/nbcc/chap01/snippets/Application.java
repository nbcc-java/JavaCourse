//包声明语句，将代码定义在指定包中
package cn.nbcc.chap01.snippets;

//在第10行的程序代码中使用了Student类，需要导入语句导入类的定义
import java.util.ArrayList;

import cn.nbcc.chap01.snippets.entities.Student;

//import cn.nbcc.chap01.snippets.entities.Student;

public class Application{
	
	public static void main(String args[])
	{
		
		//使用Student类，创建对象
		Student s = new Student();
		s.sayHello();
	}
}