package net.fly78.dafei1288.util.string;

public class Unicode2Chinese implements java.io.Serializable {

	public Unicode2Chinese() {
	}

	public static String toHEXString(byte b) {
		return ("" + "0123456789ABCDEF".charAt(0xf & b >> 4) + "0123456789ABCDEF"
				.charAt(b & 0xF));
	}

	public static String getUnicode(String setStr) {
		String szRet = "";
		String szRetTmp = null;
		String str = null;
		try {
			try {
				str = new String(setStr.getBytes("ISO-8859-1"), "GBK");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			byte[] bb = str.getBytes("UTF16");
			for (int i = 2; i < bb.length; i++) {
				i++;
				if (bb[i - 1] != 0)
					szRetTmp = "&#x" + toHEXString(bb[i - 1])
							+ toHEXString(bb[i]) + ";";
				else
					szRetTmp = new String(bb, i, 1, "GBK");
				szRet = szRet + szRetTmp;
			}
		} catch (Exception ex) {
			szRet = "Sorry    Convert2Unicode    method    fail!";
			ex.printStackTrace();
		}
		return szRet;
	}

	public static String getUnicode(String setStr, String encoding) {
		String str = null;
		try {
			str = new String(setStr.getBytes(encoding), "ISO-8859-1");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return getUnicode(str);
	}
	/*
	public static void main(String[] arg){
		;
		System.out.println(Unicode2Chinese.getUnicode("现在就来邀请", "utf-16")+"\u73b0\u5728\u5c31\u6765\u9080\u8bf7");
		//Unicode2Chinese.toHEXString("");
	}
	*/
}
