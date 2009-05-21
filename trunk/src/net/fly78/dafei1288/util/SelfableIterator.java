package net.fly78.dafei1288.util;

import java.util.Iterator;

public class SelfableIterator implements Iterator {
	private Object _self;
	public SelfableIterator(Object o){
		this._self = o;
	}
	public boolean hasNext() {
		return true;
	}

	public Object next() {
		return this._self;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
