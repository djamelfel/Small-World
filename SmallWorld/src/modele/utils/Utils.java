package modele.utils;

import java.awt.*;
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
}
