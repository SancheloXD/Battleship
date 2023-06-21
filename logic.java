import java.io.IOException;
import java.util.Scanner;

public class logic {
    static Scanner scanner = new Scanner(System.in);

    // Ходы игроков
    public static void move(String playerName, int[][] monitor, int[][] battlefield) {
        while (true) {
            System.out.println(playerName + ", Сделай ход.");
            System.out.println("  0 1 2 3 4 5 6 7 8 9");
            for (int i = 0; i < monitor.length; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < monitor[1].length; j++) {
                    if (monitor[j][i] == 0) {
                        System.out.print("_ ");
                    } else if (monitor[j][i] == 1) {
                        System.out.print(". ");
                    } else {
                        System.out.print("X ");
                    }
                }
                System.out.println();
            }
            System.out.println("Введите значения Х:");
            int x = scanner.nextInt();
            if (x >= 10) {
                System.out.println("Не верное значения Х:");
            }else {
                break;
            }
            System.out.println("Введите значения Y:");
            int y = scanner.nextInt();
            if (y >= 10) {
                System.out.println("Не верное значения Y:");
            }else {
                break;
            }
            if (battlefield[x][y] == 1) {
                System.out.println("Попал! повтори ход!");
                monitor[x][y] = 2;
            } else {
                System.out.println("Не попал! Ход оппонента!");
                monitor[x][y] = 1;
                break;
            }
        }
    }
    // Конструкция выигрыша
    public static boolean win() {
        int counter1 = 0;
        for (int i = 0; i < main.monitor1.length; i++) {
            for (int j = 0; j < main.monitor1[i].length; j++) {
                if (main.monitor1[i][j] == 2) {
                    counter1++;
                }
            }
        }

        int counter2 = 0;
        for (int i = 0; i < main.monitor2.length; i++) {
            for (int j = 0; j < main.monitor2[i].length; j++) {
                if (main.monitor2[i][j] == 2) {
                    counter2++;
                }
            }
        }

        if (counter1 >= 10) {
            System.out.println(main.player1 + " ВЫГРАЛ!!!");
            return true;
        }
        if (counter2 >= 10) {
            System.out.println(main.player2 + " ВЫГРАЛ!!!");
            return true;
        }
        return false;
    }
    // Правила игры
    public static boolean Rules(int x, int y, int deck, int rotation, int[][] battlefield) {
        // проверка на размещение кораблей за поле
        if (rotation == 1) {
            if (y + deck > battlefield.length) {
                return false;
            }
        }
        if (rotation == 2){
            if (x + deck > battlefield[0].length){
                return false;
            }
        }
        // Проверка на расстояние между кораблями
        while (deck!=0){
            for (int i = 0; i < deck; i++) {
                int xi = 0;
                int yi = 0;
                if (rotation == 1){
                    yi = i;
                } else{
                    xi = i;
                }
                if (x + 1 + xi < battlefield.length && x + 1 + xi >= 0){
                    if (battlefield[x + 1 + xi][y + yi]!=0){
                        return false;
                    }
                }
                if (x - 1 + xi < battlefield.length && x - 1 + xi >= 0){
                    if (battlefield[x - 1 + xi][y + yi]!=0){
                        return false;
                    }
                }
                if (y + 1 + yi < battlefield.length && y + 1 + yi >= 0){
                    if (battlefield[x + xi][y + 1 + yi]!=0){
                        return false;
                    }
                }
                if (y - 1 + yi < battlefield.length && y - 1 + yi >= 0){
                    if (battlefield[x + xi][y - 1 + yi]!=0){
                        return false;
                    }
                }
            }
            deck--;
        }
        return true;
    }
}