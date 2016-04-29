/**
 * ��������cn.nbcc.chap07.snippets
 * �ļ�����FileReaderDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-28 ����08:54:28
 */
package cn.nbcc.chap07.snippets;

import java.io.*;

public class FileReaderDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader("C:\\test.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			System.out.println(bufferedReader.readLine());
		} catch (FileNotFoundException e) {
			System.out.println("�ļ��Ҳ���");
		} catch (IOException e) {
			System.out.println("�ļ����𻵣��޷���ȡ");
		} 
	}

}

