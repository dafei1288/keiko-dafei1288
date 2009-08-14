package net.fly78.dafei1288.util.images;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageUtil {
	public  void  saveMinPhoto(String srcURL,String deskURL,double comBase,double scale) throws IOException{
		/*srcURl 原图地址；deskURL 缩略图地址；comBase 压缩基数；scale 压缩限制(宽/高)比例*/
		java.io.File srcFile = new java.io.File(srcURL);
		BufferedImage src = javax.imageio.ImageIO.read(srcFile);
		int srcHeight = src.getHeight(null);
		int srcWidth = src.getWidth(null);
		int deskHeight = 0;//缩略图高
		int deskWidth  = 0;//缩略图宽
		double srcScale = (double)srcHeight/srcWidth; 
		if((double)srcHeight>comBase || (double)srcWidth>comBase){
		     if(srcScale>=scale || 1/srcScale>scale){
		            if(srcScale>=scale){
		                  deskHeight = (int)comBase;
		                  deskWidth  = srcWidth*deskHeight/srcHeight;
		              }else{
		                 deskWidth = (int)comBase ;
		                 deskHeight  = srcHeight*deskWidth/srcWidth;
		               }

		       } else {
		         if((double)srcHeight>comBase){
		            deskHeight = (int)comBase;
		            deskWidth  = srcWidth*deskHeight/srcHeight;
		             } else{
		                 deskWidth = (int)comBase ;
		                 deskHeight  = srcHeight*deskWidth/srcWidth;
		              }

		          } 
		      }else {
		          deskHeight = srcHeight;
		          deskWidth  = srcWidth;

		  }
		BufferedImage tag = new BufferedImage(deskWidth, deskHeight,
		    BufferedImage.TYPE_3BYTE_BGR);
		  tag.getGraphics().drawImage(src, 0, 0, deskWidth, deskHeight, null); //绘制缩小后的图
		  FileOutputStream deskImage = new FileOutputStream(deskURL); //输出到文件流
		  JPEGImageEncoder encoder = JPEGCodec
		    .createJPEGEncoder(deskImage);
		  encoder.encode(tag); //近JPEG编码
		  deskImage.close();

		} 
	
	
	public static void main(String[] args) throws IOException{
		ImageUtil iu = new ImageUtil();
		iu.saveMinPhoto("c:\\Windows XP.jpg", "c:\\aaa.jpg", 400, 400);
		
	}
}
