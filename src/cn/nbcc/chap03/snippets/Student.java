/**
 * ��������cn.nbcc.chap03.snippets
 * �ļ�����StudentAnonymousClassAppSnippet.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-10-2 ����11:39:36
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


