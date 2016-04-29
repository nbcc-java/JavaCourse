/**
 * ��������cn.nbcc.chap07.snippets
 * �ļ�����ZipDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-6-11 ����08:14:06
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
		env.put("create", "true"); // ���zip�ļ��������򴴽�

		// ��Ŀ¼���ļ��б����Ѵ����������׳��쳣��zip�ļ�����δ����
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
		env.put("create", "true"); // ���zip�ļ��������򴴽�

		// ��Ŀ¼���ļ��б����Ѵ����������׳��쳣��zip�ļ�����δ����
		URI uri = URI.create("jar:file:/c:/testzipfs.zip");

		FileSystem zipfs = null;
		try {
			zipfs = FileSystems.newFileSystem(uri, env);

			Path externalPath = Paths.get("c:/out.txt");

			// ����zip�ļ����Ŀ¼
			Path zipDir = zipfs.getPath("abc/xyz");
			Files.createDirectories(zipDir);
			zipDir = zipfs.getPath("bbc\\123");
			Files.createDirectories(zipDir);

			System.out.println("zipDir: " + zipDir);

			// ·���������Ѵ�����
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
//				// ��������Ŀ¼
//				new File(saveDir, dir.toString()).mkdirs();
//				
//				return FileVisitResult.CONTINUE;
//			}
//			
//			@Override
//			public FileVisitResult visitFile(Path file,
//					BasicFileAttributes attrs) throws IOException {
//				// ���������ļ�·��
//				Path Localtarget = Paths.get(saveDir, file.toString());
//				
//				// �����������ļ�ϵͳ
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
//				// ��Ϊ�ձ�ʾ����
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
			
			
//			// ��������Ŀ¼
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
			
//			// ���������ļ�·��
//			Path Localtarget = Paths.get(saveDir, file.toString());
//			
//			// �����������ļ�ϵͳ
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
				//�����ڹر��ļ�ϵͳ���ܿ������ɵ��ļ����ļ���
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
