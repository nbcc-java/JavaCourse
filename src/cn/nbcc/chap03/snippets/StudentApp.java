/**
 * 所属包：cn.nbcc.chap03.snippets
 * 文件名：StudentAnonymousClassAppSnippet.java
 * 创建者：郑哲
 * 创建时间：2014-10-2 下午11:39:36
 */
package cn.nbcc.chap03.snippets;
public class StudentApp {
	public static void main(String[] args) {
		Student s = new Student();
		Student.Address sAddr = s.new Address("浙江宁波","315000");
		s.schoolAddress=sAddr;
	}
}

