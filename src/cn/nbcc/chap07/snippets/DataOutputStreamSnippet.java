/**
 * 所属包：cn.nbcc.chap07.snippets
 * 文件名：DataOutputStream.java
 * 创建者：郑哲
 * 创建时间：2014-2-12 下午11:21:51
 */
package cn.nbcc.chap07.snippets;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class DataOutputStreamSnippet {
	static final double[] prices = { 120.00, 83.00,300.51 };
	static final int[] units = { 50, 49,70 };
	static final String[] descs = {
	    "大学英语四六级费用",
	    "计算机等级考试费用",
	    "驾校考试费用"
	};
	static final String dataFile = "C:\\考试报名费用.txt";
	public static void main(String[] args) throws IOException {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
	              new FileOutputStream(dataFile)));
		for (int i = 0; i < prices.length; i ++) {
		    out.writeDouble(prices[i]);
		    out.writeInt(units[i]);
		    out.writeUTF(descs[i]);
		}
		out.flush();
		out.close();
		DataInputStream in = new DataInputStream(new
	            BufferedInputStream(new FileInputStream(dataFile)));
		try {
		    while (true) {
		    	double price = in.readDouble();
		    	int unit = in.readInt();
		         String desc = in.readUTF();
		        System.out.format("考试名称:%s\t费用:%.2f\t报名人数:%d%n",desc,price,unit);
		    }
		} catch (EOFException e) {
		}finally{
			in.close();
		}
	}
}

