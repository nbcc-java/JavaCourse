/**
 * 所属包：cn.nbcc.chap04.reports
 * 文件名：ReportCard.java
 * 创建者：郑哲
 * 创建时间：2014-2-11 下午04:09:04
 */
package cn.nbcc.chap04.reports;

import java.util.EnumMap;
import java.util.Map;

import cn.nbcc.chap04.entities.Student;
import cn.nbcc.chap04.entities.Student.Grade;

public class ReportCard {
	static final String A_MESSAGE = "表现非常完美";
	static final String B_MESSAGE = "表现非常好";
	static final String C_MESSAGE = "表现还不错哦";
	static final String D_MESSAGE = "继续加油哦";
	static final String F_MESSAGE = "需要再试试";
	private Map<Student.Grade, String> messages = null;

	private void loadMessage() {
		messages = new EnumMap<Student.Grade, String>(Grade.class);
		messages.put(Grade.A, A_MESSAGE);
		messages.put(Grade.B,B_MESSAGE);
		messages.put(Grade.C, C_MESSAGE);
		messages.put(Grade.D, D_MESSAGE);
		messages.put(Grade.F, F_MESSAGE);
	}

	public String getMessage(Student.Grade grade) {
		return messages.get(grade);
	}

	private Map<Student.Grade, String> getMessages() {
		if (messages == null) {
			loadMessage();
		}
		return messages;
	}
}
