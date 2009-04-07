package net.fly78.dafei1288.util.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

import net.fly78.dafei1288.exception.MakedirException;

public class FileUtil {
	
	private File _file;
	private FileOutputStream _fos;
	private FileInputStream _fis;
	
	public FileUtil(String path) throws MakedirException, IOException{
		this.init(path);
	}

	public File getFile() {
		return _file;
	}
	
	public void setFile(String path) throws MakedirException, IOException{
		this.setFile(new File(path));
	}
	public void setFile(File file) throws MakedirException, IOException {
		this.init(file.getPath());
	}
	
	
	public void delFile(){
		_file.deleteOnExit();
	}
	
	public void copyFileTo(String toFile) throws IOException{
		InputStream is = new FileInputStream(_file);
        OutputStream os = new FileOutputStream(toFile);
        copyStream(is, os);   
        is.close(); 
        os.close(); 
	}
	
	
	public void copyStream(InputStream is, OutputStream os) throws IOException{
		 String line;
		 InputStreamReader isr = new InputStreamReader(is);
	     BufferedReader reader = new BufferedReader(isr);
	     OutputStreamWriter osw = new OutputStreamWriter(os);
	     PrintWriter writer = new PrintWriter(osw);
	     line = reader.readLine();
	     while (line != null) {
	           writer.println(line);
	           line = reader.readLine();
	     }
	     writer.flush(); 
	     isr.close();
	     osw.close();
	}
	
	private void init(String path) throws MakedirException, IOException{
		_file = new File(path);
		if(!_file.exists()){
			String ftstr = _file.getParent();
			File ft = new File(ftstr);
			if(!ft.exists()){
				if(!ft.mkdirs()){
					throw new MakedirException();
				};
			}
			_file.createNewFile();
			/*
			FileOutputStream fos = new FileOutputStream(path);
			fos.flush();
			fos.close();
			*/
		}
	}

	public FileOutputStream getFileOutputStream() throws FileNotFoundException {
		_fos = new FileOutputStream(_file);
		return _fos;
	}
	public FileInputStream getFileInputStream() throws FileNotFoundException {
		_fis = new FileInputStream(_file);
		return _fis;
	}
	public void CloseFileOutputStream(){
		if(_fos!=null){
			try {
				_fos.close();
			} catch (IOException e) {
				_fos = null;
			}
		}
	}
	public void CloseFileInputStream() {
		if(_fis!=null){
			try {
				_fis.close();
			} catch (IOException e) {
				_fis = null;
			}
		}
	}
	
	public void writeContent(String content){
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(_file);
			PrintStream ps = new PrintStream(fos);   
		    ps.print(content);
		    ps.close();
		    fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	public void addContent(String content) throws IOException{
		FileWriter   fw=new   FileWriter(_file,true);   
	    PrintWriter   pw=new  PrintWriter(fw);   
	    pw.print(content);   
        pw.close();   
        fw.close();

	}
	
	public String getContent(){
		String line;
		StringBuffer sb = new StringBuffer();
		try {
			FileInputStream fis = new FileInputStream(_file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader reader = new BufferedReader(isr);
			line = reader.readLine();
			while(line!=null){
				sb.append(line);
				line = reader.readLine();
			}
			reader.close();
			isr.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}
	
	public void CloseAllStream(){
		if(_fos!=null){
			try {
				_fos.close();
			} catch (IOException e) {
				_fos =null;
			}finally{
				_fos =null;
			}
		}
		if(_fis!=null){
			try {
				_fis.close();
			} catch (IOException e) {
				_fis =null;

			}finally{
				_fis =null;
			}
		}
		_file=null;
	}
	
}
