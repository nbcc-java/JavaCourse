/**
 * ��������cn.nbcc.chap04.tasks
 * �ļ�����RegularGradingStrategy.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-10 ����04:30:25
 */
package cn.nbcc.chap04.tasks;

import cn.nbcc.chap04.entities.Student.Grade;

public class HonorsGradingStrategy extends BasicGradingStrategy implements GradingStrategy {
	@Override
	public int getGradePointsFor(Grade grade) {
		int points = super.getGradePointsFor(grade);
		if (points>0) {
			points+=1;
		}
		return points;
	}
}

