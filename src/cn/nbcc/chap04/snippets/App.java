/**
 * 所属包：cn.nbcc.chap04.snippets
 * 文件名：App.java
 * 创建者：郑哲
 * 创建时间：2014-5-2 上午09:00:31
 */
package cn.nbcc.chap04.snippets;

import java.io.*;

public class App {

	public static void main(String[] args) {
		
		SalaryEmplyee s1 = new SalaryEmplyee("001", "张三");
//		System.out.println(s1.computePay());
		
		HourlyEmployee h1 = new HourlyEmployee("002", "李四");
//		System.out.println(h1.computePay());
		h1.setHoulyRate(100);
		h1.setHoulyWorked(240);
//		System.out.println(h1.computePay());
		
		System.out.println(h1);
		
	}

}

