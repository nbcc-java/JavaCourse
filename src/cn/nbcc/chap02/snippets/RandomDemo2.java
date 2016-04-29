/**
 * 所属包：cn.nbcc.chap02.snippets
 * 文件名：RandomDemo.java
 * 创建者：郑哲
 * 创建时间：2014-2-4 下午07:58:35
 */
package cn.nbcc.chap02.snippets;

import java.util.Random;

public class RandomDemo2 {
	public static void main(String[] args) {
		
		final long seed = 100L;
		Random random1 = new Random(seed);
		boolean flips = random1.nextBoolean();
		if (flips) {
			//True代表硬币正面
			System.out.println("正面");
		}else {
			System.out.println("背面");
		}
		//使用系统时钟作为种子再生成随机序列
		Random random2 = new Random();
		flips = random2.nextBoolean();
		if (flips) {
			//True代表硬币正面
			System.out.println("正面");
		}else {
			System.out.println("背面");
		}
	}
}

