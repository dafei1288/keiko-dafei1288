package net.fly78.dafei1288.util.io;

import info.monitorenter.cpdetector.io.CodepageDetectorProxy;   
import info.monitorenter.cpdetector.io.JChardetFacade;   
  
import java.io.File;   
import java.nio.charset.Charset;   
  
public class CharacterEnding {   
  
    public static String getFileCharacterEnding(String filePath) {   
  
        File file = new File(filePath);   
  
        return getFileCharacterEnding(file);   
    }   
  
    /**  
     * Try to get file character ending.  
     * </p>  
     * <strong>Warning: </strong>use cpDetector to detect file's encoding.  
     *   
     * @param file  
     * @return  
     */  
    public static String getFileCharacterEnding(File file) {   
  
        String fileCharacterEnding = "UTF-8";   
  
        CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();   
        detector.add(JChardetFacade.getInstance());   
  
        Charset charset = null;   
  
        // File f = new File(filePath);   
  
        try {   
            charset = detector.detectCodepage(file.toURL());   
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
        if (charset != null) {   
            fileCharacterEnding = charset.name();   
        }   
  
        return fileCharacterEnding;   
    }   
    
    public static void main(String[] args){
    	
    	System.out.println(CharacterEnding.getFileCharacterEnding("c:\\11.txt"));
    	
    }
}  
