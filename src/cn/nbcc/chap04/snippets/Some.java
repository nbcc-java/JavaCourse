/**
 * 所属包：cn.nbcc.chap04.snippets
 * 文件名：Some.java
 * 创建者：郑哲
 * 创建时间：2014-5-5 上午09:44:44
 */
package cn.nbcc.chap04.snippets;
public class Some extends Object{
	int n;
	
	public Some() {
		n=1;
	}
	public void doService() {
		System.out.println("some service");
	}
	
	/**
	 * public：类自身，包内访问，包外能访问
	 * private：类自身
	 * protected：能被子类访问，类自身
	 * default:包内访问，类自身
	 */

}

