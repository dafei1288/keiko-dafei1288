package net.fly78.dafei1288.cryptography;

import java.io.*;

public class Caesar {
	public static void encode(String PlainText, int Offset) {
		String CipherText = "";
		for (int i = 0; i < PlainText.length(); i++) {
			if (PlainText.charAt(i) >= 'a' && PlainText.charAt(i) <= 'z')
				CipherText += (char) ('a' + ((PlainText.charAt(i) - 'a' + Offset) % 26));
			else if (PlainText.charAt(i) >= 'A' && PlainText.charAt(i) <= 'Z')
				CipherText += (char) ('A' + ((PlainText.charAt(i) - 'A' + Offset) % 26));
			else if (PlainText.charAt(i) >= '0' && PlainText.charAt(i) <= '9')
				CipherText += (char) ('0' + ((PlainText.charAt(i) - '0' + Offset) % 10));
			else 
				CipherText += PlainText.charAt(i);
		}
		System.out.println("Ciphertext: " + CipherText);
	}

	public static void decode(String CipherText, int Offset) {
		String PlainText = "";
		for (int i = 0; i < CipherText.length(); i++) {
			if (CipherText.charAt(i) >= 'a' && CipherText.charAt(i) <= 'z')
				PlainText += (char) ('a' + ((CipherText.charAt(i) - 'a' - Offset) % 26));
			else if (CipherText.charAt(i) >= 'A' && CipherText.charAt(i) <= 'Z')
				PlainText += (char) ('A' + ((CipherText.charAt(i) - 'A' - Offset) % 26));
			else if (CipherText.charAt(i) >= '0' && CipherText.charAt(i) <= '9')
				PlainText += (char) ('0' + ((CipherText.charAt(i) - '0' - Offset) % 10));
			else 
				PlainText += CipherText.charAt(i);
		}
		System.out.println("PlainText: " + PlainText);
	}
	public static void cipherTable(int Offset,String password){
		
		System.out.print("PlainText:");
		for (int i=0;i<=255;i++){
			System.out.print((char)i);
		}
		
		System.out.println();
		System.out.print("CipherText:");
		String CipherText = "";
		for (int i=0;i<=255;i++){
			if ((char)i >= 'a' && (char)i <= 'z')
				CipherText += (char) ('a' + (((char)i - 'a' + Offset) % 26));
			else if ((char)i >= 'A' && (char)i <= 'Z')
				CipherText += (char) ('A' + (((char)i - 'A' + Offset) % 26));
			else if ((char)i >= '0' && (char)i <= '9')
				CipherText += (char) ('0' + (((char)i - '0' + Offset) % 10));
			else 
				CipherText += (char)i;
		}
		System.out.print(CipherText);
	}
	public static void main(String[] args) {
		
		//Caesar.cipherTable(3,"");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			System.out
					.print("What to you want to do? (E)ncode or Decode?[e/d]");
			String action = br.readLine();
			System.out.print("Please input offset value: ");
			int offset = Integer.valueOf(br.readLine());
			System.out.print("Please input the ");
			if (action.equalsIgnoreCase("d")) {
				System.out.print("ciphertext: ");
				decode(br.readLine(), offset);
			} else {
				System.out.print("plaintext: ");
				encode(br.readLine(), offset);
			}
			System.out.println("Press ENTER...");
			System.in.read();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
