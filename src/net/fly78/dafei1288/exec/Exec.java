/**
 * 执行外部程序
 * 
 * 
 * */

package net.fly78.dafei1288.exec;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author dafei1288
 * 
 * */
public class Exec {
	
	/** 
     * 执行一条命令
     * @param string cmd
     * @throws IOException if an I/O error occurs
     */
	
	 public static String RExec(String cmd) throws IOException{
	      Runtime run = Runtime.getRuntime();
	      Process p = run.exec(cmd);
	      BufferedInputStream in = new BufferedInputStream(p.getInputStream());
	      BufferedReader br = new BufferedReader(new InputStreamReader(in));
	      StringBuffer sb = new StringBuffer();
	      String s;
	      while ((s = br.readLine()) != null){
	          sb.append(s).append("\n");

	      }
	      br.close();
	      in.close();
	      p.destroy();
	      //run.freeMemory();
	     return sb.toString();
	 }
}
