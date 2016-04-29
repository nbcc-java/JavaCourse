/**
 * 所属包：cn.nbcc.chap03.snippets
 * 文件名：StudentAnonymousClassAppSnippet.java
 * 创建者：郑哲
 * 创建时间：2014-10-2 下午11:39:36
 */
package cn.nbcc.chap03.snippets;
public class Student {
	public Address homeAddress;
	public Address schoolAddress;
	class Address{
		String city;
		String postCode;
		Address(String c,String pCode)
		{
			city = c;
			postCode=pCode;
		}
	}
}


