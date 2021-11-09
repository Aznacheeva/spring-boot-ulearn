package com.example.springbootulearn.Services;

import com.example.springbootulearn.modules.directory.AbstractDirectoryModule;
import org.springframework.context.ApplicationContext;
import com.example.springbootulearn.modules.Module;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

@Service
public class FileService {
    public void executeFunction(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Файл не найден");
            return;
        }
        ApplicationContext context = new AnnotationConfigApplicationContext("com.example.springbootulearn.modules");
        Module[] modules = getAvailableModules(file, context);
        if (modules.length == 0) {
            System.out.println("Отсутствуют модули для данного типа файлов");
            return;
        }
        printAvailableModules(file, modules);
        int number = askUserForNumberOfFunction(modules.length);
        modules[number - 1].function(file);
    }

    private int askUserForNumberOfFunction(int max) {
        while (true) {
            System.out.printf("Введите номер функции (%d-%d): ", 1, max);
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            if (number < 1 || number > max) {
                System.out.println("Некорректный ввод");
                continue;
            }
            return number;
        }
    }

    private void printAvailableModules(File file, Module[] modules) {
        System.out.println("-----------------------------------------------------");
        System.out.println("Доступные функции " + file.getAbsolutePath() + ":");
        for (int i = 0; i < modules.length; i++) {
            System.out.println((i + 1) + ". " + modules[i].describeFunction());
        }
    }


    private Module[] getAvailableModules(File file, ApplicationContext ctx) {
        Map<String, Module> moduleMap = ctx.getBeansOfType(Module.class);
        return moduleMap.values()
                .stream()
                .filter(module -> module.isSupportedFileFormat(file))
                .toArray(Module[]::new);
    }
}
