/**
 * ��������cn.nbcc.chap04.tasks
 * �ļ�����GradingStrategy.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-10 ����04:28:14
 */
package cn.nbcc.chap04.tasks;

import cn.nbcc.chap04.entities.Student;

public interface GradingStrategy {
	int getGradePointsFor(Student.Grade grade);
}

