import java.util.Scanner;

public class main {


    static String player1;
    static String player2;
    static Scanner scanner = new Scanner(System.in);
    static int[][] battlefield1 = new int[10][10];
    static int[][] battlefield2 = new int[10][10];
    static int[][] monitor1 = new int[10][10];
    static int[][] monitor2 = new int[10][10];

    public static void main(String[] args) {
        System.out.println("Выберите имя игрока:");
        player1 = scanner.nextLine();
        System.out.println("Выберите имя игрока 2:");
        player2 = scanner.nextLine();
        game.Location(player1, battlefield1);
        game.Location(player2, battlefield2);
        while (true) {
            logic.move(player1, monitor1, battlefield2);
            if (logic.win()) {
                break;
            }
            logic.move(player2, monitor2, battlefield1);
            if (logic.win()) {
                break;
            }
        }

    }

}