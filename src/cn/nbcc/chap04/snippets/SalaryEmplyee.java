/**
 * 所属包：cn.nbcc.chap04.snippets
 * 文件名：SalaryEmplyee.java
 * 创建者：郑哲
 * 创建时间：2014-5-2 上午08:55:09
 */
package cn.nbcc.chap04.snippets;
public class SalaryEmplyee extends Employee {

	private double salary =3500;
	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	/**
	 * @param number
	 * @param name
	 */
	public SalaryEmplyee(String number, String name) {
		super(number, name);
	}
	public double computePay(){
		return salary;
	}
}

