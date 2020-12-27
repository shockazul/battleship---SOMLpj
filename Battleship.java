import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Battleship {
    private static Scanner scanner = new Scanner(System.in);
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";


    public static void main(String[] args) throws InterruptedException {
        while(true){
        Battleship battleship = new Battleship();
        System.out.print("\t\t\t\t\t\t\t\t\t\t");
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.print("\t\t\t\t\t\t\t\t\t\t");
        System.out.print("This is " + userName + "'s board. X's represent your ships");
        System.out.println();

        battleship.playingTheGame();
        System.out.println("Thanks for playing!\nHit 0 to quit, or 1 to play again.");
        int val = scanner.nextInt();
        if(val == 0)
            break;
        }
    }

    // adding ships of varying length to the board
    public String[][] creatingBoard() {
        String[][] gameBoard = {{"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}};
        Random rand = new Random();
        //ships spawn in random positions
        int i = rand.nextInt(6);
        int j = rand.nextInt(6);
        gameBoard[i][j] = "X";
        i = rand.nextInt(6);
        j = rand.nextInt(6);
        for (int k = 0; k < 2; k++) {
            int decider = (int) (Math.random() * 2 + 1);
            if (decider == 1) { //deciding if the ship will be placed horizontally, or vertically
                //ship length of 1
                if (i <= 4 && !gameBoard[i + 1][j].equals("X")) {
                    i++;
                    gameBoard[i][j] = "X";
                } else if (i >= 1 && !gameBoard[i - 1][j].equals("X")) {
                    i--;
                    gameBoard[i][j] = "X";
                } else {
                    i = rand.nextInt(6);
                    j = rand.nextInt(6);
                    k--;
                }
                //ship length of 2
            } else {
                if (j <= 4 && !gameBoard[i][j + 1].equals("X")) {
                    j++;
                    gameBoard[i][j] = "X";
                } else if (j >= 1 && !gameBoard[i][j - 1].equals("X")) {
                    j--;
                    gameBoard[i][j] = "X";
                } else {
                    i = rand.nextInt(6);
                    j = rand.nextInt(6);
                    k--;
                }
            }
        }
        i = rand.nextInt(6);
        j = rand.nextInt(6);
        //ship length of 2
        for (int k = 0; k < 3; k++) {
            int decider = (int) (Math.random() * 2 + 1);
            if (decider == 1) {
                if (i <= 4 && !gameBoard[i + 1][j].equals("X")) {
                    i++;
                    gameBoard[i][j] = "X";
                } else if (i >= 1 && !gameBoard[i - 1][j].equals("X")) {
                    i--;
                    gameBoard[i][j] = "X";
                } else {
                    i = rand.nextInt(6);
                    j = rand.nextInt(6);
                    k--;
                }

            } else {
                if (j <= 4 && !gameBoard[i][j + 1].equals("X")) {
                    j++;
                    gameBoard[i][j] = "X";
                } else if (j >= 1 && !gameBoard[i][j - 1].equals("X")) {
                    j--;
                    gameBoard[i][j] = "X";
                } else {
                    i = rand.nextInt(6);
                    j = rand.nextInt(6);
                    k--;
                }
            }
        }
        return gameBoard;
    }

    public static void displayBoard(String[][] matrix) { //board user will use to track enemy ships
        System.out.println();
        System.out.println("    0    1    2    3    4    5");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(ANSI_BLUE + "[ " + ANSI_RESET + matrix[i][j] + ANSI_BLUE + " ]" + ANSI_RESET);
                if (j == matrix[i].length - 1) System.out.println();
            }
        }
    }

    public static void winBoard(String[][] matrix) { //neater version of board displayed at the end of the game
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(ANSI_BLUE + "[ " + ANSI_RESET + matrix[i][j] + ANSI_BLUE + " ]" + ANSI_RESET);
                if (j == matrix[i].length - 1) System.out.println();
            }
        }
    }


    public static void displayUserBoard(String[][] matrix) { //enemy board displayed to user
        for (String[] strings : matrix) {
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
            for (int j = 0; j < strings.length; j++) {
                System.out.print(ANSI_BLUE + "[ " + ANSI_RESET + strings[j] + ANSI_BLUE + " ]" + ANSI_RESET);
                if (j == strings.length - 1) System.out.println();
            }
        }
    }


    public void playingTheGame() {
        boolean dimension_check = true;
        Random rand = new Random();
        String[][] userCopy = {{"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}};
        String[][] userVisible = {{"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}};
        String[][] internalProcessing = {{"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}};
        String[][] computerVisible = {{"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}};
        String[][] computerCopy = {{"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}};
        String[][] playerBoard = returnPlayerBoard();
        String[][] computerBoard = creatingBoard();
        for (int i = 0; i < playerBoard.length; i++)
            System.arraycopy(playerBoard[i], 0, internalProcessing[i], 0, playerBoard[i].length);
        for (int i = 0; i < playerBoard.length; i++)
            System.arraycopy(playerBoard[i], 0, computerVisible[i], 0, playerBoard[i].length);
        int i = rand.nextInt(6);
        int j = rand.nextInt(6);
        int v = 0;
        int v2 = 0;
        displayUserBoard(computerVisible);
        System.out.println("\nThis is the board you will use to track the enemies ships!\nH for hit, O for miss.");
        while (true) {
            if (Arrays.deepEquals(playerBoard, computerCopy)) { //checking if the computer wins
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tComputer Wins");
                displayUserBoard(computerVisible);
                System.out.println("Computer's Board");
                winBoard(computerBoard);
                winBoard(userVisible);
                System.out.println(ANSI_RED + "You lose!" + ANSI_RESET);
                break;
            }
            if (Arrays.deepEquals(computerBoard, userCopy)) { //checking if the computer wins
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                winBoard(userVisible);
                System.out.println(ANSI_CYAN + "You win!" + ANSI_RESET);
                break;
            }

            if (playerBoard[i][j].equals("X") | internalProcessing[i][j].equals("H") | internalProcessing[i][j].equals("T")) {
                computerVisible[i][j] = (ANSI_RED + "H" + ANSI_RESET);
                computerCopy[i][j] = "X";
                internalProcessing[i][j] = ("H");
                v = i;
                v2 = j;
                if (dimension_check && i != 5 && !internalProcessing[i + 1][j].equals("O") && !internalProcessing[i + 1][j].equals("T")) {
                    i++;
                    while (internalProcessing[i][j].equals("H") && i != 5) {
                        computerVisible[i][j] = (ANSI_RED + "H" + ANSI_RESET);
                        internalProcessing[i][j] = "T";//T values cannot be reaccessed. They are set and never returned to
                        i++;
                    }
                    continue;//skipping the users turn

                } else if (dimension_check && i != 0 && !internalProcessing[i - 1][j].equals("O") && !internalProcessing[i - 1][j].equals("T")) {
                    i--;
                    while (internalProcessing[i][j].equals("H") && i != 0) {
                        computerVisible[i][j] = (ANSI_RED + "H" + ANSI_RESET);
                        internalProcessing[i][j] = "T";
                        i--;
                    }
                    continue;

                } else if (j != 0 && !internalProcessing[i][j - 1].equals("O") && !internalProcessing[i][j - 1].equals("T")) {
                    j--;
                    while (internalProcessing[i][j].equals("H") && j != 0) {
                        computerVisible[i][j] = (ANSI_RED + "H" + ANSI_RESET);
                        internalProcessing[i][j] = "T";
                        j--;
                    }
                    dimension_check = false; //horizontally oriented
                    continue;

                } else if (j != 5 && !internalProcessing[i][j + 1].equals("O") && !internalProcessing[i][j + 1].equals("T")) {
                    j++;
                    while (internalProcessing[i][j].equals("H") && j != 5) {
                        computerVisible[i][j] = (ANSI_RED + "H" + ANSI_RESET);
                        internalProcessing[i][j] = "T";
                        j++;
                    }
                    dimension_check = false; // horizontally oriented
                    continue;

                } else {
                    internalProcessing[i][j] = "T";
                    do {
                        i = rand.nextInt(6);
                        j = rand.nextInt(6);
                    } while (internalProcessing[i][j].equals("T") | internalProcessing[i][j].equals("O"));
                    continue;
                }
            } else {
                internalProcessing[i][j] = "O";
                computerVisible[i][j] = "O";
                if (internalProcessing[v][v2].equals("H")) { //set back to last known HIT position
                    i = v;
                    j = v2;
                } else {
                    dimension_check = true; // reset
                    while (internalProcessing[i][j].equals("O")) { //else (worse case only) find a new random position
                        i = rand.nextInt(6);
                        j = rand.nextInt(6);
                    }
                }
            }
            int val = 0;
            int val2 = 0;
            boolean checker;
            do {
                displayBoard(userVisible);
                System.out.println("Enter the row number & column number: ");
                val = scanner.nextInt();
                val2 = scanner.nextInt();
                if (val > 5 | val2 > 5) {
                    System.out.println(ANSI_RED + "The value must be between 0 and 5 (inclusive)" + ANSI_RESET);
                    checker = true;
                    continue;
                }
                if (userVisible[val][val2].equals("O") | userVisible[val][val2].equals("H")) {
                    System.out.println(ANSI_RED + "You have already picked this position." + ANSI_RESET);
                    checker = true;
                    continue;
                }
                if (computerBoard[val][val2].equals("X")) {
                    checker = false;
                    System.out.println("DIRECT HIT!");
                    userCopy[val][val2] = "X";
                    userVisible[val][val2] = ANSI_RED + "H" + ANSI_RESET;
                } else {
                    checker = false;
                    userVisible[val][val2] = "O";
                }


            } while (checker || computerBoard[val][val2].equals("X") && !Arrays.deepEquals(computerBoard, userCopy));
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tComputer's Turn");

            displayUserBoard(computerVisible);
        }
    }

    public String[][] returnPlayerBoard() {
        String[][] gameboard = creatingBoard();
        return gameboard;
    }
}
