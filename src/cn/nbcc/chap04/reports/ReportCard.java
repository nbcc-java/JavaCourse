/**
 * ��������cn.nbcc.chap04.reports
 * �ļ�����ReportCard.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-11 ����04:09:04
 */
package cn.nbcc.chap04.reports;

import java.util.EnumMap;
import java.util.Map;

import cn.nbcc.chap04.entities.Student;
import cn.nbcc.chap04.entities.Student.Grade;

public class ReportCard {
	static final String A_MESSAGE = "���ַǳ�����";
	static final String B_MESSAGE = "���ַǳ���";
	static final String C_MESSAGE = "���ֻ�����Ŷ";
	static final String D_MESSAGE = "��������Ŷ";
	static final String F_MESSAGE = "��Ҫ������";
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
