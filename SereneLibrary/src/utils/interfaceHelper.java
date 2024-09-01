package utils;

import javax.swing.*;
import java.awt.*;

public class interfaceHelper {
    public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image originalImage = icon.getImage();
        Image resized = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resultIcon = new ImageIcon(resized);
        return resultIcon;
    }
}
