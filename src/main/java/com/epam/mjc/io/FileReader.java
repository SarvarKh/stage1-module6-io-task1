package com.epam.mjc.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        File file = new File("src/main/resources/Profile.txt");
        fileReader.getDataFromFile(file);
    }

    public Profile getDataFromFile(File file) {
        StringBuilder bld = new StringBuilder();

        try(java.io.FileReader inputStream = new java.io.FileReader(file.getPath());) {
            int c;
            while ((c = inputStream.read()) != -1) {
                bld.append(Character.toString((char) c));
            }
        } catch (IOException e) {
            System.err.print(e);
        }
        String stringContentOfFile = bld.toString();

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
        return profile;
    }
}
