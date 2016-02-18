package java;

import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        try {
            // Читаем текстовый файл
            String text = new String(Files.readAllBytes(Paths.get("10_ReadTextDemo\\text.txt")), "UTF-8");
            // Выводим его содержимое в консоль
            System.out.println(text);
            // Показываем содержимое файла пользователю в диалоговом окне
            JOptionPane.showMessageDialog(null, text, "Текст", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            // Выводим диалог с его содержимым на экран
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
