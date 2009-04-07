package net.fly78.dafei1288.util.math.bigint;

public class BigInt {   
	  
    public static void main(String[] args) {   
        BigInt b = new BigInt();   
        b.add("911111111111111111111111111111111111111111111111199", "91111111111111111111111111111111111111199");   
    }   
  
    public String add(String a, String b) {   
        //检查输入   
        if (!a.matches("\\d+") || !a.matches("\\d+")) {   
            return null;   
        }   
        final int BASE = 10;//10进制   
        int lenA = a.length();//加数的长度   
        int lenB = b.length();//被加数的长度   
        int maxLen, partialSum, carry = 0;//大数的长度，和，进位   
        maxLen = (lenA > lenB) ? lenA : lenB;   
        StringBuffer sum = new StringBuffer();   
        int temA, temB = 0;   
        for (int i = 0; i < maxLen; i++) {   
            if (i >= lenA) {   
                temA = 0;   
            } else {   
                temA = Integer.valueOf(a.charAt(lenA - i - 1) - 48);   
            }   
            if (i >= lenB) {   
                temB = 0;   
            } else {   
                temB = Integer.valueOf(b.charAt(lenB - i - 1) - 48);   
            }   
            partialSum = temA + temB + carry;   
            carry = partialSum / BASE;   
            sum.append(partialSum % BASE);   
        }   
        if (carry == 1)   
            sum.append(carry);   
        System.out.println(a + "+" + b + "=" + sum.reverse().toString());   
        return sum.reverse().toString();   
    }   
}   

