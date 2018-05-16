package rendering;

import org.lwjgl.glfw.GLFWVidMode;

import static org.lwjgl.glfw.GLFW.*;

public class GameRenderer {

    private final int RES_X;
    private final int RES_Y;

    public GameRenderer(int RES_X, int RES_Y) {
        this.RES_X = RES_X;
        this.RES_Y = RES_Y;
    }

    public void run() {
       long window = initializeWindow();

        while (!glfwWindowShouldClose(window)) {
            System.out.println("test");
            glfwPollEvents();
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
        return window;
    }
}
