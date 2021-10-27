package com.example.springbootulearn;

import java.util.Locale;

public class FileUtil {
    public static String getFileUtils(String filename) {
        if (filename.contains("."))
            return filename.substring(filename.lastIndexOf('.') + 1).toLowerCase(Locale.ROOT);
        return "";
    }
}
