/**
 * 所属包：cn.nbcc.chap07.snippets
 * 文件名：ZipDemo.java
 * 创建者：郑哲
 * 创建时间：2014-6-11 下午08:14:06
 */
package cn.nbcc.chap07.snippets;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.util.HashMap;
import java.util.Map;

public class ZipDemo {

	public static FileSystem createZipFileSystem()
	{
		
		Map<String, String> env = new HashMap<String, String>();
		env.put("create", "true"); // 如果zip文件不存在则创建

		// 父目录的文件夹必须已创建，否则抛出异常。zip文件可以未创建
		URI uri = URI.create("jar:file:/c:/testzipfs.zip");

		FileSystem zipfs = null;
		try {
			zipfs = FileSystems.newFileSystem(uri, env);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return zipfs;
	}
	
	private static void create() {
		Map<String, String> env = new HashMap<String, String>();
		env.put("create", "true"); // 如果zip文件不存在则创建

		// 父目录的文件夹必须已创建，否则抛出异常。zip文件可以未创建
		URI uri = URI.create("jar:file:/c:/testzipfs.zip");

		FileSystem zipfs = null;
		try {
			zipfs = FileSystems.newFileSystem(uri, env);

			Path externalPath = Paths.get("c:/out.txt");

			// 创建zip文件里的目录
			Path zipDir = zipfs.getPath("abc/xyz");
			Files.createDirectories(zipDir);
			zipDir = zipfs.getPath("bbc\\123");
			Files.createDirectories(zipDir);

			System.out.println("zipDir: " + zipDir);

			// 路径必须是已创建。
//			Path contentFile = zipfs.getPath("abc/xyz", "copyRight");

//			Files.copy(externalPath, contentFile,StandardCopyOption.REPLACE_EXISTING);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				zipfs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

//	private static void walkZipPath(final String saveDir, Path path)
//	throws IOException {
//		
//		FileVisitor<Path> fv = new FileVisitor<Path>() {
//			@Override
//			public FileVisitResult preVisitDirectory(Path dir,
//					BasicFileAttributes attrs) throws IOException {
//				// 创建本地目录
//				new File(saveDir, dir.toString()).mkdirs();
//				
//				return FileVisitResult.CONTINUE;
//			}
//			
//			@Override
//			public FileVisitResult visitFile(Path file,
//					BasicFileAttributes attrs) throws IOException {
//				// 创建本地文件路径
//				Path Localtarget = Paths.get(saveDir, file.toString());
//				
//				// 拷贝到本地文件系统
//				Files.copy(file, Localtarget,
//						StandardCopyOption.REPLACE_EXISTING);
//				
//				return FileVisitResult.CONTINUE;
//			}
//			
//			@Override
//			public FileVisitResult visitFileFailed(Path file, IOException exc)
//			throws IOException {
//				
//				exc.printStackTrace();
//				
//				return FileVisitResult.TERMINATE;
//			}
//			
//			@Override
//			public FileVisitResult postVisitDirectory(Path dir, IOException exc)
//			throws IOException {
//				// 不为空表示出错
//				if (exc != null) {
//					exc.printStackTrace();
//					return FileVisitResult.TERMINATE;
//				}
//				
//				return FileVisitResult.CONTINUE;
//			}
//		};
//		
//		Files.walkFileTree(path, fv);
//	}
	
	static class MyFileVisitor extends SimpleFileVisitor<Path>{
		
		private Path root;
		private FileSystem zipFileSystem ;

		public MyFileVisitor(Path root,FileSystem zfs) {
			this.root = root;
			this.zipFileSystem = zfs;
		}
		
		
		
		@Override
		public FileVisitResult preVisitDirectory(Path dir,
				BasicFileAttributes attrs) throws IOException {
			
			Path relPath = root.getParent().relativize(dir);
			System.out.println("Relative:"+relPath);
			Path folderPath = zipFileSystem.getPath(relPath.toString());
//			Files.createDirectories(folderPath);
			if (Files.notExists(folderPath)) {
				Files.createDirectory(folderPath);
			}
			
			
//			// 创建本地目录
//			new File(saveDir, dir.toString()).mkdirs();
			
			return FileVisitResult.CONTINUE;
		}
		
		@Override
		public FileVisitResult visitFile(Path file,
				BasicFileAttributes attrs) throws IOException {
			
			if (!Files.isDirectory(file))
			{
				System.out.println(root.getParent().relativize(file));
				Files.copy(file, zipFileSystem.getPath(root.getParent().relativize(file).toString()),StandardCopyOption.REPLACE_EXISTING);
			}
			
//			// 创建本地文件路径
//			Path Localtarget = Paths.get(saveDir, file.toString());
//			
//			// 拷贝到本地文件系统
//			Files.copy(file, Localtarget,
//					StandardCopyOption.REPLACE_EXISTING);
			
			return FileVisitResult.CONTINUE;
		}
	}
//	private static void zipFileTree(final String toZipDir, Path path)
//	throws IOException {
//		
//		
////		Files.walkFileTree(toZipDir, fv);
//	}
	

	public static void main(String[] args) {
		Path start = Paths.get("c:/test");
		FileSystem fs = createZipFileSystem();
		try {
			Files.walkFileTree(start, new MyFileVisitor(start,fs));
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				//必须在关闭文件系统才能看到生成的文件和文件夹
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
