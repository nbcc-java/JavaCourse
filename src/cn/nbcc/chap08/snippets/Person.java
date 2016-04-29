/**
 * 所属包：cn.nbcc.chap08.snippets
 * 文件名：Person.java
 * 创建者：郑哲
 * 创建时间：2015-5-29 下午04:38:30
 */
package cn.nbcc.chap08.snippets;
public class Person implements Runnable{
	
	int curNum = 1;
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	/**
	 * 报数
	 */
	public void numberOff() {
		System.out.println(name+"say："+curNum);
		curNum=(curNum++%10)+1;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (condition) {
			
		}
	}

}

