import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        double firstOperand;
        char nextOperation;
        boolean work = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Калькулятор ***");
        firstOperand = getOperand(scanner, "Введите первый операнд: ");

        while (work) {
            nextOperation = getOperation(scanner);

            if (nextOperation == 's' || nextOperation == 'S') {
                System.out.println("Завершение работы программы.");
                work = false;
            } else if (nextOperation == 'c' || nextOperation == 'C') {
                firstOperand = getOperand(scanner, "Введите первый операнд: ");
            } else {
                firstOperand = runOperation(firstOperand,
                                            getOperand(scanner, "Введите следующий операнд: "),
                                            nextOperation);
                System.out.println("Текущий результат: ");
                System.out.println(firstOperand);
            }
        }
        scanner.close();
    }

    private static double runOperation(double first, double second, char currentOperation) {
        double result;
        switch (currentOperation) {
            case '+': {
                result = first + second;
                break;
            }
            case '-': {
                result = first - second;
                break;
            }
            case '*': {
                result = first * second;
                break;
            }
            case '/': {
                result = first / second;
                break;
            }

            default: {
                result = first;
            }
        }
        return result;
    }

    private static double getOperand(Scanner s, String str) {
        double operand = 0;
        boolean faultOperand = true;

        System.out.println(str);
        while (faultOperand) {
            if (s.hasNextDouble()) {
                operand = s.nextDouble();
                faultOperand = false;
            } else {
                System.out.println("Неверный операнд. Повторите ввод.");
                s.next();
            }
        }
        return operand;
    }

    private static char getOperation(Scanner s) {
        char operation;
        boolean faultOperation = true;
        do {
            System.out.println("Введите текущую операцию (+),(-),(*),(/),(C - сброс),(S - выход): ");
            operation = s.next().charAt(0);
            switch (operation) {
                case 's':
                case 'S':
                case 'c':
                case 'C':
                case '+':
                case '*':
                case '/':
                case '-': {
                    faultOperation = false;
                    break;
                }
                default: {
                    System.out.println("Неверная операция!!! Повторите ввод.");
                }
            }
        } while (faultOperation);
        return operation;
    }
}
