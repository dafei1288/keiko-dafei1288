/**
 * net.fly78.dafei1288.util
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 7, 2009/12:07:21 PM
 */
package net.fly78.dafei1288.util;

import java.util.Iterator;

public class NullableIterator implements Iterator {
	
	public boolean hasNext() {
		return false;
	}

	public Object next() {
		throw new UnsupportedException(this.getClass()+" ,this object is unsupported  method : next() ");
	}

	public void remove() {
		throw new UnsupportedException(this.getClass()+" ,this object is unsupported  method : remove() ");
	}

}
