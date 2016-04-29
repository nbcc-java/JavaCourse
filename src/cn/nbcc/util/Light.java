/**
 * 所属包：cn.nbcc.util
 * 文件名：Light.java
 * 创建者：郑哲
 * 创建时间：2014-4-21 上午10:04:28
 */
package cn.nbcc.util;
public class Light{
	boolean status;	//每盏灯（每个实例）都有一个状态
	String name;
	
	public Light(String name)
	{
		this.name = name;
	}
	
	public void printStatus()
	{
		System.out.println(getStatus()?name+"打开":name+"关闭");
	}

	//让客户端查询当前这盏灯的状态
	public boolean getStatus()
	{
		return status;
	}

	//关灯
	public void off(){
		status = false;//false为关
	}

	//开灯
	public void on(){
		status = true;//true为开
	}
}

