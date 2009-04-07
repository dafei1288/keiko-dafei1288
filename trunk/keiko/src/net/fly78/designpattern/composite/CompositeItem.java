/**
 * net.fly78.designpattern.composite
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 7, 2009/2:10:14 PM
 */
package net.fly78.designpattern.composite;

import java.util.Iterator;

import net.fly78.dafei1288.util.NullableIterator;
import net.fly78.dafei1288.util.UnsupportedException;

public class CompositeItem implements IComposite {
	private String name;
	private String desc;
	
	public boolean add(IComposite ic) {
		throw new UnsupportedOperationException();
	}
	public boolean remove(IComposite ic) {
		throw new UnsupportedOperationException();
	}
	

	public IComposite get(int index) {
		return this;
	}

	public Iterator iterator() {
		return new NullableIterator();
	}

	public String name() {
		return name;
	}
	public String descp() {
		return desc;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescp(String desc) {
		this.desc = desc;
	}

}
