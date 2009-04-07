/**
 * net.fly78.designpattern.composite
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 7, 2009/11:50:31 AM
 */
package net.fly78.designpattern.composite;

import java.util.Iterator;

public interface IComposite {
	public boolean add(IComposite ic);
	public boolean remove(IComposite ic);
	public IComposite get(int index);
	public Iterator iterator(); 
	
	
	
	public String name();
	public String descp();
}
