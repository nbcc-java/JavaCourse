package cn.nbcc.chap04.entities;
import java.util.ArrayList;
import java.util.List;
public class CourseSession {
	private String id;
	private String depart;
	private ArrayList<Student> students = new ArrayList<Student>();
	public CourseSession(String id, String dep) {
		super();
		this.id = id;
		this.depart = dep;
	}
	public void enroll(Student s) {
		students.add(s);
	}
	public User getStudent(int index) {
		return students.get(index);
	}
	public List<Student> getAllStudent() {
		return students;
	}
}
