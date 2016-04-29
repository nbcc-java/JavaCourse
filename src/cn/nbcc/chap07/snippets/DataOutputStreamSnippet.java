/**
 * ��������cn.nbcc.chap07.snippets
 * �ļ�����DataOutputStream.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-2-12 ����11:21:51
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
	    "��ѧӢ������������",
	    "������ȼ����Է���",
	    "��У���Է���"
	};
	static final String dataFile = "C:\\���Ա�������.txt";
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
		        System.out.format("��������:%s\t����:%.2f\t��������:%d%n",desc,price,unit);
		    }
		} catch (EOFException e) {
		}finally{
			in.close();
		}
	}
}

