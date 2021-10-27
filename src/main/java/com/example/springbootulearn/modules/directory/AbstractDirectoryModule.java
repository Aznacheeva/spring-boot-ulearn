package com.example.springbootulearn.modules.directory;

import com.example.springbootulearn.modules.Module;

import java.io.File;

public abstract class AbstractDirectoryModule implements Module {
    @Override
    public boolean isSupportedFileFormat(File file) {
        return file.isDirectory();
    }

    @Override
    public abstract String describeFunction();

    @Override
    public abstract void function(File file);
}
