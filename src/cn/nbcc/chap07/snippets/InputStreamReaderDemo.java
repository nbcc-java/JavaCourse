/**
 * ��������cn.nbcc.chap07.snippets
 * �ļ�����InputStreamReaderDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-28 ����09:19:53
 */
package cn.nbcc.chap07.snippets;

import java.io.*;

public class InputStreamReaderDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PrintWriter printWriter = null;
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String input = null;
			FileWriter writer = new FileWriter("c:\\test.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			printWriter = new PrintWriter(bufferedWriter);
			while ((input =bufferedReader.readLine())!=null) {
				printWriter.println(input);
			}
//			printWriter.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (printWriter!=null) {
				printWriter.close();
			}
		}
	}

}

