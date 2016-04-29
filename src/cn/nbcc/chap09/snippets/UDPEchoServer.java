/**
 * 所属包：cn.nbcc.chap09.snippets
 * 文件名：UDPEchoServer.java
 * 创建者：郑哲
 * 创建时间：2014-5-26 上午11:14:26
 */
package cn.nbcc.chap09.snippets;
import java.net.*;
import java.io.*;

public class UDPEchoServer {
  protected int port;

  public UDPEchoServer (int port) {
    this.port = port;
  }

  public void execute () throws IOException {
    DatagramSocket socket = new DatagramSocket (port);
    while (true) {
      DatagramPacket packet = receive (socket);
      if (Math.random () < .9) {
        sendEcho (socket, packet);
      } else {
        System.out.println ("Dropped!");
      }
    }
  }

  protected DatagramPacket receive (DatagramSocket socket) throws IOException {
    byte buffer[] = new byte[65508];
    DatagramPacket packet = new DatagramPacket (buffer, buffer.length);
    socket.receive (packet);
    return packet;
  }

  protected void sendEcho (DatagramSocket socket, DatagramPacket packet) throws IOException {
    DatagramPacket response = new DatagramPacket
      (packet.getData (), packet.getLength (),
       packet.getAddress (), packet.getPort ());
    socket.send (response);
  }

  public static void main (String[] args) throws IOException {
    if (args.length != 1)
      throw new IllegalArgumentException ("Syntax: UDPEchoServer <port>");
    UDPEchoServer server = new UDPEchoServer (Integer.parseInt (args[0]));
    server.execute ();
  }
}
