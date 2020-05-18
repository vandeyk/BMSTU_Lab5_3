package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File input = new File("input.txt");

        try (Scanner scan = new Scanner(input)) {
            // Ищем наибольшее число цифр идущих подряд
            int res = 0;
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                int b = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (Character.isDigit(s.charAt(i))) {
                        // Если цифра, наращиваем счетчик
                        b++;
                    }
                    else {
                        // Если нет - проверяем, больше ли результат, и сбрасываем
                        if (b > res) res = b;
                        b = 0;
                    }
                }
            }
            System.out.println("Most digits - " + res);
        }
        catch (FileNotFoundException exp) {
            System.out.println("No such file found!");
        }
    }
}
