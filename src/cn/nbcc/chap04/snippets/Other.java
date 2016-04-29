/**
 * 所属包：cn.nbcc.chap04.snippets
 * 文件名：Other.java
 * 创建者：郑哲
 * 创建时间：2014-5-5 上午09:45:21
 */
package cn.nbcc.chap04.snippets;
public class Other extends Some {
	int n;
	
	public Other() {
		n=2;
	}
	public void doService() {
		super.doService();
	}
	
	public void doOtherService() {
		System.out.println("Do other service");
	}
	
	public static void main(String[] args) {
		Some some = new Other();
		System.out.println(some.n);
		
		
//		some.doService();			//动态绑定，编译器在执行期根据实际绑定对象，动态选择调用相应方法
	}

}

