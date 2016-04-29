/**
 * 所属包：cn.nbcc.chap07.snippets
 * 文件名：FileTest.java
 * 创建者：郑哲
 * 创建时间：2014-3-21 下午10:16:55
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

