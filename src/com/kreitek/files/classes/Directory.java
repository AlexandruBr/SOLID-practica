package com.kreitek.files.classes;

import java.util.ArrayList;
import java.util.List;

import com.kreitek.files.abstract_classes.FileSystemItemBase;
import com.kreitek.files.interfaces.FileSystemBase;
import com.kreitek.files.interfaces.FileSystemDirectory;

public class Directory extends FileSystemItemBase implements FileSystemDirectory {

    private final List<FileSystemBase> files;

    public Directory(FileSystemBase parent, String name) {
        super(parent, name);
        files = new ArrayList<>();
        // Aquí vendría lógica que rellena la lista de ficheros
    }

    @Override
    public List<FileSystemBase> listFiles() {
        return files;
    }

    @Override
    public void addFile(FileSystemBase file) {
        if (!files.contains(file)) {
            files.add(file);
            file.setParent(this);
        }
    }

    @Override
    public void removeFile(FileSystemBase file) {
        files.remove(file);
    }

    @Override
    public int getSize() {

        int size = 0;
        for (FileSystemBase file : files) {
            size += file.getSize();
        }
        return size;
        
    }
}
