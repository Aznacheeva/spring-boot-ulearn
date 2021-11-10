package com.example.springbootulearn.modules.directory;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

@Component
public class FilesInDirModule extends AbstractDirectoryModule {
    @Override
    public String describeFunction() {
        return "Вывод списка файлов в каталоге";
    }

    @Override
    public void function(File file) {
        Arrays.stream(Objects.requireNonNull(file.listFiles()))
                .sorted(getFilesComparator())
                .map(f -> (f.isDirectory() ? "[DIR]" : "[FILE]") + "\t" + f.getName())
                .forEach(System.out::println);
    }

    private Comparator<File> getFilesComparator() {
        return (a, b) -> a.isDirectory() && !b.isDirectory() ? -1 :
                !a.isDirectory() && b.isDirectory() ? 1 : 0;
    }
}
