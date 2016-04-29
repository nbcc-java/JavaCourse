package cn.nbcc.chap04.tasks;

import cn.nbcc.chap04.entities.Student.Grade;

public class BasicGradingStrategy implements GradingStrategy {
	
	@Override
	public int getGradePointsFor(Grade grade) {
		return grade.getPoints();
	}
}

