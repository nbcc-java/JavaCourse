/**
 * 所属包：cn.nbcc.chap07.snippets
 * 文件名：DiskInfo.java
 * 创建者：郑哲
 * 创建时间：2014-3-25 上午10:28:03
 */
package cn.nbcc.chap07.snippets;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class DiskInfo {
	public static void main(String[] args) {
		
		File[] roots = File.listRoots();
		for (File file : roots) {
//			System.out.println(file.);
		}
		
		
		FileSystem fileSystem = FileSystems.getDefault();
		Iterable<FileStore> stores = fileSystem.getFileStores();
		long gigabyte = 1073741824L;
		for (FileStore store : stores) {
			try {
				System.out
						.format("\nStore: %-25s %-5s Capacity: %5dgb Unallocated: %6dgb",
								store.name(), store.type(),
								store.getTotalSpace() / gigabyte,
								store.getUnallocatedSpace() / gigabyte);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
