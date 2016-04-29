/**
 * 所属包：cn.nbcc.chap03.snippets
 * 文件名：Fac.java
 * 创建者：郑哲
 * 创建时间：2014-2-7 下午02:01:53
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
	     // 基本情况                               
	     if ( number <= 1 )                         
	        return 1;                               
	     // 递归步骤                          
	    else                                       
	        return number * factorial( number - 1 );
	} // end method factorial                     

}

