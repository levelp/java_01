import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Демонстрация: чтение из файла + ввод от пользователя
 */
public class MyClass {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));

        // Открываем файл
        File poDrugomu; // File - тип переменной, poDrugomu - имя
        poDrugomu = new File("08_ConsoleDemo\\data.txt");
        // Text, TextFile

        // Читаем из файла
        Scanner s = new Scanner(poDrugomu);

        System.out.println("=== ТЕСТ ПРО ЖИВОТНЫХ ===");

//        System.out.println("Загадайте животное, я буду угадывать животное, задавать вам вопросы");
        // Программа угадывает жив

        List<Animal> list = new ArrayList<>();

        while (s.hasNextLine()) {
            // Создаём новое животное
            Animal animal = new Animal();
            // Имя
            animal.name = s.next();
            if (animal.name.isEmpty())
                break;
            // Пропускаем тире (минус)
            s.next();
            // Описание животного
            animal.description = s.nextLine();

            // Добавляем его в список животных
            list.add(animal);
        }

        Random gen = new Random();

        // Задумываем животное из списка
        int rightAnimalIndex = gen.nextInt(list.size());
        Animal rightAnimal = list.get(rightAnimalIndex);
        System.out.println("Я задумал: " + rightAnimal.description);

        // Составили список из 4-х животных
        // Одно задуманное (верное)
        // И ещё 3 случайных
        List<Animal> choice = new ArrayList<>();
        choice.add(rightAnimal);
        list.remove(rightAnimal);

        // Количество животных (сложность для пользователя)
        int numberOfAnimals = 4;
        while (choice.size() < numberOfAnimals) {
            Animal animal = list.get(gen.nextInt(list.size()));
            choice.add(
                    gen.nextInt(choice.size() + 1),
                    animal);
            list.remove(animal);
        }

        // Теперь мы выводим список животных
        for (int i = 0; i < choice.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + choice.get(i).name);
        }

        Scanner keyboard = new Scanner(System.in);
        int userChoice;
        do {
            System.out.print("Какое животное я задумал? Введите число от 1 до " + choice.size() + ": ");
            userChoice = keyboard.nextInt();
        } while (userChoice < 1 || userChoice > choice.size());

        // Нумерация для пользователя с 1
        // А внутри программы индексы с 0
        Animal userAnimal = choice.get(userChoice - 1);

        if (userAnimal.name.equals(rightAnimal.name)) {
            System.out.println("Вы угадали, это действительно " + rightAnimal.name);
        } else {
            System.out.println("Нет, я загадал \"" +
                    rightAnimal.name + "\", " +
                    "а вы выбрали \"" + userAnimal.name + "\"");
        }


    }
}
