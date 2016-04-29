/**
 * 所属包：cn.nbcc.chap07.snippets
 * 文件名：RandomAccessDemo.java
 * 创建者：郑哲
 * 创建时间：2014-4-14 下午10:37:40
 */
package cn.nbcc.chap07.snippets;

import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessDemo {
	static class Student {
		private String id;
		private String name;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		Student(String id, String name) {
			this.id = id;
			this.name = name;
		}
	}

	static class StudentDB implements Closeable {
		final static int STU_ID_LEN = 10;//字符数
		final static int STU_NAME_LEN = 20;
		private final static int RECLEN = 2 * STU_ID_LEN + 2 * STU_NAME_LEN;// 记录字节数长度
		private RandomAccessFile raf;

		StudentDB(String pathname) throws IOException {
			raf = new RandomAccessFile(pathname, "rw");
		}

		void append(String id, String name) throws IOException {
			raf.seek(raf.length());
			write(id, name);
		}

		@Override
		public void close() throws IOException {
			// throw new IOException("cannot close raf");
			raf.close();
		}

		int numRecs() throws IOException {
			return (int) raf.length() / RECLEN;
		}

		Student select(int recno) throws IOException {
			if (recno < 0 || recno >= numRecs())
				throw new IllegalArgumentException(recno + " out of range");
			raf.seek(recno * RECLEN);
			return read();
		}

		void update(int recno, String id, String name) throws IOException {
			if (recno < 0 || recno >= numRecs())
				throw new IllegalArgumentException(recno + " out of range");
			raf.seek(recno * RECLEN);
			write(id, name);
		}

		private Student read() throws IOException {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < STU_ID_LEN; i++)
				sb.append(raf.readChar());
			String id = sb.toString().trim();
			sb.setLength(0);
			for (int i = 0; i < STU_NAME_LEN; i++)
				sb.append(raf.readChar());
			String name = sb.toString().trim();
			return new Student(id, name);
		}

		private void write(String id, String name) throws IOException {
			StringBuffer sb = new StringBuffer(id);
			if (sb.length() > STU_ID_LEN)
				sb.setLength(STU_ID_LEN);
			else if (sb.length() < STU_ID_LEN) {
				int len = STU_ID_LEN - sb.length();
				for (int i = 0; i < len; i++)
					sb.append(" ");
			}
			raf.writeChars(sb.toString());
			sb = new StringBuffer(name);
			if (sb.length() > STU_NAME_LEN)
				sb.setLength(STU_NAME_LEN);
			else if (sb.length() < STU_NAME_LEN) {
				int len = STU_NAME_LEN - sb.length();
				for (int i = 0; i < len; i++)
					sb.append(" ");
			}
			raf.writeChars(sb.toString());
		}
	}

	public static void main(String[] args) {
		StudentDB pdb = null;
		try {
			pdb = new StudentDB("parts.db");
			if (pdb.numRecs() == 0) {
				pdb.append("123031201", "岑科梦");
				pdb.append("123031203", "陈相康");
				pdb.append("123031204", "董晓玲");
				pdb.append("123031207", "蒋烁");
				pdb.append("123031208", "金贤凡");
			}
			
			System.out.println("---------Before updating--------- ");
			dumpRecords(pdb);
			pdb.update(1, "123031202", "蓝岚*");
			System.out.println("---------After updating--------- ");
			dumpRecords(pdb);
		} catch (IOException ioe) {
			System.err.println(ioe);
			if (ioe.getSuppressed().length == 1)
				System.err.println("Suppressed = " + ioe.getSuppressed()[0]);
		}finally{
			if (pdb!=null) {
				try {
					pdb.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static void dumpRecords(StudentDB pdb) throws IOException {
		for (int i = 0; i < pdb.numRecs(); i++) {
			RandomAccessDemo.Student part = pdb.select(i);
			System.out.print(format(part.getId(), StudentDB.STU_ID_LEN, true));
			System.out.print(" | ");
			System.out.println(format(part.getName(), StudentDB.STU_NAME_LEN,
					true));
		}
		System.out.println("Number of records = " + pdb.numRecs());
		System.out.println();
	}

	static String format(String value, int maxWidth, boolean leftAlign) {
		StringBuffer sb = new StringBuffer();
		int len = value.length();
		if (len > maxWidth) {
			len = maxWidth;
			value = value.substring(0, len);
		}
		if (leftAlign) {
			sb.append(value);
			for (int i = 0; i < maxWidth - len; i++)
				sb.append(" ");
		} else {
			for (int i = 0; i < maxWidth - len; i++)
				sb.append(" ");
			sb.append(value);
		}
		return sb.toString();
	}
}
