package com.kreitek.files.interfaces;

import java.util.List;

public interface FileSystemDirectory extends FileSystemBase {

    List<FileSystemBase> listFiles();
    void addFile(FileSystemBase file);
    void removeFile(FileSystemBase file);

}
