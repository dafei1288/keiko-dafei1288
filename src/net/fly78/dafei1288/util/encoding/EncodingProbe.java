package net.fly78.dafei1288.util.encoding;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class EncodingProbe {
	
	
	
	public static void probe(String str){
		List<String> codelist = new ArrayList<String>();
		codelist.add("");
		for(String code : new Encoding().htmlname){
			codelist.add(code);
		}
		
		ParseEncoding pe = new ParseEncoding();
		
		System.out.println();
		System.out.println("**************************************************");
		System.out.println("input : "+str +"   \t maybe encoding : "+pe.getEncoding(str.getBytes()));
		for(String code:codelist){
			String temp;
			try {
				temp = new String(str.getBytes(),code);
				System.out.println("\t" + " ==> " + code +" : "+temp);
			} catch (UnsupportedEncodingException e) {
				//e.printStackTrace();
			}
			
		}
		for(String code:codelist){
			String temp;
			try {
				temp = new String(str.getBytes(code));
				System.out.println(code+ " ==> " + "\t"  +" : "+temp);
			} catch (UnsupportedEncodingException e) {
				//e.printStackTrace();
			}
			
		}
		for(String codeOutside : codelist){
			for(String codeInside : codelist){
				try {
					String temp = new String(str.getBytes(codeOutside),codeInside);
					System.out.println(codeOutside + " ==> " + codeInside +" : "+temp);
				} catch (UnsupportedEncodingException e) {
					//e.printStackTrace();
				}
			}
		}
		System.out.println();
		
		
		
		
	}
	

	public static void main(String[] args){
		EncodingProbe.probe("打飞 ");
		
	}
}
