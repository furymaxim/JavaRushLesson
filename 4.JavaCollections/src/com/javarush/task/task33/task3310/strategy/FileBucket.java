package com.javarush.task.task33.task3310.strategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize(){
        try {
            return Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void putEntry(Entry entry){
        try {
            try(ObjectOutputStream oos = new ObjectOutputStream( Files.newOutputStream(path))) {
                oos.writeObject(entry);
                Entry entry1;
                while ((entry1 = entry.next) != null) {
                    oos.writeObject(entry1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Entry getEntry()  {
        if(getFileSize() == 0) return null;
        try {
            try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
                return (Entry) ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}