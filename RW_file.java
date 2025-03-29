package Aston;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class RW_file 
{
    
    public static void main (String[] args) throws NoSuchFieldException, FileNotFoundException, IOException
    {
        File readFile = new File("C:\\Users\\l_kuk\\Documents\\GitHub\\JavaLessons\\Aston\\ДЗ 4 занятия.txt");
        try (FileInputStream inputStream = new FileInputStream(readFile))
        {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1)
            {
                System.out.println(new String(buffer, 0, bytesRead));
            }
            inputStream.close();
        }
        finally
        {
            System.out.println("Файл прочтён и закрыт.");
        }

        File newFile = new File("C:\\Users\\l_kuk\\Documents\\GitHub\\JavaLessons\\Aston\\Новый.txt");
        try (FileOutputStream outputStream = new FileOutputStream(newFile))
        {
            byte[] buffer = "Данные нового файла".getBytes();
            outputStream.write(buffer);
            outputStream.close();
        }
        finally
        {
            System.out.println("Записан новый файл Новый.txt.");
        }

    }
}
