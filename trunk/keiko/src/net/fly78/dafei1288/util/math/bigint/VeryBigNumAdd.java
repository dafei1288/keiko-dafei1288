package net.fly78.dafei1288.util.math.bigint;

public class VeryBigNumAdd {   
	  
    public static void main(String[] args) {   
        VeryBigNumAdd vbn = new VeryBigNumAdd();   
        String a = "123453243455535634535252345234677576252241234123523453664563634";   
        String b = "123453243455535634535252345234677576252241234123523453664563634";   
        String result = vbn.doAdd(a, b);   
        System.out.println("result:" + result);   
    }   
  
    String doAdd(String a, String b) {   
        String str = "";   
        int lenA = a.length();   
        int lenB = b.length();   
        int maxLen = (lenA > lenB) ? lenA : lenB;   
        int minLen = (lenA < lenB) ? lenA : lenB;   
        String strTmp = "";   
        for (int i = maxLen - minLen; i > 0; i--) {   
            strTmp += "0";   
        }   
        // 把长度调整到相同   
        if (maxLen == lenA) {   
            b = strTmp + b;   
        } else  
            a = strTmp + a;   
        int JW = 0;// 进位   
        for (int i = maxLen - 1; i >= 0; i--) {   
            int tempA = Integer.parseInt(String.valueOf(a.charAt(i)));   
            int tempB = Integer.parseInt(String.valueOf(b.charAt(i)));   
            int temp;   
            if (tempA + tempB + JW >= 10 && i != 0) {   
                temp = tempA + tempB + JW - 10;   
                JW = 1;   
            } else {   
                temp = tempA + tempB + JW;   
                JW = 0;   
            }   
            str = String.valueOf(temp) + str;   
        }   
        return str;   
    }   
}   
