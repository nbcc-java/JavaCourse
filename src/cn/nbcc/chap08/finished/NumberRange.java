/**
 * 所属包：cn.nbcc.chap08.finished
 * 文件名：NumberRange.java
 * 创建者：郑哲
 * 创建时间：2014-5-23 上午10:57:26
 */
package cn.nbcc.chap08.finished;
public class NumberRange {
	private int lower, upper;
	public int getLower() {
		return lower;
	}
	public int getUpper() {
		return upper;
	}
	public void setLower(int value) { 
	        if (value > upper) 
	            throw new IllegalArgumentException();
	        lower = value;
	}
	public void setUpper(int value) { 
	        if (value < lower) 
	            throw new IllegalArgumentException();
	        upper = value;
	}
}
