/**
 * ��������cn.nbcc.chap09.snippets
 * �ļ�����SocketServer.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-24 ����01:54:09
 */
package cn.nbcc.chap09.snippets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static void main(String a[]) {
		final int httpd = 2244;
		ServerSocket ssock = null;
		try {
			ssock = new ServerSocket(httpd);
			System.out.println("������>>�ɹ��򿪱��ض˿�2244");
			Socket sock = ssock.accept();
			System.out.println("������>>��ȡ�ͻ��� socket����");
			communicateWithClient(sock);
			System.out.println("������>>�ر�socket");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				ssock.close();
			} catch (IOException ex) {
				System.out.println(ex);
			}
		}
	}

	public static void communicateWithClient(Socket socket) {
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			String s = null;
			out.println("�������յ���Ϣ��");
			while ((s = in.readLine()) != null) {
				System.out.println("��Ϣ���Կͻ���:" + s);
				out.println("�������յ�һ����Ϣ");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
