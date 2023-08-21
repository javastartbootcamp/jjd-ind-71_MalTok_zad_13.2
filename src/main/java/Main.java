import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run(new Scanner(System.in));
    }

    public void run(Scanner scanner) {
        // napisz swój program tutaj. Do wczytywania danych użyj przekazanego w parametrze scannera
        try {
            ListCalculator listCalc = new ListCalculator();
            List<Integer> list = getIntegersList(scanner);
            if (list.isEmpty()) {
                System.out.println("Lista jest pusta, nie można wyświetlić statystyk");
            } else {
                StringBuilder reversedListFormat = getReversedListFormat(list);
                System.out.println("Odwrócona lista: ");
                System.out.println(reversedListFormat);

                StringBuilder summedListFormat = getSummedListFormat(list);
                System.out.println("Suma wszystkich liczb w liście: ");
                System.out.println(summedListFormat + " = " + listCalc.countSum(list));

                System.out.println("Najmniejsza liczba w liście to " + listCalc.getLowestNumber(list));
                System.out.println("Największa liczba w liście to " + listCalc.getHighestNumber(list));
            }
        } catch (InputMismatchException e) {
            System.err.println("Nie podano liczby tylko napis");
        }
    }

    private List<Integer> getIntegersList(Scanner scanner) {
        List<Integer> list = new ArrayList<>();
        boolean correctNumber = true;
        do {
            System.out.println("Podaj liczbę dodatnią");
            int userNumber = scanner.nextInt();
            if (!isPositive(userNumber)) {
                correctNumber = false;
            } else if (isPositive(userNumber)) {
                list.add(userNumber);
            } else {
                throw new InputMismatchException("Must be a number");
            }
        } while (correctNumber);
        return list;
    }

    private boolean isPositive(int userNumber) {
        return userNumber >= 0;
    }

    private StringBuilder getSummedListFormat(List<Integer> list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                builder.append(list.get(i));
            } else {
                builder.append(list.get(i)).append(" + ");
            }
        }
        return builder;
    }

    private StringBuilder getReversedListFormat(List<Integer> list) {
        int lastElementIndex = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = list.size() - 1; i >= lastElementIndex; i--) {
            if (i == lastElementIndex) {
                builder.append(list.get(i));
            } else {
                builder.append(list.get(i)).append(", ");
            }
        }
        return builder;
    }
}