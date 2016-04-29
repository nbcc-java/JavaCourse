/**
 * 所属包：cn.nbcc.chap07.snippets
 * 文件名：ObjectOutputStreamDemo.java
 * 创建者：郑哲
 * 创建时间：2014-5-28 上午11:16:18
 */
package cn.nbcc.chap07.snippets;

import java.io.*;

public class ObjectOutputStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Student s = new Student();
		
		try {
			//写对象
			FileOutputStream fileOutputStream = new FileOutputStream("C:/myObject");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(s);
			
			
			//读对象
			FileInputStream fileInputStream = new FileInputStream("C:/myObject");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Student s1 = (Student)objectInputStream.readObject();
			
			System.out.println(s1);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

	}

}

