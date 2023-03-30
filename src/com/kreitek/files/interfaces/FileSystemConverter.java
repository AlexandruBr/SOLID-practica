package com.kreitek.files.interfaces;

public interface FileSystemConverter extends FileSystemBase {
    String getExtension();
    void open();
    void close();
}
