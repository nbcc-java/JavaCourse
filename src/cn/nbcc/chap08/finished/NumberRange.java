/**
 * ��������cn.nbcc.chap08.finished
 * �ļ�����NumberRange.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-23 ����10:57:26
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
