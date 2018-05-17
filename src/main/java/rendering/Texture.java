package rendering;

import org.lwjgl.BufferUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;

public class Texture {
    private int id;
    private int width;
    private int heigth;

    public Texture(String fileName) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(fileName));
            width = image.getWidth();
            heigth = image.getHeight();

            int [] pixels_raw = image.getRGB(0, 0, width, heigth, null, 0, width);
            ByteBuffer pixels = BufferUtils.createByteBuffer(width * heigth * 4);
            for (int i = 0; i < heigth; i++) {
                for (int j = 0; j < width; j++) {
                    int pixel = pixels_raw[i * width + j];
                    pixels.put((byte) ((pixel >> 16) & 0xFF));  // R
                    pixels.put((byte) ((pixel >> 8) & 0xFF));   // G
                    pixels.put((byte) (pixel & 0xFF));          // B
                    pixels.put((byte) ((pixel >> 24) & 0xFF));  // A
                }
            }
            pixels.flip();

            id = glGenTextures();
            glBindTexture(GL_TEXTURE_2D, id);
            glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, heigth, 0,GL_RGBA, GL_UNSIGNED_BYTE, pixels);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bind() {
        glBindTexture(GL_TEXTURE_2D, id);
    }
}
