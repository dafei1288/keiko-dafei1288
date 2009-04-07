/**
 * net.fly78.designpattern.composite
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 7, 2009/4:12:27 PM
 */
package net.fly78.designpattern.composite;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class CompositeIterator implements Iterator {
	
	private Stack stack = new Stack();
	
	public CompositeIterator(IComposite al){
		stack.push(al);
	}
	
	public boolean hasNext() {
		if(stack.isEmpty()){
			return Boolean.FALSE;
		}else{
			Iterator it = null;
			try{
				it = (Iterator)stack.peek();
			}catch(Exception e){
				it = ((IComposite)stack.peek()).iterator();
			}
			if(!it.hasNext()){
				stack.pop();
				return this.hasNext();
			}else{
				return true;
			}
		}
		
	}

	public Object next() {
		IComposite ic = null;
		if(this.hasNext()){
			try{
				Iterator it = (Iterator)stack.peek();
				ic = (Composite)it.next();
			}catch(Exception e){
				ic = (Composite)stack.peek();
			}
			if(ic instanceof CompositeItem){
				stack.push(ic.iterator());
			}
		}
		return ic;
	}
	
	public boolean add(List<? extends IComposite> al){
		boolean tag = Boolean.FALSE;
		try{
			stack.push(al);
			
			tag = Boolean.TRUE;
		}catch(RuntimeException e){
			throw e;
		}
		return tag;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
