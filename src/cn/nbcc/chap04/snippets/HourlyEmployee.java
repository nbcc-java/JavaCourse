/**
 * ��������cn.nbcc.chap04.snippets
 * �ļ�����HourlyEmployee.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-2 ����09:02:15
 */
package cn.nbcc.chap04.snippets;
public class HourlyEmployee extends Employee {

	private double houlyRate;
	/**
	 * @return the houlyRate
	 */
	public double getHoulyRate() {
		return houlyRate;
	}
	/**
	 * @param houlyRate the houlyRate to set
	 */
	public void setHoulyRate(double houlyRate) {
		this.houlyRate = houlyRate;
	}
	/**
	 * @return the houlyWorked
	 */
	public double getHoulyWorked() {
		return houlyWorked;
	}
	/**
	 * @param houlyWorked the houlyWorked to set
	 */
	public void setHoulyWorked(double houlyWorked) {
		this.houlyWorked = houlyWorked;
	}
	private double houlyWorked;
	/**
	 * @param number
	 * @param name
	 */
	public HourlyEmployee(String number, String name) {
		super(number, name);
		setHoulyRate(8);
		setHoulyWorked(8);
	}
	
	public double computePay(){
		return houlyRate*houlyWorked;
	}

}

