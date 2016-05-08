/**
 * ��������cn.nbcc.chap04.snippets.inner
 * �ļ�����Person.java
 * �����ߣ�֣��
 * ����ʱ�䣺2016��5��8�� ����9:06:47
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
		String city;		//���ڳ���
		String postCode;	//�ʱ�
		Address(String c,String p){
			this.city = c;
			this.postCode = p;
		}
		@Override
		public String toString() {
			return String.format("%s ���ڳ�����:%s,�ʱ���:%s", Person.this.name,city,postCode);
		}
	}
	public static void main(String[] args) {
		Person p = new Person("p1");
//		p.address = new Address("����", "315021");
		p.address = p.new Address("����", "315021");
		System.out.println(p.address);
	}
}

