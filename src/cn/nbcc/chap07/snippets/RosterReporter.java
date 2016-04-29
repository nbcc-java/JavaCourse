/**
 * ��������cn.nbcc.chap07.snippets
 * �ļ�����RosterReporter.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-12 ����06:54:46
 */
package cn.nbcc.chap07.snippets;
import java.io.IOException;
import java.io.Writer;
import cn.nbcc.chap04.entities.CourseSession;
import cn.nbcc.chap04.entities.Student;
public class RosterReporter {
	static final String ROSTER_REPORT_HEADER="ѧ������%n%20s%n";
	static final String ROSTER_REPORT_FOOTER="%20s%n������:%d%n";
	private CourseSession session;
	private Writer writer;
	
	public RosterReporter(CourseSession session) {
		this.session = session;
	}
	public void writeReport(Writer writer) throws IOException{
		this.writer = writer;
		writeHeader();
		writeBody();
		writeFooter();
	}
	private void writeFooter() throws IOException {
		writer.write(String.format(ROSTER_REPORT_FOOTER,"-", session.getAllStudent().size()).replace(' ', '-'));
	}
	private void writeBody() throws IOException {
		for (Student s : session.getAllStudent()) {
			writer.write(String.format("%s\t%s%n",s.getId(),s.getName()));
		}
	}
	private void writeHeader() throws IOException {
		writer.write(String.format(ROSTER_REPORT_HEADER,"-").replace(' ', '-'));
	}
}

