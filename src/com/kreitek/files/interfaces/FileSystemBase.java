package com.kreitek.files.interfaces;

public interface FileSystemBase {
    String getName();
    void setName(String name);
    FileSystemBase getParent();
    void setParent(FileSystemBase directory);
    String getFullPath();
    int getSize();
    
}
