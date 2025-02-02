import java.util.*;

public class Tic_Tack_Toe {

    private static void playerMove(char[][] board, Scanner sc) {
        String playerInput;
        while (true) {
            System.out.println("Where do you want to play? (1-9)");
            playerInput = sc.nextLine();
            if (isValidMove(board, Integer.parseInt(playerInput))) {
                break;
            } else {
                System.out.println("Not a Valid Position!!");
            }
        }
        System.out.println();
        placeMove(board, playerInput, 'X');
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println();
    }

    private static boolean isValidMove(char[][] board, int position) {
        switch (position) {
            case 1:
                return (board[0][0] == ' ');
            case 2:
                return (board[0][1] == ' ');

            case 3:
                return (board[0][2] == ' ');

            case 4:
                return (board[1][0] == ' ');

            case 5:
                return (board[1][1] == ' ');

            case 6:
                return (board[1][2] == ' ');

            case 7:
                return (board[2][0] == ' ');

            case 8:
                return (board[2][1] == ' ');

            case 9:
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    private static void placeMove(char[][] board, String position, char symbol) {
        switch (position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
        }
    }

    private static void computerMove(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (isValidMove(board, computerMove)) {
                break;
            }
        }
        System.out.println("Computer choose " + computerMove);
        placeMove(board, Integer.toString(computerMove), 'O');
        System.out.println();

    }

    private static boolean isGameOver(char[][] board, char key) {
        if (isWinning(board, key)) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game is a tie !!!");
        return true;
    }

    private static boolean isWinning(char[][] board, char key) {
        boolean win;
        for (int row = 0; row < board.length; row++) {
            win = true;
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] != key) {
                    win = false;
                    break;
                }
            }
            if (win) {
                whoWon(key);
                return win;
            }
        }

        for (int column = 0; column < board.length; column++) {
            win = true;
            for (int row = 0; row < board[column].length; row++) {
                if (board[row][column] != key) {
                    win = false;
                }
            }
            if (win) {
                whoWon(key);
                return win;
            }
        }

        win = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != key) {
                win = false;
                break;
            }
        }
        if (win) {
            whoWon(key);
            return win;
        }

        win = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][board.length - i - 1] != key) {
                win = false;
                break;
            }
        }
        if (win) {
            whoWon(key);
            return win;
        }

        return false;
    }

    private static void whoWon(char key) {
        if (key == 'X') {
            System.out.println("Player won the game!!");
        } else {
            System.out.println("Computer won the game!!");
        }
    }

    public static void main(String[] args) {
        char[][] board = { { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' } };

        Scanner sc = new Scanner(System.in);
        printBoard(board);
        while (true) {
            playerMove(board, sc);
            printBoard(board);
            if (isGameOver(board, 'X')) {
                break;
            }

            computerMove(board);
            printBoard(board);
            if (isGameOver(board, 'O')) {
                break;
            }
        }

        // sc.close();
    }

}