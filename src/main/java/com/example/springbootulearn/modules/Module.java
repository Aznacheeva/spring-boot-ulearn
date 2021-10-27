package com.example.springbootulearn.modules;

import java.io.File;

public interface Module {
    boolean isSupportedFileFormat(File file);

    String describeFunction();

    void function(File file);
}
