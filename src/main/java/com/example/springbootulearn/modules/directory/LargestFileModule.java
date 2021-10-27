package com.example.springbootulearn.modules.directory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class LargestFileModule extends AbstractDirectoryModule {
    @Override
    public String describeFunction() {
        return "Вывод самого объемного файла в директории";
    }

    @Override
    public void function(File file) {
        long largestFileSize = 0L;
        String largestFileSizeName = "";
        for (File aFile : file.listFiles())
            if (largestFileSize < aFile.length()) {
                largestFileSize = aFile.length();
                largestFileSizeName = aFile.getName();
            }
        if (largestFileSizeName.equals(""))
            System.out.println("Вероятно, директория пуста");
        else System.out.println("Самый тяжелый файл: " + largestFileSizeName
                    + " объемом " + getFormattedSize(largestFileSize));
    }

    private String getFormattedSize(long l) {
        return  l < 1024 ? l + " B" :
                l < (1024 * 1024) ? l / 1024 + " KB" :
                        l < (1024 * 1024 * 1024) ? l / (1024 * 1024) + " MB" :
                                l / (1024 * 1024 * 1024) + " GB";
    }
}
