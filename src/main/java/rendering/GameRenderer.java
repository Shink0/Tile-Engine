package rendering;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class GameRenderer {

    private final int RES_X;
    private final int RES_Y;

    public GameRenderer(int RES_X, int RES_Y) {
        this.RES_X = RES_X;
        this.RES_Y = RES_Y;
    }

    public void run() {
       long window = initializeWindow();

       // TODO initialize textures

        while (!glfwWindowShouldClose(window)) {
            // TODO process game logic and handle input
            processGameLogic();
            renderToScreen(window);
        }

        glfwTerminate();
    }


    private long initializeWindow() {
        if (!glfwInit())
            throw new IllegalStateException("Failed to initialize GLFW");
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        long window = glfwCreateWindow(RES_X, RES_Y, "Test Game", 0, 0);
        if (window == 0)
            throw new IllegalStateException("Failed to create new window");
        GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(window, (videoMode.width() - RES_X) / 2, (videoMode.height() - RES_Y) / 2); // Place window in center of the screen
        glfwShowWindow(window);
        glfwMakeContextCurrent(window);
        GL.createCapabilities();
        glEnable(GL_TEXTURE_2D);
        return window;
    }

    private void processGameLogic() {
        handleInput();
    }

    private void handleInput() {

    }

    private void renderToScreen(long window) {
        glfwPollEvents();
        glClear(GL_COLOR_BUFFER_BIT); // Clear buffer to BLACK

        // TODO rendering goes here


        glfwSwapBuffers(window);
    }
}
