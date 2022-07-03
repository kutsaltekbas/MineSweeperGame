import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the row count:");
        int rowCount= scan.nextInt();
        System.out.print("Enter the column count:");
        int columnCount= scan.nextInt();
        MineSweeper minesweeper = new MineSweeper(rowCount, columnCount);
        minesweeper.run();
    }
}