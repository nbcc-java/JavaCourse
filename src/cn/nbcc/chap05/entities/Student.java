package cn.nbcc.chap05.entities;


import cn.nbcc.chap04.entities.Student.Grade;
import cn.nbcc.chap04.tasks.GradingStrategy;
import cn.nbcc.chap04.tasks.RegularGradingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class Student  {
	public Student(String id,String name) {
		try {
			isValid(id);
		} catch (StudentIdFormatException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void isValid(String id) throws StudentIdFormatException {
		Pattern pattern = Pattern.compile("\\d{9}");
		Matcher matcher = pattern.matcher(id);
		if (!matcher.matches()) {
			String msg = "无效的学号格式";
			throw new StudentIdFormatException(msg);
		}
	}

	
	
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
		System.out.println("切换到学生视图");
	}
}
