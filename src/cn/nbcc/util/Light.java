/**
 * ��������cn.nbcc.util
 * �ļ�����Light.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-4-21 ����10:04:28
 */
package cn.nbcc.util;
public class Light{
	boolean status;	//ÿյ�ƣ�ÿ��ʵ��������һ��״̬
	String name;
	
	public Light(String name)
	{
		this.name = name;
	}
	
	public void printStatus()
	{
		System.out.println(getStatus()?name+"��":name+"�ر�");
	}

	//�ÿͻ��˲�ѯ��ǰ��յ�Ƶ�״̬
	public boolean getStatus()
	{
		return status;
	}

	//�ص�
	public void off(){
		status = false;//falseΪ��
	}

	//����
	public void on(){
		status = true;//trueΪ��
	}
}

