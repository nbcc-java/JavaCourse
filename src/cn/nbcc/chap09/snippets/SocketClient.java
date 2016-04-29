/**
 * ��������cn.nbcc.chap09.snippets
 * �ļ�����SocketClient.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-24 ����01:50:52
 */
package cn.nbcc.chap09.snippets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
public class SocketClient {
	public static Socket socket = null;
	public static PrintWriter out;
	public static BufferedReader in;
	public static void main(String[] args) {
		createConnection("127.0.0.1", 2244);
	}
	public static void createConnection(String host, int port) {
		try {
			socket = new Socket(host, port);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			testConnection();
			System.out.println("�ͻ���>>�ر�����...");
			out.flush();
			out.close();
			in.close();
			socket.close();
			System.exit(0);
		} catch (UnknownHostException e) {
			System.out.println(e);
			System.exit(1);
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
	}
	public static void testConnection() {
		String serverResponse = null;
		if (socket != null && in != null && out != null) {
			System.out.println("�ͻ���>>���ӳɹ�, ��ʼ��������...");
			try {
				out.println("��������A.");
				while ((serverResponse = in.readLine()) != null)
					System.out.println(serverResponse);
			} catch (IOException e) {
				System.out.println(e);
				System.exit(1);
			}
		}
	}
}
