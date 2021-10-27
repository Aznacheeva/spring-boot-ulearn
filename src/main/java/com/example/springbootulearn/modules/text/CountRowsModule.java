package com.example.springbootulearn.modules.text;

import com.example.springbootulearn.modules.text.AbstactTextModule;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class CountRowsModule extends AbstactTextModule {
    @Override
    public String describeFunction() {
        return "Подсчет и вывод количества строк";
    }

    @Override
    public void function(File file) {
        try {
            int count = Files.readAllLines(file.toPath()).size();
            System.out.println("Общее количество строк: " + count);
        } catch (IOException exception) {
            System.out.println("Ошибка при чтении файла " + file.getAbsolutePath());
        }
    }
}
