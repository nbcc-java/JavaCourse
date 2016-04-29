/**
 * 所属包：cn.nbcc.chap07.snippets
 * 文件名：DeleteMultiDirectories.java
 * 创建者：郑哲
 * 创建时间：2014-3-24 下午11:00:21
 */
package cn.nbcc.chap07.snippets;

import java.io.File;
import java.io.IOException;

public class FileDeleteTest {
	public static void main(String[] args) throws IOException {
		deleteFile();
		deleteMultiDirectories();
	}
	
	public static void deleteFile() throws IOException {
		String fileName = "C:" + File.separator + "test" + File.separator+ "myFile.txt";
		File myFile = new File(fileName);
		if (!myFile.exists()) {
			throw new IOException("Cannot delete " + fileName + " because"+ fileName + " does not exist");
		} else {
			myFile.delete();
		}
		System.out.println(fileName + " exists? " + myFile.exists());
	}
	
	public static void deleteMultiDirectories() {
		String currentPath = "C:";
		// a double colon is illegal on my Windows machine, so this fails
		String[] pathParts = { "test", "test2", "test3::fail" };
		for (String pathPart : pathParts) {
			currentPath += File.separator + pathPart;
			File testDirectory = new File(currentPath);
			if (!testDirectory.mkdir()) {
				System.out.println("Failed to create " + testDirectory
						+ "; removing all created directories");
				removePathByParts("C:", pathParts);
			} else {
				System.out.println("Created " + testDirectory);
			}
		}
	}
	private static void removePathByParts(String pathStart, String[] pathParts) {
		String currentPath = pathStart;
		String[] paths = new String[pathParts.length];
		// 构建可能路径数组，如C:\test，C:\test\test2等
		for (int pathCounter = 0; pathCounter < pathParts.length; pathCounter++) {
			currentPath += File.separator + pathParts[pathCounter];
			paths[pathCounter] = currentPath;
		}
		// 逆向删除，如果该路径存在，则删除
		for (int pathCounter = pathParts.length - 1; pathCounter >= 0; pathCounter--) {
			File currentFile = new File(paths[pathCounter]);
			if (currentFile.delete()) {
				System.out.println("Removed " + currentFile);
			}
		}
	}

}
