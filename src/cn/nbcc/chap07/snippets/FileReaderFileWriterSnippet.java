/**
 * ��������cn.nbcc.chap07.snippets
 * �ļ�����FileReaderFileWriterSnippet.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-12 ����10:16:34
 */
package cn.nbcc.chap07.snippets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class FileReaderFileWriterSnippet {
	public static void main(String[] args) throws IOException {
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader("c:\\test.txt"));
			outputStream = new PrintWriter(new FileWriter("c:\\out.txt"));

			String l;
			while ((l = inputStream.readLine()) != null) {
				outputStream.println(l);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}
}
