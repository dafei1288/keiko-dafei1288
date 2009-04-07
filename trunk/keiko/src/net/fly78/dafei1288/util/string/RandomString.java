package net.fly78.dafei1288.util.string;

import java.util.Random;

public class RandomString {
	 Random m_rnd = new Random();
     public char getRandomChar() {
         int ret = m_rnd.nextInt(122);
         while (ret < 48 || (ret > 57 && ret < 65) || (ret > 90 && ret < 97)) {
             ret = m_rnd.nextInt(122);
         }
         return (char)ret;
     }
     public String getRandomString(int length) {
         StringBuilder sb = new StringBuilder(length);
         char[] ch = new char[length];
         for (int i = 0; i < length; i++) {
        	 ch[i] = this.getRandomChar();
         }
         sb.append(ch);
         return sb.toString();
     }
}
