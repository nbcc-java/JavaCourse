/**
 * 所属包：cn.nbcc.chap04.tasks
 * 文件名：RegularGradingStrategy.java
 * 创建者：郑哲
 * 创建时间：2014-2-10 下午04:30:25
 */
package cn.nbcc.chap04.tasks;

import cn.nbcc.chap04.entities.Student.Grade;

public class RegularGradingStrategy extends BasicGradingStrategy implements GradingStrategy {
	@Override
	public int getGradePointsFor(Grade grade) {
		return super.getGradePointsFor(grade);
	}
}

