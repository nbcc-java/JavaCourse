/**
 * ��������cn.nbcc.chap03.finished
 * �ļ�����Test.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-1 ����01:17:28
 */
package cn.nbcc.chap03.finished;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		
//		Runtime.getRuntime().exec("cmd /C date " + strDateToSet); // dd-MM-yy
		
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		try {
			Runtime.getRuntime().exec("cmd /C time " + "08:00:30");
		} catch (IOException e) {
			e.printStackTrace();
		} // hh:mm:ss

	}

}

