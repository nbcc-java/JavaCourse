/**
 * ��������cn.nbcc.chap07.snippets
 * �ļ�����TransferIODemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-12 ����08:37:15
 */
package cn.nbcc.chap07.snippets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TransferIODemo {
	public static void main(String[] args) {
		try {
			BufferedReader inReader = new BufferedReader(
												new FileReader("C:/zhengzhe.txt")			
			);
			System.out.println(inReader.readLine());			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ļ��Ҳ���");
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

