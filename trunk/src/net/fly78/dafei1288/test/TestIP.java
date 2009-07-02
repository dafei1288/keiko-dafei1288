package net.fly78.dafei1288.test;

import net.fly78.dafei1288.util.IP.IPSeeker;

public class TestIP {

	public static void main(String[] args) {
		IPSeeker seeker = IPSeeker.getInstance();
		String ip ="61.136.60.187";
		System.out.println(seeker.getAddress(ip));

	}
}
