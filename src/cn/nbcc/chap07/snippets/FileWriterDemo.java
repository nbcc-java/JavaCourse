/**
 * ��������cn.nbcc.chap07.snippets
 * �ļ�����FileWriterDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-28 ����09:06:12
 */
package cn.nbcc.chap07.snippets;

import java.io.*;

public class FileWriterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			InputStreamReader streamReader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(streamReader);
			FileWriter fileWriter = new FileWriter("c:\\test.txt");
			BufferedWriter bufferedWriter =new BufferedWriter(fileWriter);
			PrintWriter printWriter = new PrintWriter(bufferedWriter);
			
			
			printWriter.println(bufferedReader.readLine());
			printWriter.flush();
			
//			fileWriter.write(bufferedReader.readLine());
//			fileWriter.flush();
			
			System.out.println();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

