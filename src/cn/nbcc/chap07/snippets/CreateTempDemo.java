/**
 * 所属包：cn.nbcc.chap07.snippets
 * 文件名：CreateTempDemo.java
 * 创建者：郑哲
 * 创建时间：2014-4-14 上午10:11:27
 */
package cn.nbcc.chap07.snippets;
import java.io.File;
public class CreateTempDemo {
	public static void main(String[] args) {
		String tempDirectoryName = "C:" + File.separator + "test";
		File tempDirectory = new File(tempDirectoryName);
		for (int i = 0; i < 10; i++) {
			try {
				File thisFile = File.createTempFile("tmp", null, tempDirectory);
			} catch (Exception e) {
				System.out.println("Couldn't create temp file " + i);
			}
		}
		System.out.println("Done creating temp files");
	}
}

