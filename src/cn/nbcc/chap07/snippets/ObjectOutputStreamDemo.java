/**
 * ��������cn.nbcc.chap07.snippets
 * �ļ�����ObjectOutputStreamDemo.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-28 ����11:16:18
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
			//д����
			FileOutputStream fileOutputStream = new FileOutputStream("C:/myObject");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(s);
			
			
			//������
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

