package com.example.springbootulearn.modules.image;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Tag;
import org.springframework.stereotype.Component;

@Component
public class ExifInfoModule extends AbstractImageModule {
    @Override
    public String describeFunction() {
        return "Вывод информации EXIF";
    }

    @Override
    public void function(File file) { //сложная магия с просторов Интернета
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    System.out.format("[%s] - %s = %s",
                            directory.getName(), tag.getTagName(), tag.getDescription());
                }
                if (directory.hasErrors()) {
                    for (String error : directory.getErrors()) {
                        System.err.format("ERROR: %s", error);
                    }
                }
            }
        } catch (ImageProcessingException | IOException exception) {
            System.out.println("Ошибка при чтении файла " + file.getAbsolutePath());
        }
    }
}
