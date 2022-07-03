import java.util.Scanner;

public class MineSweeper {
    int rowCount;
    int colCount;
    int mineCount;
    char[][] gameBoard;
    char[][] gameMap;
    int row1;
    int column1;
    int nearStarCount;

    MineSweeper(int row, int col) {
        this.rowCount = row;
        this.colCount = col;
        this.gameBoard = new char[row][col];
        this.gameMap = new char[row][col];
        this.mineCount = ((col * row) / 4);


    }

    void minePosition() {
        for (int i = 0; i < mineCount; i++) {
            while (true) {
                int a = (int) (Math.random() * rowCount);
                int b = (int) (Math.random() * colCount);
                if (gameMap[a][b] != '*')
                    gameMap[a][b] = '*';
                break;
            }
        }
    }

    void printGameMap() {
        System.out.println("Location of the mines");
        minePosition();
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[0].length; j++) {
                if (gameMap[i][j] != '*') {
                    gameMap[i][j] = '-';
                }
                System.out.print(gameMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==============================");
    }

    void elementsGameBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = '-';
            }
        }
    }

    void printGameBoard() {
        for (int i = 0; i < this.gameBoard.length; i++) {
            for (int j = 0; j < this.gameBoard[i].length; j++) {
                System.out.print(this.gameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    void getData() {
        boolean isTrue = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Pls enter the row and column numbers");
        System.out.print("Enter the row number:");
        row1 = (scan.nextInt() - 1);
        System.out.print("Enter the column number:");
        column1 = (scan.nextInt() - 1);
        while (!isTrue) {
            if (row1 < 0 || row1 > gameBoard.length - 1 || column1 < 0 || column1 > gameBoard[0].length - 1) {
                System.out.println("Error! Try again.");
                System.out.print("Enter the row number:");
                row1 = scan.nextInt() - 1;
                System.out.print("Enter the column number:");
                column1 = scan.nextInt() - 1;
            } else
                isTrue = true;
        }
        System.out.println("=========================");
    }

    public int starCountonMap() {

        nearStarCount = 0;
        if (column1 + 1 < gameMap[0].length - 1) {
            if (gameMap[row1][column1 + 1] == '*')
                nearStarCount++;
        }

        if (column1 - 1 >= 0) {
            if (gameMap[row1][column1 - 1] == '*')
                nearStarCount++;
        }

        if (row1 + 1 < gameMap.length - 1) {
            if (gameMap[row1 + 1][column1] == '*')
                nearStarCount++;
        }

        if (row1 - 1 >= 0) {
            if (gameMap[row1 - 1][column1] == '*')
                nearStarCount++;
        }
        if (row1 - 1 >= 0 && column1 - 1 >= 0) {
            if (gameMap[row1 - 1][column1 - 1] == '*')
                nearStarCount++;
        }
        if (row1 - 1 >= 0 && column1 + 1 < gameMap[0].length - 1)
            if (gameMap[row1 - 1][column1 + 1] == '*')
                nearStarCount++;
        if (row1 + 1 < gameMap.length - 1 && column1 - 1 >= 0)
            if (gameMap[row1 + 1][column1 - 1] == '*')
                nearStarCount++;
        if (row1 + 1 < gameMap.length - 1 && column1 + 1 < gameMap[0].length - 1)
            if (gameMap[row1 + 1][column1 + 1] == '*')
                nearStarCount++;
        return nearStarCount;
    }

    public void changeBoardGame() {
        switch (starCountonMap()) {
            case 0:
                gameBoard[row1][column1] = '0';
                gameMap[row1][column1] = '0';
                break;
            case 1:
                gameBoard[row1][column1] = '1';
                gameMap[row1][column1] = '1';
                break;

            case 2:
                gameBoard[row1][column1] = '2';
                gameMap[row1][column1] = '2';
                break;

            case 3:
                gameBoard[row1][column1] = '3';
                gameMap[row1][column1] = '3';
                break;
            case 4:
                gameBoard[row1][column1] = '4';
                gameMap[row1][column1] = '4';
                break;

            case 5:
                gameBoard[row1][column1] = '5';
                gameMap[row1][column1] = '5';
                break;

            case 6:
                gameBoard[row1][column1] = '6';
                gameMap[row1][column1] = '6';
                break;
            case 7:
                gameBoard[row1][column1] = '7';
                gameMap[row1][column1] = '7';
                break;
        }

    }

    boolean checkContinue() {
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[0].length; j++) {
                if (gameMap[i][j] == '-')
                    return false;
            }
        }
        return true;
    }

    public void run() {
        printGameMap();
        System.out.println("Welcome to the minesweeper game ! ");
        System.out.println("-----------------------------------");
        elementsGameBoard();
        printGameBoard();
        while (true) {
            this.getData();
            if (gameMap[row1][column1] == '*') {
                System.out.println("You stepped on a mine.");
                System.out.println("Game Over !!!");
                break;
            } else {
                changeBoardGame();
                printGameBoard();
                if ((checkContinue())) {
                    System.out.println("Congratulations , you win!");
                    break;
                }
            }
        }

    }
}