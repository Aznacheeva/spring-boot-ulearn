package com.example.springbootulearn.modules.text;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

@Component
public class CountWordsModule extends AbstactTextModule {
    @Override
    public String describeFunction() {
        return "Подсчет и вывод количества слов";
    }

    @Override
    public void function(File file) {
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            int count = 0;
            while (scanner.hasNext()) {
                scanner.next();
                count++;
            }
            System.out.println("Количество слов: " + count);
        } catch (IOException exception) {
            System.out.println("Ошибка при чтении файла");
        }
    }
}
