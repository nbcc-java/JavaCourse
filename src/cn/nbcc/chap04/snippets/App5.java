/**
 * 所属包：cn.nbcc.chap04.snippets
 * 文件名：App5.java
 * 创建者：郑哲
 * 创建时间：2014-5-5 上午10:41:58
 */
package cn.nbcc.chap04.snippets;
public class App5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		ISpeakable[] arr = new ISpeakable[]{
//				new Chinese(),
//				new American(),
//				new Janpanese()
//		};
//		
//		for (int i = 0; i < arr.length; i++) {
//			arr[i].speak();	//面向抽象编程，多态，编译器根据绑定的对象动态调用相应方法
//			//接口符合里氏替换原则，
//		}
		
		
		Person p = new Person("张三");
//		p.eat(new Apple());
		
		
		p.eat(new IEatable() {   //匿名
			
			@Override
			public String eatMethod() {
				return "煮了吃";
			}
		}); //接口的好处易于扩展
		
		
		
		

	}

}

