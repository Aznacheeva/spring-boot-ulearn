package com.example.springbootulearn.modules.image;

import com.example.springbootulearn.FileUtil;
import com.example.springbootulearn.modules.Module;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractImageModule implements Module {
    private static final List<String> formats = Arrays.asList("jpg","jpeg","png","bmp");

    @Override
    public boolean isSupportedFileFormat(File file) {
        return formats.contains(FileUtil.getFileUtils(file.getName()));
    }

    @Override
    public abstract String describeFunction();

    @Override
    public abstract void function(File file);
}
