/**
 * ��������cn.nbcc.chap07.snippets
 * �ļ�����SetOutSnippet.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-12 ����08:59:56
 */
package cn.nbcc.chap07.snippets;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
public class SetOutSnippet {
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = new PrintStream(new FileOutputStream("C:\\test.txt"));
		System.setOut(ps);
		System.out.println("HelloWorld");
	}
}

