/**
 * 所属包：cn.nbcc.chap07.snippets
 * 文件名：SetOutSnippet.java
 * 创建者：郑哲
 * 创建时间：2014-2-12 下午08:59:56
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

