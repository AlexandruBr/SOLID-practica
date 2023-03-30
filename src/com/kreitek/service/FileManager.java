package com.kreitek.service;

import com.kreitek.files.classes.Directory;
import com.kreitek.files.classes.File;
import com.kreitek.files.interfaces.FileSystemBase;

import java.util.List;

public class FileManager {

    public static int calculateSize(FileSystemBase fileSystemItem) {
        int totalSize = 0;

        if (fileSystemItem instanceof File) {
            totalSize = fileSystemItem.getSize();
        } else if (fileSystemItem instanceof Directory) {
            for (FileSystemBase item : ((Directory) fileSystemItem).listFiles()) {
                totalSize += calculateSize(item);
            }
        }

        return totalSize;
    }

    public static int calculateSize(List<FileSystemBase> fileSystemItems) {
        int totalSize = 0;

        for (FileSystemBase item : fileSystemItems) {
            totalSize += calculateSize(item);
        }

        return totalSize;
    }

    // Aquí habría otros métodos para gestionar ficheros y directorios:
    // Crear ficheros, mover ficheros, eliminar ficheros, etc.
}
