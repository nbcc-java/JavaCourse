/**
 * 所属包：cn.nbcc.chap09.snippets
 * 文件名：UDP.java
 * 创建者：郑哲
 * 创建时间：2014-5-26 上午11:19:01
 */
package cn.nbcc.chap09.snippets;

import java.net.*; 
import java.io.*; 

public class UDPEchoClientTimeout {
	// 重新发送时长(毫秒)
	private static final int TIMEOUT = 3000;
	// 最大重试次数
	private static final int MAXTRIES = 5;

	public static void main(String[] args) throws IOException {
		if ((args.length < 2) || (args.length > 3)) 
			throw new IllegalArgumentException(
					"Parameter(s): <Server> <Word> [<Port>]");
		// 服务器地址
		InetAddress serverAddress = InetAddress.getByName(args[0]); 
		int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;
		DatagramSocket socket = new DatagramSocket();
		socket.setSoTimeout(TIMEOUT); //接受时最大阻塞时长(milliseconds)
		for (int num = 0; num < 9001; num++) {
			byte[] bytesToSend = String.format("%4d. %s", num + 1, args[1])
					.getBytes();
			// 发送分组
			DatagramPacket sendPacket = new DatagramPacket(bytesToSend, 
					bytesToSend.length, serverAddress, servPort);
			DatagramPacket receivePacket = // 接受分组
			new DatagramPacket(new byte[bytesToSend.length], bytesToSend.length);
			int tries = 0; // 分组若丢失，不断尝试
			boolean receivedResponse = false;
			do {
				socket.send(sendPacket); // 发送回显字符串
				try {
					//尝试回显回复信息
					socket.receive(receivePacket); 
					//检查源
					if (!receivePacket.getAddress().equals(serverAddress)) 
						throw new IOException(
								"Received packet from an unknown source");

					receivedResponse = true;
				} catch (InterruptedIOException e) { 
					tries += 1;
					System.out.println("Timed out, " + (MAXTRIES - tries)
							+ " more tries...");
				}
			} while ((!receivedResponse) && (tries < MAXTRIES));

			if (receivedResponse)
				System.out.println("Received: "
						+ new String(receivePacket.getData()));
			else
				System.out.println("No response -- giving up.");
		}
		socket.close();
	}
}
