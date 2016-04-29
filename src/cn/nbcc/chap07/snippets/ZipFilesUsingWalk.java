/**
 * ��������cn.nbcc.chap07.snippets
 * �ļ�����ZipFilesUsingWalk.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-6-12 ����10:13:27
 */
package cn.nbcc.chap07.snippets;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class ZipFilesUsingWalk {

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

			Path relPath = root.relativize(dir);
			System.out.println("Relative:" + relPath);
			Path folderPath = zipFileSystem.getPath(relPath.toString());
			if (folderPath.getNameCount() > 0 && Files.notExists(folderPath)) {
				{
					System.out.println("Create Dir:" + folderPath);
					Files.createDirectories(folderPath);
				}
				// Path folderPath = zipFileSystem.getPath(dir.toString());
				// File file = new File(folderPath.toString());
				// file.mkdirs();

			}
			return FileVisitResult.CONTINUE;
		}
		@Override
		public FileVisitResult visitFile(Path file,
				BasicFileAttributes attrs) throws IOException {
			if (!Files.isDirectory(file))
			{
				//�����ļ�֮ǰ����ָ��zip�ļ�ϵͳ��path
				Path zipPath = zipFileSystem.getPath(root.relativize(file).toString());
				System.out.println("Copy file"+file+" to "+zipPath);
//				System.out.println(root.relativize(file));
				Files.copy(file, zipPath,StandardCopyOption.REPLACE_EXISTING);
			}
			return FileVisitResult.CONTINUE;
		}
	}
	
	
	public static FileSystem createZipFileSystem(Path zipFile,boolean isCreate)
	{
		
		Map<String, String> env = new HashMap<String, String>();
		env.put("create", Boolean.toString(isCreate)); // ���zip�ļ��������򴴽�

		// ��Ŀ¼���ļ��б����Ѵ����������׳��쳣��zip�ļ�����δ����
		URI uri = URI.create("jar:"+zipFile.toUri());
		System.out.println(uri);

		FileSystem zipfs = null;
		try {
			zipfs = FileSystems.newFileSystem(uri, env);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return zipfs;
	}
	
	
	public static void main(String[] args) {
		Path desk = Paths.get("C:\\Users\\Administrator\\Desktop");
		FileSystem fs = createZipFileSystem(Paths.get(desk.toString(),"1.zip"), true);
		Path src = Paths.get("C:\\Users\\Administrator\\Desktop\\��������2014���У��������Ŀ�걨������֪ͨ_��ֹʱ��2014��6��9��");
		try {
			Files.walkFileTree(src, new MyFileVisitor(src, fs));
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

