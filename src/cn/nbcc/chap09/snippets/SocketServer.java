/**
 * 所属包：cn.nbcc.chap09.snippets
 * 文件名：SocketServer.java
 * 创建者：郑哲
 * 创建时间：2014-5-24 下午01:54:09
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
			System.out.println("服务器>>成功打开本地端口2244");
			Socket sock = ssock.accept();
			System.out.println("服务器>>获取客户端 socket连接");
			communicateWithClient(sock);
			System.out.println("服务器>>关闭socket");
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
			out.println("服务器收到消息：");
			while ((s = in.readLine()) != null) {
				System.out.println("消息来自客户端:" + s);
				out.println("服务器收到一条消息");
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
