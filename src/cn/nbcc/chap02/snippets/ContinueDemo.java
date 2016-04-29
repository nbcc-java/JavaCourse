/**
 * 所属包：cn.nbcc.chap02.snippets
 * 文件名：ContinueDemo.java
 * 创建者：郑哲
 * 创建时间：2014-2-4 上午12:48:12
 */
package cn.nbcc.chap02.snippets;
public class ContinueDemo {
	public static void main(String[] args) {
		// continue使用示例.
		for (int count = 1; count <= 10; count++) { // 循环10次
			if (count == 5)// 如果count等于5
				continue;// 跳过循环中的剩余代码，直接转到下一次更新区域
			System.out.println(count);
		}// end for
	}
}
