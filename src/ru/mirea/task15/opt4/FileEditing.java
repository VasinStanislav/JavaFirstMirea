package ru.mirea.task15.opt4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FileEditing {
    public static void main(String[] args)  {
        String fileDir = "";
        for (String param : args) {
            fileDir = param;
        }

        String text = "\n" + ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);
        text = text.concat("\nВ файл добавлена новая информация");

        try (FileOutputStream fos = new FileOutputStream(fileDir, true)) {
            byte[] buffer = text.getBytes();
            fos.write(buffer);
            System.out.print("The file has been edited");
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }
}
