package net.fly78.dafei1288.util.string;

import java.util.List;

public class StringUtil {
	public static String List2String(List al){
		StringBuffer res = new StringBuffer();
		
		for(int i = 0;i<al.size();i++){
			if(i!=al.size()-1){
				res = res.append(al.get(i).toString()).append(',');
			}else{
				res = res.append(al.get(i).toString());
			}
		}
		
		
		
		return res.toString();
	}
	public static String Array2String(Object[] al){
		StringBuffer res = new StringBuffer();
		
		for(int i = 0;i<al.length;i++){
			if(i!=al.length-1){
				res = res.append(al[i].toString()).append(',');
			}else{
				res = res.append(al[i].toString());
			}
		}
		
		
		
		return res.toString();
	}
	
}
