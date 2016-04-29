/**
 * ��������cn.nbcc.chap04.snippets
 * �ļ�����Person.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-2 ����11:03:02
 */
package cn.nbcc.chap04.snippets;
public class Person implements ISpeakable{
	
	private String name;
	
	public Person(String name) {
		super();
		this.name = name;
	}
	
	public void drive(Horse aHorse){
		System.out.println(name+"��"+aHorse.getName());
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
		System.out.println("˵��");
		
	}
	

}

