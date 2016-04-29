/**
 * 所属包：cn.nbcc.chap04.snippets
 * 文件名：ConstructorInInheritance.java
 * 创建者：郑哲
 * 创建时间：2016年4月24日 下午5:32:50
 */
package cn.nbcc.chap04.snippets;
public class ConstructorInInheritance {
	
	class GrandParent {
		
		protected String name;
		
		public GrandParent(String name) {
			this.name = name;
		}
		
	}
//	class Parent extends GrandParent{
//		
//		//TODO: 必须添加父类的构造方法
//		
//	}
//	class Child extends Parent{
//		//TODO: 必须添加父类的构造方法
//	}

	public static void main(String[] args) {
//		Child c = new Child("王波");
	}
}

