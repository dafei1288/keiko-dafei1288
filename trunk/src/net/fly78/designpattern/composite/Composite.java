/**
 * net.fly78.designpattern.composite
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 7, 2009/12:37:45 PM
 */
package net.fly78.designpattern.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Composite implements IComposite{
	
	
	private List<IComposite> _items;
	private String name;
	private String desc;
	
	
	public Composite(String name,String desc){
		this._items = new ArrayList<IComposite>();
		this.name = name;
		this.desc = desc;
	}
	public Composite(){
		this._items = new ArrayList<IComposite>();
	}
	
	public boolean add(IComposite ic) {
		boolean tag = Boolean.FALSE ;
		try{
			
			this._items.add(ic);
			tag = Boolean.TRUE;
		}catch(Exception e){
		}
		return tag;
	}

	

	public IComposite get(int index) {
		return (IComposite) this._items.get(index);
	}

	public Iterator iterator() {
		return this._items.iterator();
	}
	public boolean remove(IComposite ic) {
		return false;
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
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("< name: ").append(name).append(" ,desc: ").append(desc).append(" ,list:{");
		for(IComposite ic : this._items){
			sb.append(ic).append(",");
		}
		sb.append("}>");
		return sb.toString();
	} 
}
