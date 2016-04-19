package engineTester;

import org.lwjgl.opengl.Display;

import models.RawModel;
import models.TexturedModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

public class MainGameLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        DisplayManager.createDisplay();
        
        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        StaticShader shader = new StaticShader();
        
        
        float[] vertices = {
        		//Left bottom triangle
        		-0.5f,  0.5f, 0,
        		-0.5f, -0.5f, 0,
        		 0.5f, -0.5f, 0,
        		0.5f,   0.5f, 0
        };
        
        int[] indices = {
        		
        		0,1,3, //top left triangle (v0,v1,v3)
        		3,1,2  //bottom right triangle (v3,v1,v2)
        };
        
        RawModel model = loader.loadToVAO(vertices, indices);
        ModelTexture texture = new ModelTexture(loader.loadTexture("ship"));
        TexturedModel texturedModel = new TexturedModel(model, texture);
        
        //While display updates check if a close is requested then execute close display.
        
        while(!Display.isCloseRequested()) {
        	//game logic
        	renderer.prepare();
        	shader.start();
        	renderer.render(texturedModel);
        	shader.stop();
        	DisplayManager.updateDisplay();
        }
        
        shader.cleanUp();
        loader.cleanUp();
        // closes display when iscloserequested is returned
        DisplayManager.closeDisplay();
	}

}
