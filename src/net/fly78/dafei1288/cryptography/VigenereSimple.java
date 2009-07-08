package net.fly78.dafei1288.cryptography;

public class VigenereSimple {
	
	public static String getEncryptedPhrase (String plaintext, String key){
		StringBuffer sb = new StringBuffer();
		
		if(key==null||key.length()==0){
			throw new RuntimeException("key is not aviliable");
		}
		
		StringBuffer tempKey = new StringBuffer();
		int tkl = 0;
		int pl = plaintext.length();
		int kl = key.length();
		for(int i=0;i<pl;i++){
			tempKey.append(key.charAt(i%kl));
		}
		System.out.println("key==>"+tempKey.toString());
		
		for(int i=0;i<pl;i++){
			char p = plaintext.charAt(i);
			char k = tempKey.charAt(i);
			System.out.println(p+"->"+(int)p);
			System.out.println(k+"->"+(int)k);
			char e = (char) ('a'+( ((int)p-97+(int)k-97) % 26));
//			if(e>122){
//				e = (char) (97+(int)e-122);
//			}
			//UWTULFOIHKETAPKGNBA
			//char e = (char) (( (int)p+((int)k) %26));
			sb.append(""+e);
			System.out.println((int)e+"->"+e);
			System.out.println("");
		}
		
		
		return sb.toString();	
	}
	
	
	public static String getPhrase (String ciphertext, String key){
		StringBuffer sb = new StringBuffer();
		
		if(key==null||key.length()==0){
			throw new RuntimeException("key is not aviliable");
		}
		
		StringBuffer tempKey = new StringBuffer();
		int tkl = 0;
		int pl = ciphertext.length();
		int kl = key.length();
		for(int i=0;i<pl;i++){
			tempKey.append(key.charAt(i%kl));
		}
		System.out.println("key==>"+tempKey.toString());
		
		for(int i=0;i<pl;i++){
			char c = ciphertext.charAt(i);
			char k = tempKey.charAt(i);
			System.out.println(c+"->"+(int)c);
			System.out.println(k+"->"+(int)k);
			char e = (char) ('a'+(( ((int)c-(int)k) % 26)+26)%26);
			sb.append(""+e);
			System.out.println((int)e+"->"+e);
			System.out.println("");
		}
		
		
		return sb.toString();	
	}
	
	public static void main(String[] args) {
		;
		//System.out.println(VigenereSimple.getEncryptedPhrase("iwanttopassthisunit", "maths"));
		//uwtulfoihketapkgnba
		System.out.println(VigenereSimple.getPhrase("uwtulfoihketapkgnba", "maths"));
	}

}
