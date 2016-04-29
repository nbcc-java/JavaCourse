/**
 * 所属包：cn.nbcc.chap07.snippets
 * 文件名：ListingDirectory.java
 * 创建者：郑哲
 * 创建时间：2014-3-24 下午11:19:48
 */
package cn.nbcc.chap07.snippets;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListingDirectory {

	public static void main(String[] args) {
		Path currentPath = Paths.get(System.getProperty("user.dir"));
		currentPath = currentPath.getParent();
		// Get the entire directory contents
		filterDirectoryContents(currentPath, null);
		// Now try a fi lter for .txt fi les
		System.out.println("\nFilter for .txt:");
		filterDirectoryContents(currentPath, "*.txt");
		// Get fi les with a 3 character extension begiining with ‘j’
		System.out.println("\nFilter for .j??:");
		filterDirectoryContents(currentPath, "*.j??");
	}
	// Filter the contents of a directory
	private static void filterDirectoryContents(Path path, String filter) {
		try {
			DirectoryStream<Path> paths = filter != null ? Files.newDirectoryStream(path, filter):
		Files.newDirectoryStream(path);
			
		System.out.println("\n" + path + " directory contains:");
		for(Path p : paths) {
			System.out.println(" " + p.getFileName() +
			(Files.isDirectory(p) ? " is a directory." : ""));
		}
		}catch(NotDirectoryException e) {
		System.err.println("Path is not a directory." + e);
		} catch(IOException e) {
		System.err.println("I/O error." + e);
		}
	}
}

