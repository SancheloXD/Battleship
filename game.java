import java.util.Scanner;

public class game {
    static Scanner scanner = new Scanner(System.in);
    // Размещение кораблей
    public static void Location(String player, int[][] battlefield) {
        int deck = 4;
        while (deck >= 1) {
            System.out.println();
            System.out.println(player + "  Разместите  "+ deck +"-х палубный корабль:");
            System.out.println();

            pole(battlefield);

            System.out.println("Введите значения Х:");
            int x = scanner.nextInt();
            if (x >= 10) {
                System.out.println("Не верное значения Х:");
            }else {
                continue;
            }
            System.out.println("Введите значения Y:");
            int y = scanner.nextInt();
            if (y >= 10) {
                System.out.println("Не верное значения Y:");
            }else {
                continue;
            }
            System.out.println("Положение:");
            System.out.println("1. Вертикально.");
            System.out.println("2. Горизонтально.");
            int Position = scanner.nextInt();
            if (!logic.Rules(x, y, deck, Position, battlefield)){
                System.out.println("Неверные размещение!");
                continue;
            }
            for (int i = 0; i < deck; i++) {
                if (Position == 1) {
                    battlefield[x][y + i] = 1;
                } else {
                    battlefield[x + i][y] = 1;
                }
            }
            deck--;
        }
    }
    // Поле игры
    public static void pole(int[][] battlefield) {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < battlefield.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < battlefield[1].length; j++) {
                if (battlefield[j][i] == 0) {
                    System.out.print("_ ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
