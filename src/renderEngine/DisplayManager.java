package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {
    //Store height and width of game window in these variables
	private static final int WIDTH = 1024;
    private static final int HEIGHT = 1024;
    private static final int FPS_CAP = 120;
    
	//creates the game window
	public static void createDisplay() {
		//set the version of OpenGL we will be using in this case 3.2
		ContextAttribs attribs = new ContextAttribs(3,2)
				.withForwardCompatible(true)
				.withProfileCore(true);
		
		
		try {
			//We need to determine the size of the display WIDTH, HEIGHT
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			//now we will actually create the display
			Display.create(new PixelFormat(), attribs);
			//sets display title
			Display.setTitle("Treasure Island");
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//where do we want to render the display? (bottom left of display, top right of display) use the entire screen to render to
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
	}
	
	
	public static void updateDisplay() {
		//This method updates game window and sets display frame-rate cap
		Display.sync(FPS_CAP);
		Display.update();
	}
	
	
	public static void closeDisplay() {
		//This method closes game window and cleans up properly
		Display.destroy();
	}
}
