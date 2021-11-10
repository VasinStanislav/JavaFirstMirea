package ru.mirea.task15.opt2;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileReading {
    public static void main(String[] args) throws FileNotFoundException{
        String fileDir = "";
        for (String param : args) {
            fileDir = param;
        }

        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(fileDir), StandardCharsets.UTF_8));
            String str;
            System.out.println("File has been read");
            System.out.println("File data:");
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
