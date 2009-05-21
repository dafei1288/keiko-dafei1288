/**
 * net.fly78.dafei1288.util.screenshot
 * 
 * @author dafei1288
 *
 * @version 2009/May 21, 2009/1:07:48 PM
 */
package net.fly78.dafei1288.util.screenshot;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenShot {
	
	public static void screenShot(String fileName) throws AWTException, IOException{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    Rectangle screenRectangle = new Rectangle(screenSize);
	    Robot robot = new Robot();
	    BufferedImage image = robot.createScreenCapture(screenRectangle);
	    ImageIO.write(image, "png", new File(fileName));

	}
	
	public static void main(String[] args) {
		try {
			ScreenShot.screenShot("c:\\tttt.png");
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
