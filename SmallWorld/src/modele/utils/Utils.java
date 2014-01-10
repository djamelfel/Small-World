package modele.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Utils {


    public static long getRandColor() {
        return (long) (Math.random() * 16777216);
    }

    public static int getRand(int max, int min) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public static int getRand(int max) {
        return getRand(max, 0);
    }

    public static String randString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder pass = new StringBuilder(length);
        for (int x = 0; x < length; x++) {
            int i = (int) (Math.random() * chars.length());
            pass.append(chars.charAt(i));
        }
        return pass.toString();
    }


    public static double getDistance(double posX1, double posY1, double posX2, double posY2) {

        return Math.sqrt(Math.pow(posX1 - posX2, 2.0) + Math.pow(posY1 - posY2, 2.0));
    }

    public static String randomColor() {
        Random random = new Random(); // Probably really put this somewhere where it gets executed only once
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return Integer.toHexString(new Color(red, green, blue).getRGB());
    }
    
    
    public static BufferedImage toBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }
    
    /**
   * Crée une image en niveaux de gris.
   */
  public static BufferedImage grayScale(BufferedImage bImage) {
    int w = bImage.getWidth(null);
    int h = bImage.getHeight(null);
    BufferedImage bImage2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    for (int i = 0; i < w; i++) {
      for (int j = 0; j < h; j++) {
        int p = bImage.getRGB(i, j);
        int a = (((p >> 16) & 0xff) + ((p >> 8) & 0xff) + (p & 0xff)) / 3;
        bImage2.setRGB(i, j, (0xff << 24) | (a << 16) | (a << 8) | a);
      }
    }
    return bImage2;
  }
  
  
  /**
   * Change la couleur
   */
  public static BufferedImage changeColor(BufferedImage bImage, int color) {
    int w = bImage.getWidth(null);
    int h = bImage.getHeight(null);
    BufferedImage bImage2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    for (int i = 0; i < w; i++) {
      for (int j = 0; j < h; j++) {
        int p = bImage.getRGB(i, j);
        //int a = (((p >> 16) & 0xff) + ((p >> 8) & 0xff) + (p & 0xff)) / 3;
        if (p == 0xffffffff)
            bImage2.setRGB(i, j, color);
      }
    }
    return bImage2;
  }
  
  
  /**
     * @param colorStr e.g. "#FFFFFF"
     * @return
     */
    public static Color hex2Rgb(String colorStr) {
        return new Color(
                Integer.valueOf(colorStr.substring(1, 3), 16),
                Integer.valueOf(colorStr.substring(3, 5), 16),
                Integer.valueOf(colorStr.substring(5, 7), 16));
    }
}
