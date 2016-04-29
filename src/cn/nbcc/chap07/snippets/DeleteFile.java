/**
 * ��������cn.nbcc.chap07.snippets
 * �ļ�����DeleteFile.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-3-21 ����11:14:37
 */
package cn.nbcc.chap07.snippets;
import java.io.File;
import java.io.IOException;
public class DeleteFile {
	public static void main(String[] args) throws IOException{
		String fileName = "C:" + File.separator + "test" + File.separator+ "myFile.txt";
		File myFile = new File(fileName);
		if (!myFile.exists()) {
			throw new IOException("Cannot delete " + fileName + " because"+ fileName + " does not exist");
		} else {
			myFile.delete();
		}
		System.out.println(fileName + " exists? " + myFile.exists());
	}
}

