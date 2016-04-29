/**
 * 所属包：cn.nbcc.chap05.snippets
 * 文件名：Student.java
 * 创建者：郑哲
 * 创建时间：2014-5-14 上午09:39:47
 */
package cn.nbcc.chap05.snippets;
public class Student {
	
	private String name;
	
	public Student(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}
	

}

