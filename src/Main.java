import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option = 0, choice = 0, num1 = 0, num2 = 0, result = 0, test = 0;
        char sign = ' '; // знак арифметической операции
        String word1 = "", word2 = "";
        Scanner scan = new Scanner(System.in);

        System.out.println("Калькулятор. Введите арифметический пример с использованием базовых арифметических операций с римскими или арабскими числами от 1 до 10.");
        String operation = scan.nextLine();
        String operationWithoutSpaces = operation.replace(" ", ""); // убираем пробелы в арифметическом действии

        // Операции по определении римских или арабских цифр в примере
        char c = operationWithoutSpaces.charAt(0);

        for (int i = 0; i < operationWithoutSpaces.length(); i++) {
            if (test == 0 && (operationWithoutSpaces.charAt(0) == 'I' || operationWithoutSpaces.charAt(0) == 'V' || operationWithoutSpaces.charAt(0) == 'X')) {
                if (operationWithoutSpaces.charAt(i) == '+' || operationWithoutSpaces.charAt(i) == '/' || operationWithoutSpaces.charAt(i) == '*' || operationWithoutSpaces.charAt(i) == '-') {
                    sign = operationWithoutSpaces.charAt(i);
                    test = 1;
                }
            } else if (test == 1 && (operationWithoutSpaces.charAt(0) == 'I' || operationWithoutSpaces.charAt(0) == 'V' || operationWithoutSpaces.charAt(0) == 'X')) {
                if (operationWithoutSpaces.charAt(i) == 'I' || operationWithoutSpaces.charAt(i) == 'V' || operationWithoutSpaces.charAt(i) == 'X') {
                    option = 1;
                } else {
                    option = 3;
                    choice = 3;
                }
            } else if (test == 0 &&(operationWithoutSpaces.charAt(0) != 'I' || operationWithoutSpaces.charAt(0) != 'V' || operationWithoutSpaces.charAt(0) != 'X')) {
                if (operationWithoutSpaces.charAt(i) == '+' || operationWithoutSpaces.charAt(i) == '/' || operationWithoutSpaces.charAt(i) == '*' || operationWithoutSpaces.charAt(i) == '-') {
                    sign = operationWithoutSpaces.charAt(i);
                    test = 2;
                }
            } else if (test == 2 && (operationWithoutSpaces.charAt(i) == 'I' || operationWithoutSpaces.charAt(i) == 'V' || operationWithoutSpaces.charAt(i) == 'X')) {
                option = 3;
                choice = 3;
            } else {
                option = 2;
            }

        }
        // Вычисление римских или арабских чисел, преобразование их в целые числа типа int, определение арифметического знака
        if (option != 3) {
            for (int i = 0; i < operationWithoutSpaces.length(); i++) {
                c = operationWithoutSpaces.charAt(i);
                if (c == '+' || c == '-' || c == '/' || c == '*') {
                    choice = 1;
                } else {
                    if (choice == 0) {
                        word1 += c;
                    } else if (choice == 1) {
                        word2 += c;
                    }
                }
            }
        }

        if (option == 2) {
            try {
                num1 = Integer.parseInt(word1);
                num2 = Integer.parseInt(word2);
            } catch (NumberFormatException e) {
                // Обработка ошибок преобразования
            }
        }

        if (option == 1) {
            if (word1.equals("I")) {
                num1 = 1;
            } else if (word1.equals("II")) {
                num1 = 2;
            } else if (word1.equals("III")) {
                num1 = 3;
            } else if (word1.equals("IV")) {
                num1 = 4;
            } else if (word1.equals("V")) {
                num1 = 5;
            } else if (word1.equals("VI")) {
                num1 = 6;
            } else if (word1.equals("VII")) {
                num1 = 7;
            } else if (word1.equals("VIII")) {
                num1 = 8;
            } else if (word1.equals("IX")) {
                num1 = 9;
            } else if (word1.equals("X")) {
                num1 = 10;
            }
            if (word2.equals("I")) {
                num2 = 1;
            } else if (word2.equals("II")) {
                num2 = 2;
            } else if (word2.equals("III")) {
                num2 = 3;
            } else if (word2.equals("IV")) {
                num2 = 4;
            } else if (word2.equals("V")) {
                num2 = 5;
            } else if (word2.equals("VI")) {
                num2 = 6;
            } else if (word2.equals("VII")) {
                num2 = 7;
            } else if (word2.equals("VIII")) {
                num2 = 8;
            } else if (word2.equals("IX")) {
                num2 = 9;
            } else if (word2.equals("X")) {
                num2 = 10;
            }
        }

        // Проверка диапазона чисел от 1 до 10, выбор арифметической операции и вывод ее
        if (choice == 1) {
            if (num1 <= 0 || num1 > 10) {
                System.out.println("Ошибка. Первое число не в диапазоне от 1 до 10 или использование букв");
            } else if (num2 <= 0 || num2 > 10) {
                System.out.println("Ошибка. Второе число не в диапазоне от 1 до 10 или использование букв");
            } else {
                switch (sign) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    default:
                        throw new IllegalArgumentException("Неверная операция");
                }
            }
        }

        if(option == 1 && result >= 1) {
            String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
            };
            final String s = roman[result];
            System.out.println("ответ:" +s);
        } else if (option == 1 && result < 1) {
            System.out.println("ОШИБКА. Ответ меньше 1" );
        }
        else if (choice == 1){
            System.out.println("Ответ: "+result );
        }
        if(choice == 3 && option == 3){
            System.out.println("ОШИБКА. Использование римской и арабской системы чисел в арифметических действиях или другая ошибка связанная с буквами.");
        }

        else if(choice == 0 && option == 0){
            System.out.println("Ошибка. Использование букв"); //
        }
    }
}