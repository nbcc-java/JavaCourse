/**
 * ��������cn.nbcc.chap09.snippets
 * �ļ�����UDP.java
 * �����ߣ�֣��
 * ����ʱ�䣺2014-5-26 ����11:19:01
 */
package cn.nbcc.chap09.snippets;

import java.net.*; 
import java.io.*; 

public class UDPEchoClientTimeout {
	// ���·���ʱ��(����)
	private static final int TIMEOUT = 3000;
	// ������Դ���
	private static final int MAXTRIES = 5;

	public static void main(String[] args) throws IOException {
		if ((args.length < 2) || (args.length > 3)) 
			throw new IllegalArgumentException(
					"Parameter(s): <Server> <Word> [<Port>]");
		// ��������ַ
		InetAddress serverAddress = InetAddress.getByName(args[0]); 
		int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;
		DatagramSocket socket = new DatagramSocket();
		socket.setSoTimeout(TIMEOUT); //����ʱ�������ʱ��(milliseconds)
		for (int num = 0; num < 9001; num++) {
			byte[] bytesToSend = String.format("%4d. %s", num + 1, args[1])
					.getBytes();
			// ���ͷ���
			DatagramPacket sendPacket = new DatagramPacket(bytesToSend, 
					bytesToSend.length, serverAddress, servPort);
			DatagramPacket receivePacket = // ���ܷ���
			new DatagramPacket(new byte[bytesToSend.length], bytesToSend.length);
			int tries = 0; // ��������ʧ�����ϳ���
			boolean receivedResponse = false;
			do {
				socket.send(sendPacket); // ���ͻ����ַ���
				try {
					//���Ի��Իظ���Ϣ
					socket.receive(receivePacket); 
					//���Դ
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
