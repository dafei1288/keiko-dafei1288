package net.fly78.dafei1288.test;

import junit.framework.TestCase;
import net.fly78.dafei1288.exception.FormatRandomSpiltException;
import net.fly78.dafei1288.util.math.RandomAction;
import net.fly78.dafei1288.util.math.RandomPOJO;
import net.fly78.dafei1288.util.math.RandomPOJOList;
import net.fly78.dafei1288.util.math.RandomSpilt;

public class testBrick extends TestCase{
	public void testThrowBrick(){
		Atter atter = new Atter();
		Atter defer = new Atter();
		//进攻1W人
		atter.setNump(10000);
		//防守1W人
		defer.setNump(11000);
		
		//进攻命中率10%-40%
		atter.setCanAtt("35-45");
		//防御命中率10%-40%
		defer.setCanAtt("35-45");
		
		//进攻闪避率30%-60%
		atter.setCanAgi("25-35");
		//防守闪避率30%-60%
		defer.setCanAgi("25-35");
		
		//进攻,防守方攻击力 0.5-1.5
		atter.setBaceatt("9-15");
		defer.setBaceatt("9-15");
		int count = 1;
		do{
			
			System.out.println("");
			System.out.println("");
			System.out.println("*********************************");
			try {
				RandomSpilt rs = new RandomSpilt(atter.getBaceatt(),"-");
				
				System.out.println();
				
				
				
				RandomPOJOList rpl = new RandomPOJOList();
				RandomPOJO rp = new RandomPOJO();
				RandomPOJO rp1 = new RandomPOJO();
				/*进攻爆**/
				rp.setProperty(14);
				rp.setPower(1);
				
				rp1.setProperty(10);
				rp1.setPower(9);
				
				rpl.add(rp);
				rpl.add(rp1);
				
				RandomAction ra = new RandomAction(rpl);
				
				
				
				Integer ab = (Integer) ra.getNext().getProperty();
				
				
				
				
				
				
				int ac = rs.getNext();
				System.out.println("进攻房的攻击力随机数"+ac);
				
				rs.setProessString(atter.getCanAtt(), "-");
				int catat = rs.getNext();
				System.out.println("进攻房的命中随机数"+catat);
				
				rs.setProessString(atter.getCanAgi(), "-");
				int catag = rs.getNext();
				System.out.println("进攻房的闪避随机数"+catag);
				
				System.out.println();
				rs = new RandomSpilt(defer.getBaceatt(),"-");
				int dc = rs.getNext();
				System.out.println("防御房的攻击力随机数"+dc);
				
				rs.setProessString(defer.getCanAtt(), "-");
				int datat = rs.getNext();
				System.out.println("防御房的命中随机数"+datat);
				
				rs.setProessString(defer.getCanAgi(), "-");
				int datag = rs.getNext();
				System.out.println("防御房的闪避随机数"+datag);
				
				System.out.println();
				System.out.println("开始攻击第 "+ count++ +" 次");
				int aa = ac*atter.getNump()/10*catat/100*(100-datag)/100*ab/10;
				System.out.println("进攻实际攻击力:"+aa);
				if(ab.intValue()!=10){
					System.out.println("进攻方爆击了");
				}
				

				
				
				rpl = new RandomPOJOList();
				rp = new RandomPOJO();
				rp1 = new RandomPOJO();
				/*防爆**/
				rp.setProperty(14);
				rp.setPower(1);
				
				rp1.setProperty(10);
				rp1.setPower(9);
				
				rpl.add(rp);
				rpl.add(rp1);
				
				ra = new RandomAction(rpl);
				Integer db = (Integer) ra.getNext().getProperty();
				
				//防守原始人数
				int oden = defer.getNump();
				defer.setNump(defer.getNump()-aa);
				System.out.println("防御人数变成"+defer.getNump());
				
				System.out.println("防御还击");
				
				aa = dc*oden/10*datat/100*(100-catag)/100*db/10;
				System.out.println("防御实际攻击力:"+aa);
				if(db.intValue()!=10){
					System.out.println("防御方爆击了");
				}
				atter.setNump(atter.getNump()-aa);
				System.out.println("进攻人数变成"+atter.getNump());
				//System.out.println(count+"次进攻" );
				
			} catch (FormatRandomSpiltException e) {
				e.printStackTrace();
			}
		}while(atter.getNump()>=0 && defer.getNump()>=0);
		System.out.println();
		if(atter.getNump()<0){
			System.out.println("进攻放输");
		}
		if(defer.getNump()<0){
			System.out.println("放手放输");
		}
	}
	
	public class Atter{
		private int nump;
		private String canAtt;
		private String canAgi;
		private String baceatt;
		public int getNump() {
			return nump;
		}
		public void setNump(int nump) {
			this.nump = nump;
		}
		public String getCanAtt() {
			return canAtt;
		}
		public void setCanAtt(String canAtt) {
			this.canAtt = canAtt;
		}
		public String getBaceatt() {
			return baceatt;
		}
		public void setBaceatt(String baceatt) {
			this.baceatt = baceatt;
		}
		public String getCanAgi() {
			return canAgi;
		}
		public void setCanAgi(String canAgi) {
			this.canAgi = canAgi;
		}
		
	}
	
	public class Defer{
		private int nump;
		private String canAgi;
		private String baceatt;
		public int getNump() {
			return nump;
		}
		public void setNump(int nump) {
			this.nump = nump;
		}
		public String getCanAgi() {
			return canAgi;
		}
		public void setCanAgi(String canAgi) {
			this.canAgi = canAgi;
		}
		public String getBaceatt() {
			return baceatt;
		}
		public void setBaceatt(String baceatt) {
			this.baceatt = baceatt;
		}
		
	}
}
