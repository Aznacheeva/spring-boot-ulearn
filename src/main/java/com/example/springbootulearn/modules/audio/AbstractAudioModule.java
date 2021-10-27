package com.example.springbootulearn.modules.audio;

import com.example.springbootulearn.FileUtil;
import com.example.springbootulearn.modules.Module;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public abstract class AbstractAudioModule implements Module {
    private static final List<String> formats = Arrays.asList("wav", "mp3");

    @Override
    public boolean isSupportedFileFormat(File file) {
        return formats.contains(FileUtil.getFileUtils(file.getName()).toLowerCase(Locale.ROOT));
    }

    @Override
    public abstract String describeFunction();

    @Override
    public abstract void function(File file);
}
