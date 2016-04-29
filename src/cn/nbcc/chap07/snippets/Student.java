/**
 * 所属包：cn.nbcc.chap07.snippets
 * 文件名：Student.java
 * 创建者：郑哲
 * 创建时间：2014-5-28 上午11:14:05
 */
package cn.nbcc.chap07.snippets;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = -6660389868596838378L;
	String name="张三";
	transient int age=24;
	
	public String toString() {
		return name+","+age;
	}
}

