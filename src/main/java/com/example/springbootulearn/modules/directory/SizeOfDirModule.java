package com.example.springbootulearn.modules.directory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SizeOfDirModule extends AbstractDirectoryModule {
    @Override
    public String describeFunction() {
        return "Подсчет размера всех файлов в каталоге";
    }

    @Override
    public void function(File file) {
        try {
            long sum = Files.walk(file.toPath())
                    .mapToLong(p -> p.toFile().length())
                    .sum();
            System.out.printf("Общий размер директории %s: %s\n", file.getAbsolutePath(),
                    getFormattedSize(sum));
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла " + file.getAbsolutePath());
        }
    }

    private String getFormattedSize(long l) {
        return  l < 1024 ? l + " B" :
                l < (1024 * 1024) ? l / 1024 + " KB" :
                        l < (1024 * 1024 * 1024) ? l / (1024 * 1024) + " MB" :
                                l / (1024 * 1024 * 1024) + " GB";
    }
}
