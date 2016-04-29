/**
 * 所属包：cn.nbcc.chap04.entities
 * 文件名：Teacher.java
 * 创建者：郑哲
 * 创建时间：2014-2-8 下午04:04:59
 */
package cn.nbcc.chap04.entities;
public class Teacher extends User {

	public Teacher(String id, String name) {
		super(id, name);
	}
	@Override
	public void login() {
		super.login();
		System.out.println("切换到教师视图界面");
	}
}

