package com.kreitek.utils;

import com.kreitek.files.classes.Directory;
import com.kreitek.files.interfaces.FileSystemBase;
import com.kreitek.service.FileManager;

public class FileSystemPrinter {

    private final FileManager fileManager;

    public FileSystemPrinter() {
        this.fileManager = new FileManager();
    }

    public static void print(FileSystemBase item, int nivel) {
        String indentation = "\t".repeat(nivel);
        String message = String.format("%s%s = %d bytes", indentation, item.getFullPath(), FileManager.calculateSize(item));
        System.out.println(message);

        if (item instanceof Directory) {
            for (FileSystemBase subitem: ((Directory) item).listFiles()) {
                FileSystemPrinter.print(subitem, nivel + 1);
            }
        }

    }

}
