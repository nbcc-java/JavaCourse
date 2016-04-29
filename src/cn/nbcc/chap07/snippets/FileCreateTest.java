/**
 * ��������cn.nbcc.chap07.snippets
 * �ļ�����FileTest.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-3-21 ����10:16:55
 */
package cn.nbcc.chap07.snippets;
import java.io.File;
import java.io.IOException;
public class FileCreateTest {
	public static void main(String[] args) throws IOException {
		createNewFile();
	}

	

	public static void createNewFile() {
		String fileName = "C:"+File.separator+"test"+File.separator+"myFile.txt";
		File myFile = new File(fileName);
		try {
			myFile.createNewFile();
		} catch (Exception e) {
			System.out.println("Couldn't create " + myFile.getPath());
		}
		System.out.println("Created " + myFile.getPath());
	}
}

