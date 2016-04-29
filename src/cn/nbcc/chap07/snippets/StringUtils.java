/**
 * 所属包：cn.nbcc.chap07.snippets
 * 文件名：StringUtil.java
 * 创建者：郑哲
 * 创建时间：2014-2-12 下午07:28:28
 */
package cn.nbcc.chap07.snippets;
public class StringUtils {
	  private StringUtils() {}

	  // pad with " " to the right to the given length (n)
	  public static String padRight(String s, int n) {
	    return String.format("%1$-" + n + "s", s);
	  }

	  // pad with " " to the left to the given length (n)
	  public static String padLeft(String s, int n) {
	    return String.format("%1$" + n + "s", s);
	  }

	  public static void main(String args[]) throws Exception {
	    System.out.println(StringUtils.padRight("Howto", 20) + "*");
	    System.out.println(StringUtils.padLeft("Howto", 20) + "*");
	    
		System.out.println(String.format("%10s", "howto").replace(' ', '*'));
		System.out.println(String.format("%-10s", "howto").replace(' ', '*'));

	    /*  output

	    *****howto
	    howto*****

	    */
	  }

	  /* output

	Howto               *
	               Howto*

	  */
	}
