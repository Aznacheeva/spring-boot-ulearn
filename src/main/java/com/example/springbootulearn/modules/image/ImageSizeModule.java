package com.example.springbootulearn.modules.image;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

@Component
public class ImageSizeModule extends AbstractImageModule {
    @Override
    public String describeFunction() {
        return "Вывод размера изображения";
    }

    @Override
    public void function(File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            System.out.printf("Размер изображения: %d x %d", image.getWidth(), image.getHeight());
        } catch (IOException exception) {
            System.out.println("Ошибка при чтении файла " + file.getAbsolutePath());
        }
    }
}
