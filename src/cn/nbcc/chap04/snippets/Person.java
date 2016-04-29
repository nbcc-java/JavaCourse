/**
 * 所属包：cn.nbcc.chap04.snippets
 * 文件名：Person.java
 * 创建者：郑哲
 * 创建时间：2014-5-2 上午11:03:02
 */
package cn.nbcc.chap04.snippets;
public class Person implements ISpeakable{
	
	private String name;
	
	public Person(String name) {
		super();
		this.name = name;
	}
	
	public void drive(Horse aHorse){
		System.out.println(name+"骑"+aHorse.getName());
	}
	
	public void eat(IEatable food)
	{
		System.out.println(name+food.eatMethod());
	}

	/* (non-Javadoc)
	 * @see cn.nbcc.chap04.snippets.ISpeakable#speak()
	 */
	@Override
	public void speak() {
		System.out.println("说话");
		
	}
	

}

