/**
 * 所属包：cn.nbcc.chap07.snippets
 * 文件名：FileReaderDemo.java
 * 创建者：郑哲
 * 创建时间：2014-5-28 上午08:54:28
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
			System.out.println("文件找不到");
		} catch (IOException e) {
			System.out.println("文件被损坏，无法读取");
		} 
	}

}

