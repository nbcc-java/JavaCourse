/**
 * 所属包：cn.nbcc.chap07.snippets
 * 文件名：SetInSnippet.java
 * 创建者：郑哲
 * 创建时间：2014-2-12 下午08:47:49
 */
package cn.nbcc.chap07.snippets;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class SetInSnippet {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("C:\\test.txt"));
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
	}
}

