package com.kreitek.utils;

import com.kreitek.files.classes.Directory;
import com.kreitek.files.classes.File;
import com.kreitek.files.interfaces.FileSystemDirectory;
import com.kreitek.files.interfaces.FileSystemFile;

public class FileSystemBuilder {

    private final FileSystemDirectory root;
    private FileSystemDirectory currentDirectory;

    public static FileSystemBuilder getBuilder() {
        return new FileSystemBuilder();
    }

    public FileSystemBuilder() {
        root = new Directory(null, "");
        currentDirectory = root;
    }

    public FileSystemBuilder addFile(String name, int size) {
        FileSystemFile file = new File(currentDirectory, name);
        file.open();
        file.write(new byte[size]);
        file.close();
        currentDirectory.addFile(file);
        return this;
    }

    public FileSystemBuilder addDirectory(String name) {
        FileSystemDirectory directory = new Directory(currentDirectory, name);
        currentDirectory.addFile(directory);
        currentDirectory = directory;
        return this;
    }

    public FileSystemBuilder upOneDirectory() {
        if (currentDirectory.getParent() != null) {
            currentDirectory = (FileSystemDirectory) currentDirectory.getParent();
        }
        return this;
    }

    public FileSystemDirectory build() {
        return root;
    }
}
