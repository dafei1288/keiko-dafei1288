package net.fly78.dafei1288.game;

import java.util.Hashtable;

public class Battle {
	public static final Integer ATT = new Integer("1");
	public static final Integer DEF = new Integer("2");
	
	
	public  Hashtable<Integer,IBaseMode> exceute(IAttrikeMode att,IDefendMode def){
		Hashtable<Integer,IBaseMode> ht = new Hashtable<Integer,IBaseMode>();
		
		
		
		
		ht.put(ATT, att);
		ht.put(DEF, def);
		return ht;
	}
	
	
}
