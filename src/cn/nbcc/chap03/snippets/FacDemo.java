/**
 * ��������cn.nbcc.chap03.snippets
 * �ļ�����Fac.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-7 ����02:01:53
 */
package cn.nbcc.chap03.snippets;
public class FacDemo {

	public static void main(String[] args) {
		long ret = 0L;
		ret = factorial(3);
		System.out.println(ret);
	}
	public static long factorial( long number )          
	{                                             
	     // �������                               
	     if ( number <= 1 )                         
	        return 1;                               
	     // �ݹ鲽��                          
	    else                                       
	        return number * factorial( number - 1 );
	} // end method factorial                     

}

