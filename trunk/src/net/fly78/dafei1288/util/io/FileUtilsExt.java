package net.fly78.dafei1288.util.io;

import java.io.File;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;

public class FileUtilsExt extends FileUtils {
	
	/**
	 * @param  File srcFile
	 * 	   要重命名的文件
	 * @param String toFileName
	 * 	 重命名的文件名，不包含路径
	 * @return
	 * */
	public static boolean rename(File srcFile,String toFileName){
		boolean tag = false;
		if(srcFile==null || toFileName==null || srcFile.exists()==false){
			tag = false;
		}else{
			tag = srcFile.renameTo(new File(srcFile.getParent()+File.separator+toFileName));
		}
		return tag;
	}
	/**
	 * 获取文件扩展名
	 * */
	public static String getFileExtensionName(File f) {
	   return getFileExtensionName(f.getName());
	 }
	/**
	 * 获取文件扩展名
	 * */
	public static String getFileExtensionName(String f) {
	    if (f.lastIndexOf(".") == -1) {
	      return "";
	    } else {
	      return f.substring(f.lastIndexOf(".")+1, f.length());
	    }
	 }
	
	
	/**
	 * 去掉文件扩展名
	 * */
	public static String trimFileExtensionName(File f){
		return trimFileExtensionName(f.getName());
	}
	
	/**
	 * 去掉文件扩展名
	 * */
	public static String trimFileExtensionName(String f){
		 if ((f != null) && (f.length() > 0)) { 
	            int i = f.lastIndexOf('.'); 
	            if ((i >-1) && (i < (f.length()))) { 
	                return f.substring(0, i); 
	            } 
	        } 
	     return f; 

	}
	
	/**
	 * @param  String srcFile
	 * 	   要重命名的文件名
	 * @param String toFileName
	 * 	 重命名的文件名，不包含路径
	 * @return
	 * */
	public static boolean rename(String srcFile,String toFileName){
		return rename(new File(srcFile),toFileName);
	}
	
	
	public static boolean isFileExist(String filePath) {
		File file = new File(filePath);
		if (file.exists())
			return true;
		else
			return false;
	}

	public static void createFilePath(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			file.renameTo(new File(filePath + ".bak"));
		}
		try {
			file.getParentFile().mkdirs();
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建目录
	 * 
	 * @param destDirName
	 *            目标目录名
	 * @return 目录创建成功放回true，否则返回false
	 */
	public static boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {
			destDirName = destDirName + File.separator;
		}
		// 创建目标目录
		if (dir.mkdirs()) {
			return true;
		} else {
			return false;
		}
	}

	public static void rollBack(String filePath) {
		File file = new File(filePath);
		File file0 = new File(filePath + ".bak");
		if (file.exists())
			file.delete();
		if (file0.exists())
			file0.renameTo(file);
	}

	/**
	 * 删除文件，可以是单个文件或文件夹
	 * 
	 * @param fileName
	 *            待删除的文件名
	 * @return 文件删除成功返回true,否则返回false
	 */
	public static boolean delete(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			return false;
		} else {
			if (file.isFile()) {

				return deleteFile(fileName);
			} else {
				return deleteDirectory(fileName);
			}
		}
	}

	/**
	 * 删除单个文件
	 * 
	 * @param fileName
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true,否则返回false
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.isFile() && file.exists()) {
			file.delete();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 这是一个内部类，实现了FilenameFilter接口，用于过滤文件
	 */
	static class MyFilenameFilter implements FilenameFilter {
		// 文件名后缀
		private String suffix = "";

		public MyFilenameFilter(String surfix) {
			this.suffix = surfix;
		}

		public boolean accept(File dir, String name) {
			// 如果文件名以surfix指定的后缀相同，便返回true，否则返回false
			if (new File(dir, name).isFile()) {
				return name.endsWith(suffix);
			} else {
				// 如果是文件夹，则直接返回true
				return true;
			}
		}
	}

	/**
	 * 列出目录中通过文件名过滤器过滤后的文件。
	 * 
	 * @param String
	 *            str[] 文件名过滤器对象,内容为 view，list，edit
	 * @param dirName
	 *            目录名
	 */
	public static List listFilesByFilenameFilter(String str[], String dirName) {
		Map map = new HashMap();
		List list = new ArrayList();
		// 如果dir不以文件分隔符结尾，自动添加文件分隔符。
		if (!dirName.endsWith(File.separator)) {
			dirName = dirName + File.separator;
		}
		File dirFile = new File(dirName);
		// 如果dir对应的文件不存在，或者不是一个文件夹，则退出
		if (!dirFile.exists() || (!dirFile.isDirectory())) {
			list = null;
		}
		// 列出源文件夹下所有文件（包括子目录）过滤文件信息
		if (str != null && str.length > 0) {
			for (int i = 0; i < str.length; i++) {
				// 外部类 调用内部类，内部类作为外部类的属性使用,先获得所有文件，然后再筛选
				// 一个内部类对象可以访问创建它的外部类对象的内容，甚至包括私有变量
				FilenameFilter filter = new FileUtilsExt.MyFilenameFilter(str[i]
						+ ".jsp");
				File[] files = dirFile.listFiles(filter);
				List temp = new ArrayList();
				if (files != null && files.length > 0) {

					for (int j = 0; j < files.length; j++) {
						temp.add(files[j].getName());

					}
					map.put(str[i], temp);
				}
			}
		}
		list.add(map);
		// File[] files = dirFile.listFiles(filter);
		// for (int i = 0; i < files.length; i++){
		// if (files[i].isFile()){
		// System.out.println(files[i].getAbsolutePath() + " 是文件!");
		// }else if (files[i].isDirectory()){
		// System.out.println(files[i].getAbsolutePath() + " 是目录!");
		// ListFileUtil.listFilesByFilenameFilter(filter,
		// files[i].getAbsolutePath());
		// }
		//			
		// }

		return list;
	}

	/**
	 * 删除目录（文件夹）以及目录下的文件
	 * 
	 * @param dir
	 *            被删除目录的文件路径
	 * @return 目录删除成功返回true,否则返回false
	 */
	public static boolean deleteDirectory(String dir) {
		// 如果dir不以文件分隔符结尾，自动添加文件分隔符
		if (!dir.endsWith(File.separator)) {
			dir = dir + File.separator;
		}
		File dirFile = new File(dir);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			return false;
		}
		boolean flag = true;
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
			// 删除子目录
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
		}

		if (!flag) {
			return false;
		}

		// 删除当前目录
		if (dirFile.delete()) {
			return true;
		} else {
			return false;
		}
	}
}
