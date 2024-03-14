package com.myApp;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    protected Map<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<String, String>();
    }

    public void addWord(String eng, String rus) {
        dictionary.put(eng, rus);
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public void save(String path) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(dictionary);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String path) {
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            dictionary = (Map<String, String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


