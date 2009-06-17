/**
 * net.fly78.dafei1288.util.io
 * 
 * @author dafei1288
 *
 * @version 2009/Jun 17, 2009/2:27:03 PM
 */
package net.fly78.dafei1288.util.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectClone implements java.io.Serializable{
	public synchronized static Object CloneObject(Object o) throws FileNotFoundException,IOException, ClassNotFoundException{
		Object res =null;
		String tempf = Math.random()+"t.tmp";
		FileOutputStream fos = new FileOutputStream(tempf);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
	    oos.writeObject(o);
	    oos.close();
	    fos.close();

	    FileInputStream fis = new FileInputStream(tempf);
	    ObjectInputStream ois = new ObjectInputStream(fis);
        res = ois.readObject();
        ois.close();
        fis.close();
        
        File f = new File(tempf);
        f.delete();
		return res;
	}
	
}
