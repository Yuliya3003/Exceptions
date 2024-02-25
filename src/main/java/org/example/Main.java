package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExceptionsCatcher catcher = new ExceptionsCatcher();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите ФИО через пробел: ");
            String fullName = scanner.nextLine();
            catcher.checkDataQuantity(fullName, "fio");
            catcher.checkDataQuality(fullName, "fio");
            System.out.println("Введите дату рождения в формате dd.mm.yyyy: ");
            String birthday = scanner.nextLine();
            catcher.checkDataQuantity(birthday, "birthday");
            catcher.checkDataQuality(birthday, "birthday");
            System.out.println("Введите номер телефона цифрами без пробелов и других символов: ");
            String number = scanner.nextLine();
            catcher.checkDataQuantity(number, "number");
            catcher.checkDataQuality(number, "number");
            System.out.println("Введите пол (f/m): ");
            String sex = scanner.nextLine();
            catcher.checkDataQuantity(sex, "sex");
            catcher.checkDataQuality(sex, "sex");
            ArrayList<String> line = new ArrayList<>();
            String[] elemOfFullName = fullName.split(" ");
            line.add(elemOfFullName[0]);
            line.add(elemOfFullName[1]);
            line.add(elemOfFullName[2]);
            line.add(birthday);
            line.add(number);
            line.add(sex);

            writeToFile(elemOfFullName[0], line);

        } catch (DataQuantityMismatchException e) {
            e.printStackTrace();
        } catch (DataQualityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void writeToFile(String surname, ArrayList<String> str) throws IOException {
        File file = new File(surname + ".txt");
        boolean appendToFile = file.exists();

        try (FileWriter fileWriter = new FileWriter(file, appendToFile)) {
            if (appendToFile) {
                fileWriter.write("\n");
            }
            fileWriter.write(String.format("<%s> <%s> <%s> <%s> <%s> <%s>",
                    str.get(0), str.get(1), str.get(2), str.get(3), str.get(4), str.get(5)));
            System.out.println("Данные успешно добавлены в файл!");
        }

    }
}