package com.kreitek.files.classes;

import com.kreitek.files.interfaces.FileSystemConverter;
import com.kreitek.files.abstract_classes.FileSystemItemBase;
import com.kreitek.files.error.InvalidFileFormatException;
import com.kreitek.files.interfaces.FileSystemBase;

public class Converter extends FileSystemItemBase implements FileSystemConverter{

    private int size = 0;
    private boolean isOpen = false;

    protected Converter(FileSystemBase parent, String name) {
        super(parent, name);
    }

    @Override
    public void open() {
        isOpen = true;
        // Aquí vendría código que actualizaría también this.size
    }

    @Override
    public void close() {
        isOpen = false;
    }

    @Override
    public String getExtension() {
        String extension = "";
        int indexOfLastDot = getName().lastIndexOf(".");
        if (indexOfLastDot > 0) {
            extension = getName().substring(indexOfLastDot + 1);
        }
        return extension;
    }

    @Override
    public int getSize() {
        return size;
    }

    public FileSystemBase convertMp3ToWav() {
        if (!"mp3".equalsIgnoreCase(getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser mp3");
        }

        int indexOfLastDot = name.lastIndexOf(".");
        String nameWithoutExtension = name;
        if (indexOfLastDot > 0) {
            nameWithoutExtension = name.substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".wav";
        FileSystemBase result = new File(parent, newFileName);
        ((FileSystemConverter) result).open();
        // Lógica de conversión de mp3 a wav. Se lee de este fichero y se escribe en result
        ((FileSystemConverter) result).close();
        
        return result;
    }

    public FileSystemBase convertWavToMp3() {
        if (!"wav".equalsIgnoreCase(getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser wav");
        }

        int indexOfLastDot = name.lastIndexOf(".");
        String nameWithoutExtension = name;
        if (indexOfLastDot > 0) {
            nameWithoutExtension = name.substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".mp3";
        FileSystemBase result = new File(parent, newFileName);
        ((FileSystemConverter) result).open();
        // Lógica de conversión de wav a mp3. Se lee de este fichero y se escribe en result
        ((FileSystemConverter) result).close();

        return result;
    }
}
