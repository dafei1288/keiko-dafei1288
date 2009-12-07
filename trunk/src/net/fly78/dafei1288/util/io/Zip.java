package net.fly78.dafei1288.util.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
/**
 * 包含中文路径有问题 
 * */
public class Zip {
	public static void zip(String zipFileName, String inputFile)
			throws Exception {
		File f = new File(inputFile);
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
				zipFileName));
		zip(out, f, null);
		System.out.println("zip done");
		out.close();
	}

	private static void zip(ZipOutputStream out, File f, String base)
			throws Exception {
		System.out.println("zipping " + f.getAbsolutePath());
		if (f.isDirectory()) {
			File[] fc = f.listFiles();
			if (base != null)
				out.putNextEntry(new ZipEntry(base + "/"));
			base = base == null ? "" : base + "/";
			for (int i = 0; i < fc.length; i++) {
				String r = new String( fc[i].getName().getBytes("utf-8"),"iso8859-1");
				System.out.println("===》"+fc[i].getName()+" //  "+r+" // "+new String(r.getBytes("iso8859-1"),""));
				zip(out, fc[i], base +new String( fc[i].getName().getBytes("utf-8"),"iso8859-1"));
			}
		} else {
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			int b;
			while ((b = in.read()) != -1)
				out.write(b);
			in.close();
		}
	}
	
	public static void main(String[]args){
		try {
			zip("d:\\ttt.zip","d:\\tk");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
