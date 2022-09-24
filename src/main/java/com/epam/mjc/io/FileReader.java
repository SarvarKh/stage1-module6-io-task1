package com.epam.mjc.io;

import java.io.File;
import java.io.IOException;


public class FileReader {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader();
        File file = new File("src/main/resources/Profile.txt");
        fileReader.getDataFromFile(file);

        java.io.FileReader inputStream = null;
        String stringContentOfFile = "";

        try {
            inputStream = new java.io.FileReader("src/main/resources/Profile.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                stringContentOfFile += Character.toString((char) c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        String[] parsedArg = new String[4];
        String[] keyVals = stringContentOfFile.split("\n");
        for (int i = 0; i < keyVals.length; i++) {
            String[] parts = keyVals[i].split(":",2);
            parsedArg[i] = parts[1].trim();
        }

        Profile profile = new Profile(
                parsedArg[0],
                Integer.valueOf(parsedArg[1]),
                parsedArg[2],
                Long.parseLong(parsedArg[3]));
        System.out.println(profile);
    }

    public Profile getDataFromFile(File file) {
        return new Profile();
    }
}
