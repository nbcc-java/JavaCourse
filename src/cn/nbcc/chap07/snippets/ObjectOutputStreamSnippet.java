/**
 * 所属包：cn.nbcc.chap07.snippets
 * 文件名：ObjectOutputStream.java
 * 创建者：郑哲
 * 创建时间：2014-2-12 下午11:10:34
 */
package cn.nbcc.chap07.snippets;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class ObjectOutputStreamSnippet {
	static class SaveObject implements Serializable
	{
		private static final long serialVersionUID = 1L;
		int xPos = 10;
		int yPos = 20;
		int width = 100;
		int height = 200;
		transient int hideValue = 10;   //不予序列话,即不会存盘
		public String toString() {
			return xPos + ","+yPos+","+width+","+height+","+hideValue;
		}
	}
	public static void main(String[] args) {
		SaveObject object = new SaveObject();
		try {
			FileOutputStream fos = new FileOutputStream("C:\\object.object");
			ObjectOutputStream oStream= new ObjectOutputStream(fos);
			oStream.writeObject(object);
			oStream.flush();
			oStream.close();
			FileInputStream fis =new FileInputStream("C:\\object.object");
			ObjectInputStream ois = new ObjectInputStream(fis);
			SaveObject obj = (SaveObject)(ois.readObject());
			System.out.println(obj);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

