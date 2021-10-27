package com.example.springbootulearn.modules.text;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

@Component
public class FrequencyOccurrenceCharModule extends AbstactTextModule{
    @Override
    public String describeFunction() {
        return "Вывод частоты вхождения каждого символа";
    }

    @Override
    public void function(File file) {
        List<String> lines;
        try {
            lines = Files.readAllLines(file.toPath());
        } catch (IOException exception) {
            System.out.println("Ошибка при чтении файла " + file.getAbsolutePath());
            return;
        }
        HashMap<Character, Integer> chars = lines.stream()
                .flatMapToInt(String::chars)
                .mapToObj((x -> (char) x))
                .collect(HashMap::new,
                        (m, c) -> m.put(c, m.getOrDefault(c, 0) + 1),
                        HashMap::putAll);
        if (chars.keySet().size() == 0)
            System.out.println("Файл не содержит ни одного символа");
        else
            chars.entrySet()
                    .stream()
                    .sorted((x, y) -> y.getValue().compareTo(x.getValue()))
                    .map(entry -> entry.getKey() + " -> " + entry.getValue())
                    .forEach(System.out::println);
    }
}
