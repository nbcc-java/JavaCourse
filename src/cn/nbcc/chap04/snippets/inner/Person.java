/**
 * 所属包：cn.nbcc.chap04.snippets.inner
 * 文件名：Person.java
 * 创建者：郑哲
 * 创建时间：2016年5月8日 下午9:06:47
 */
package cn.nbcc.chap04.snippets.inner;
public class Person {
	private String name;
	private Address address;
	
	public Person(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	class Address{
		String city;		//所在城市
		String postCode;	//邮编
		Address(String c,String p){
			this.city = c;
			this.postCode = p;
		}
		@Override
		public String toString() {
			return String.format("%s 所在城市是:%s,邮编是:%s", Person.this.name,city,postCode);
		}
	}
	public static void main(String[] args) {
		Person p = new Person("p1");
//		p.address = new Address("宁波", "315021");
		p.address = p.new Address("宁波", "315021");
		System.out.println(p.address);
	}
}

