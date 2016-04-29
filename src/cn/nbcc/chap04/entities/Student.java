package cn.nbcc.chap04.entities;
import java.util.ArrayList;
import java.util.List;
import cn.nbcc.chap04.tasks.GradingStrategy;
import cn.nbcc.chap04.tasks.RegularGradingStrategy;
public  class Student extends User {
	private List<Integer> charges = new ArrayList<Integer>();
	
	public void addCharge(int charge) {
		charges.add(new Integer(charge));
	}
	public int totalCharges() {
		int total=0;
		for (Integer charge : charges) {
			total+=charge.intValue();
		}
		return total;
	}
	
	public enum Grade{
		A(4),
		B(3),
		C(2),
		D(1),
		F(0);
		private int points;
		private Grade(int points) {
			this.points = points;
		}
		public int getPoints() {
			return points;
		}
	};
	
	private ArrayList<Grade> grades = new ArrayList<Grade>();
	private GradingStrategy gradingStrategy = new RegularGradingStrategy();
	
	
	public void setGradingStrategy(GradingStrategy gradingStrategy) {
		this.gradingStrategy = gradingStrategy;
	}
	
	public double gradePointsFor( Grade grade) {
		return gradingStrategy.getGradePointsFor(grade);
	}
	
	public Student() {
		this("11","s1");
	}
	public Student(String id,String name) {
		//name="test"
		super(id,name);
	}
	public void addGrade(Grade grade ) {
		grades.add(grade);
	}
	public double getGPA() {
		if (grades.isEmpty()) 
			return 0.0;
		double total = 0.0;
		for (Grade grade : grades) {
			total = gradePointsFor( grade);
		}
		return total/grades.size();
	}
	
	public void login(){
		super.login();
		System.out.println("切换到学生视图");
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student other = (Student) obj;
			return this.id.equals(other.id);
		}
		return super.equals(obj);
	}
}
