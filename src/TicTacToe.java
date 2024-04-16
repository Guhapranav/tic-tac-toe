import java.util.Scanner;

public class TicTacToe {
    public static void welcome(String[][] playBoard) {
        System.out.println("Welcome to Tic-Tac-Toe");

        //Representation of the tictactoe Board
        System.out.printf("1 | 2 | 3 %n--|---|--%n" +
                "4 | 5 | 6 %n--|---|--%n" +
                "7 | 8 | 9 %n");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                playBoard[i][j] = "";
            }
        }
    }

    public static String[][] marker(String[][] playBoard, String mark, int posMark) {

        switch (posMark) {
            case 1 -> playBoard[0][0] = (playBoard[0][0].isEmpty()) ? mark : playBoard[0][0];
            case 2 -> playBoard[0][1] = (playBoard[0][1].isEmpty()) ? mark : playBoard[0][1];
            case 3 -> playBoard[0][2] = (playBoard[0][2].isEmpty()) ? mark : playBoard[0][2];
            case 4 -> playBoard[1][0] = (playBoard[1][0].isEmpty()) ? mark : playBoard[1][0];
            case 5 -> playBoard[1][1] = (playBoard[1][1].isEmpty()) ? mark : playBoard[1][1];
            case 6 -> playBoard[1][2] = (playBoard[1][2].isEmpty()) ? mark : playBoard[1][2];
            case 7 -> playBoard[2][0] = (playBoard[2][0].isEmpty()) ? mark : playBoard[2][0];
            case 8 -> playBoard[2][1] = (playBoard[2][1].isEmpty()) ? mark : playBoard[2][1];
            case 9 -> playBoard[2][2] = (playBoard[2][2].isEmpty()) ? mark : playBoard[2][2];
            default -> {
                System.out.println("Alert: Enter number in range");
            }
        }
        return playBoard;
    }

    public static String[][] display(String[][] playBoard) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 2)
                    System.out.print(playBoard[i][j]);
                else
                    System.out.print(playBoard[i][j] + " | ");
            }
            System.out.println();
            System.out.println("--|---|--");
        }

        return playBoard;
    }

    public static boolean isWinner(String[][] playBoard) {
        int j = 0;

        //row winner
        for (int i = 0; i < 3; i++) {
            if ("X".equals(playBoard[i][j]) && "X".equals(playBoard[i][j + 1]) && "X".equals(playBoard[i][j + 2])) {
                System.out.println("X wins");
                return true;
            } else if ("O".equals(playBoard[i][j]) && "O".equals(playBoard[i][j + 1]) && "O".equals(playBoard[i][j + 2])) {
                System.out.println("O wins");
                return true;
            }
        }

        int i = 0;

        //column winner
        for (j = 0; j < 3; j++) {
            if ("X".equals(playBoard[i][j]) && "X".equals(playBoard[i + 1][j]) && "X".equals(playBoard[i + 2][j])) {
                System.out.println("X wins");
                return true;
            } else if ("O".equals(playBoard[i][j]) && "O".equals(playBoard[i + 1][j]) && "O".equals(playBoard[i + 2][j])) {
                System.out.println("O wins");
                return true;
            }
        }

        //diagonal winner
        if ("X".equals(playBoard[0][0]) && "X".equals(playBoard[1][1]) && "X".equals(playBoard[2][2])) {
            System.out.println("X wins");
            return true;
        } else if ("O".equals(playBoard[0][0]) && "O".equals(playBoard[1][1]) && "O".equals(playBoard[2][2])) {
            System.out.println("O wins");
            return true;
        } else if ("X".equals(playBoard[0][2]) && "X".equals(playBoard[1][1]) && "X".equals(playBoard[2][0])) {
            System.out.println("X wins");
            return true;
        } else if ("O".equals(playBoard[0][2]) && "O".equals(playBoard[1][1]) && "O".equals(playBoard[2][0])) {
            System.out.println("O wins");
            return true;
        } else {
            return false;
        }

    }

    //user inputs can be enhanced for edge cases with exceptions
    public static void main(String[] args) {

        //Declarations
        Scanner sc = new Scanner(System.in);
        String[][] playBoard = new String[3][3];//global
        String[][] trailBoard = new String[3][3];
        String mark1 = "";
        String mark2 = "";
        int posMark = 0;//mark X / O
        int playerTurn = 0;//switch turns
        boolean isPlay = false;//play continue?
        int count = 0;
        welcome(playBoard);


        //User interactions

        System.out.println("Player1: Choose a mark <X> or <O>: ");
        mark1 = sc.next();

        if (mark1.equals("X"))
            mark2 = "O";
        else
            mark2 = "X";

        while (!isPlay) {
            if (playerTurn % 2 == 0) {//player1 plays
                System.out.println("Player1: Enter a " + mark1 + "in position #1 to #9: ");
                posMark = sc.nextInt();//mark
                sc.nextLine();

                marker(playBoard, mark1, posMark);//mark is locally updating we need to correct this!

                display(playBoard);
                isPlay = isWinner(playBoard);
                playerTurn++;
            } else {
                System.out.println("Player2: Enter a" + mark2 + "in position #1 to #9: ");
                posMark = sc.nextInt();
                sc.nextLine();

                marker(playBoard, mark2, posMark);

                display(playBoard);
                isPlay = isWinner(playBoard);
                playerTurn++;
            }

        }


    }
}