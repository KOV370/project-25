package org.example.project25;

import java.io.*;

public class BuffReaderWriter {
    public static String file;

    public static String consoleReading() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String readingLane = null;
        try {
            readingLane = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readingLane;
    }

    public static FileWriter writeToFile(String file, boolean append) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileWriter;
    }

    public static BufferedReader fileReading(String file) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }
//попытка закрыть программу из любого места
    public static void exitProgramm() {
        if (consoleReading() == String.valueOf(21)) {
           return;
        }
    }
    public static String getFile() {
        return file;
    }

    public static void setFile(String file) {
        BuffReaderWriter.file = file;
    }
}
