package com.example.springbootulearn.modules.image;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Component
public class CountRedPixelsModule extends AbstractImageModule {
    @Override
    public String describeFunction() {
        return "Подсчет красных пикселей";
    }

    @Override
    public void function(File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            int count = 0;
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    Color color = new Color(image.getRGB(x, y));
                    if (color.getRed() >= 200 &&
                        color.getGreen() <= 100 && color.getBlue() <= 100)
                    /*Максимальное значение - 255, поэтому берем около 200
                    При этом сравниваем количество зеленого и синего,
                    чтоб под проверку не попадал например белый (255, 255, 255)*/
                        count++;
                }
            }
            System.out.println("Количество красных пикселей: " + count);
        } catch (IOException exception) {
            System.out.println("Ошибка при чтении файла " + file.getAbsolutePath());
        }
    }
}
