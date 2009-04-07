/**
 * net.fly78.designpattern.composite
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 7, 2009/5:16:06 PM
 */
package net.fly78.designpattern.composite;

public class TestC {

	public static void main(String[] args) {
		
		IComposite ic = new Composite("root","root");
		
		IComposite ic1 = new Composite("1111","1111");
		IComposite ic2 = new Composite("2222","2222");
		IComposite ic3 = new Composite("3333","3333");
		
		IComposite ic11 = new Composite("1111_1111","1111_1111");
		IComposite ic12 = new Composite("1111_2222","1111_2222");
		IComposite ic21 = new Composite("2222_1111","2222_1111");
		IComposite ic22 = new Composite("2222_2222","2222_2222");
		IComposite ic23 = new Composite("2222_3333","2222_3333");
		
		ic1.add(ic11);
		ic1.add(ic12);
		
		ic2.add(ic21);
		ic2.add(ic22);
		ic2.add(ic23);
		
		ic.add(ic1);
		ic.add(ic2);
		ic.add(ic3);
		
		System.out.println(ic);
		
		System.out.println("");
		System.out.println("-------迭代----------");
		CompositeIterator ci = new CompositeIterator(ic);
		while(ci.hasNext()){
			
			System.out.println((IComposite)ci.next());
		}
		
		
	}

}
