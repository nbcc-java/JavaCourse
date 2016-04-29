/**
 * 所属包：cn.nbcc.chap07.snippets
 * 文件名：FileInputFileOutputStreamSnippet.java
 * 创建者：郑哲
 * 创建时间：2014-2-12 下午09:34:17
 */
package cn.nbcc.chap07.snippets;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class FileInputFileOutputStreamSnippet {
	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("c:\\test.txt");
			out = new FileOutputStream("c:\\out.txt");
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}
