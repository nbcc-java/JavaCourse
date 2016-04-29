/**
 * 所属包：cn.nbcc.chap07.snippets
 * 文件名：TransferIODemo.java
 * 创建者：郑哲
 * 创建时间：2014-2-12 下午08:37:15
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
			System.out.println("文件找不到");
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

