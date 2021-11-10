package ru.mirea.task15.opt3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FileRewriting {
    public static void main(String[] args)  {
        String fileDir = "";
        for (String param : args) {
            fileDir = param;
        }

        String text = ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);
        text = text.concat("\nФайл переписан");

        try (FileOutputStream fos = new FileOutputStream(fileDir, false)) {
            byte[] buffer = text.getBytes();
            fos.write(buffer);
            System.out.print("The file has been rewritten");
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }
}
