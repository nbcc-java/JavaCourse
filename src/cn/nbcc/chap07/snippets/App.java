package cn.nbcc.chap07.snippets;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import cn.nbcc.chap04.entities.CourseSession;
import cn.nbcc.chap04.entities.Student;
public class App {
	public static void main(String[] args) {
		CourseSession session = new CourseSession("039201", "Java程序设计");
		session.enroll(new Student("000000001","张三"));
		Writer writer= new StringWriter();
		try {
			new RosterReporter(session).writeReport(writer);
			System.out.println(writer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

