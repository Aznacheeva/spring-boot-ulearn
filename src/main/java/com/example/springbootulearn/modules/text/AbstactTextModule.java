package com.example.springbootulearn.modules.text;

import com.example.springbootulearn.FileUtil;
import com.example.springbootulearn.modules.Module;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public abstract class AbstactTextModule implements Module{
    private static final List<String> formats = Arrays.asList("txt", "doc", "docx", "html", "pdf");

    @Override
    public boolean isSupportedFileFormat(File file) {
        return formats.contains(FileUtil.getFileUtils(file.getName()));
    }

    @Override
    public abstract String describeFunction();

    @Override
    public abstract void function(File file);
}
