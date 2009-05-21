package net.fly78.dafei1288.chattest;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class Dgram {
	public static DatagramPacket toDatagram(String s, InetAddress destIA,
			int destPort) {
		byte buf[] = s.trim().getBytes();
		// byte[] buf = new byte[s.length()];
		// s.getBytes(0, s.length(), buf, 0);
		// 构造数据报包，用来将长度为 length 的包发送到指定主机上的指定端口号。
		return new DatagramPacket(buf, buf.length, destIA, destPort);
	}

	public static String toString(DatagramPacket p) {

		return new String(p.getData(), 0, p.getLength());
	}
}
