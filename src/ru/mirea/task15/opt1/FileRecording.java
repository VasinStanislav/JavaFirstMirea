package ru.mirea.task15.opt1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FileRecording {
    public static void main(String[] args) {
        String fileDir = "";
        for (String param : args) {
            fileDir = param;
        }

        File newFile = new File(fileDir);

        try {
            boolean created = newFile.createNewFile();
            if (created) {
                System.out.println("File has been created");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        String text = ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);
        text = text.concat("\nПроизведена запись в файл");

        try (FileOutputStream fos = new FileOutputStream(newFile)) {
            byte[] buffer = text.getBytes();
            fos.write(buffer);
            System.out.print("The file has been written");
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }


    }
}
