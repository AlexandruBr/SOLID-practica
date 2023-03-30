package com.kreitek.files.abstract_classes;

import com.kreitek.files.classes.Directory;
import com.kreitek.files.interfaces.FileSystemBase;

public abstract class FileSystemItemBase implements FileSystemBase {
    protected static final String PATH_SEPARATOR = "/";
    protected String name;
    protected FileSystemBase parent;

    protected FileSystemItemBase(FileSystemBase parent, String name) {
        setName(name);
        setParent(parent);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
       this.name = name;
    }

    @Override
    public FileSystemBase getParent() {
        return parent;
    }

    @Override
    public void setParent(FileSystemBase directory) {
        if (directory != null && !(directory instanceof Directory)) {
            throw new IllegalArgumentException("El padre solo puede ser un directorio");
        }
        if (this.parent != directory) {
            if (this.parent != null) ((Directory) parent).removeFile(this);
            this.parent = directory;
            if (directory != null) ((Directory) directory).addFile(this);
        }
    }

    @Override
    public String getFullPath() {
        String path = PATH_SEPARATOR;
        if (parent != null) {
            String parentFullPath = parent.getFullPath();
            path = parent.getFullPath() + (parentFullPath.length() > 1 ? PATH_SEPARATOR : "");
        }
        path = path + getName();
        return path;
    }

    @Override
    public abstract int getSize();

}
