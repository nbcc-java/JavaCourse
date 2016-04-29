/**
 * 所属包：cn.nbcc.chap04.tasks
 * 文件名：GradingStrategy.java
 * 创建者：郑哲
 * 创建时间：2014-2-10 下午04:28:14
 */
package cn.nbcc.chap04.tasks;

import cn.nbcc.chap04.entities.Student;

public interface GradingStrategy {
	int getGradePointsFor(Student.Grade grade);
}

