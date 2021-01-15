import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Battleship {
    private static Scanner scanner = new Scanner(System.in);
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    private static int user_count, computer_count, ship_count;


    public static void main(String[] args) throws InterruptedException {
        
            Battleship battleship = new Battleship();
            System.out.print("\t\t\t\t\t\t\t\t\t\t");
            System.out.print("Enter your name: ");
            String userName = scanner.nextLine();
            System.out.print("\t\t\t\t\t\t\t\t\t\t");
            System.out.print("This is " + userName + "'s board. X's represent your ships.\n\t\t\t\t\t\t\t\t\t\tYou can use this board to track the computer's movements.");
            while (true) {    
                user_count = 0;
                computer_count = 0;
                ship_count = 0;    
                System.out.println();
                battleship.playingTheGame();
                System.out.println("\nThanks for playing!\nHit 0 to quit, or 1 to play again.");
                int val = scanner.nextInt();
                if (val == 0)
                    break;
            }
    }

    public String[][] creatingBoard() {
        String[][] gameBoard = {{"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}, {"~", "~", "~", "~", "~", "~"}};
        Random rand = new Random();
        int i = rand.nextInt(6);
        int j = rand.nextInt(6);
        //length 3
        while (true) {
            int direction = rand.nextInt(2);
            if (direction == 0) { //vertical
                if (gameBoard[i][j].equals("X")) {
                    i = rand.nextInt(6);
                    j = rand.nextInt(6);
                    continue;
                }
                if (i == 5) {
                    if (gameBoard[i - 1][j].equals("X"))
                        continue;

                    if (gameBoard[i - 2][j].equals("X"))
                        continue;
                    for (int k = i; k >= i - 2; k--)
                        gameBoard[k][j] = "X";
                    break;
                }
                if (i == 0) {
                    if (gameBoard[i + 1][j].equals("X"))
                        continue;

                    if (gameBoard[i + 2][j].equals("X"))
                        continue;

                    for (int k = i; k <= i + 2; k++)
                        gameBoard[k][j] = "X";
                    break;
                }
                if (i == 4) {
                    if (gameBoard[i - 1][j].equals("X"))
                        continue;
                    if (gameBoard[i - 2][j].equals("X") && gameBoard[i + 1][j].equals("X"))
                        continue;
                    int rand_check = rand.nextInt(2);

                    if (rand_check == 1) {
                        for (int k = i; k >= i - 2; k--)
                            gameBoard[k][j] = "X";
                        break;
                    } else {
                        int k = i;
                        gameBoard[k][j] = "X";
                        gameBoard[++k][j] = "X";
                        gameBoard[--i][j] = "X";
                        break;
                    }
                }
                if (i == 1) {

                    if (gameBoard[i + 1][j].equals("X"))
                        continue;
                    if (gameBoard[i + 2][j].equals("X") && gameBoard[i - 1][j].equals("X"))
                        continue;
                    int rand_check = rand.nextInt(2);

                    if (rand_check == 1) {
                        for (int k = i; k <= i + 2; k++)
                            gameBoard[k][j] = "X";
                        break;
                    } else {
                        int k = i;
                        gameBoard[k][j] = "X";
                        gameBoard[++k][j] = "X";
                        gameBoard[--i][j] = "X";
                        break;
                    }
                }

                if (gameBoard[i - 1][j].equals("X") && gameBoard[i + 1][j].equals("X"))
                    continue;
                if (gameBoard[i - 2][j].equals("X") && gameBoard[i + 2][j].equals("X"))
                    continue;
                int rand_check = rand.nextInt(2);
                if (rand_check == 1) {
                    for (int k = i; k <= i + 2; k++)
                        gameBoard[k][j] = "X";
                    break;
                } else {
                    for (int k = i; k >= i - 2; k--)
                        gameBoard[k][j] = "X";
                    break;
                }
            } else {
                //horizontal
                if (gameBoard[i][j].equals("X")) {
                    i = rand.nextInt(6);
                    j = rand.nextInt(6);
                    continue;
                }
                if (j == 5) {
                    if (gameBoard[i][j - 1].equals("X"))
                        continue;

                    if (gameBoard[i][j - 2].equals("X"))
                        continue;

                    for (int k = j; k >= j - 2; k--)
                        gameBoard[i][k] = "X";
                    break;
                }
                if (j == 0) {
                    if (gameBoard[i][j + 1].equals("X"))
                        continue;

                    if (gameBoard[i][j + 2].equals("X"))
                        continue;

                    for (int k = j; k <= j + 2; k++)
                        gameBoard[i][k] = "X";
                    break;
                }
                if (j == 4) {
                    if (gameBoard[i][j - 1].equals("X"))
                        continue;
                    if (gameBoard[i][j - 2].equals("X") && gameBoard[i][j + 1].equals("X"))
                        continue;
                    int rand_check = rand.nextInt(2);
                    ;
                    if (rand_check == 1) {
                        for (int k = j; k >= j - 2; k--)
                            gameBoard[i][k] = "X";
                        break;
                    } else {
                        int k = j;
                        gameBoard[i][k] = "X";
                        gameBoard[i][++k] = "X";
                        gameBoard[i][--j] = "X";
                        break;
                    }
                }
                if (j == 1) {
                    if (gameBoard[i][j + 1].equals("X"))
                        continue;
                    if (gameBoard[i][j + 2].equals("X") && gameBoard[i][j - 1].equals("X"))
                        continue;
                    int rand_check = rand.nextInt(2);
                    ;
                    if (rand_check == 1) {
                        for (int k = j; k <= j + 2; k++)
                            gameBoard[i][k] = "X";
                        break;
                    } else {
                        int k = j;
                        gameBoard[i][k] = "X";
                        gameBoard[i][++k] = "X";
                        gameBoard[i][--j] = "X";
                        break;
                    }
                }

                if (gameBoard[i][j - 1].equals("X") && gameBoard[i][j + 1].equals("X"))
                    continue;
                if (gameBoard[i][j - 2].equals("X") && gameBoard[i][j + 2].equals("X"))
                    continue;
                int rand_check = rand.nextInt(2);
                if (rand_check == 1) {
                    for (int k = j; k <= j + 2; k++)
                        gameBoard[i][k] = "X";
                    break;
                } else {
                    for (int k = j; k >= j - 2; k--)
                        gameBoard[i][k] = "X";
                    break;
                }
            }
        }
        //ship length 2
        while (true) {
            int direction = rand.nextInt(2);
            if (direction == 0) { //vertical
                if (gameBoard[i][j].equals("X")) {
                    i = rand.nextInt(6);
                    j = rand.nextInt(6);
                    continue;
                }
                if (i == 5) {
                    if (gameBoard[i - 1][j].equals("X"))
                        continue;

                    for (int k = i; k > i - 2; k--)
                        gameBoard[k][j] = "X";
                    break;
                }
                if (i == 0) {
                    if (gameBoard[i + 1][j].equals("X"))
                        continue;

                    for (int k = i; k < i + 2; k++)
                        gameBoard[k][j] = "X";
                    break;
                }
                if (i == 4) {
                    if (gameBoard[i - 1][j].equals("X") && gameBoard[i + 1][j].equals("X"))
                        continue;
                    gameBoard[i][j] = "X";
                    if (gameBoard[i - 1][j].equals("X"))
                        gameBoard[++i][j] = "X";
                    else
                        gameBoard[--i][j] = "X";
                    break;
                }
                if (i == 1) {
                    if (gameBoard[i + 1][j].equals("X") && gameBoard[i - 1][j].equals("X"))
                        continue;
                    gameBoard[i][j] = "X";
                    if (gameBoard[i - 1][j].equals("X"))
                        gameBoard[++i][j] = "X";
                    else
                        gameBoard[--i][j] = "X";
                    break;
                }

                if (gameBoard[i - 1][j].equals("X") && gameBoard[i + 1][j].equals("X"))
                    continue;
                gameBoard[i][j] = "X";

                if (gameBoard[i - 1][j].equals("X"))
                    gameBoard[++i][j] = "X";
                else
                    gameBoard[--i][j] = "X";
                break;

            } else {
                //horizontal
                if (gameBoard[i][j].equals("X")) {
                    i = rand.nextInt(6);
                    j = rand.nextInt(6);
                    continue;
                }
                if (j == 5) {
                    if (gameBoard[i][j - 1].equals("X"))
                        continue;

                    for (int k = j; k > j - 2; k--)
                        gameBoard[i][k] = "X";
                    break;
                }
                if (j == 0) {
                    if (gameBoard[i][j + 1].equals("X"))
                        continue;

                    for (int k = j; k < j + 2; k++)
                        gameBoard[i][k] = "X";
                    break;
                }
                if (j == 4) {
                    if (gameBoard[i][j - 1].equals("X") && gameBoard[i][j + 1].equals("X"))
                        continue;
                    gameBoard[i][j] = "X";

                    if (gameBoard[i][j - 1].equals("X"))
                        gameBoard[i][++j] = "X";
                    else
                        gameBoard[i][--j] = "X";
                    break;
                }
                if (j == 1) {
                    if (gameBoard[i][j + 1].equals("X") && gameBoard[i][j - 1].equals("X"))
                        continue;
                    gameBoard[i][j] = "X";

                    if (gameBoard[i][j - 1].equals("X"))
                        gameBoard[i][++j] = "X";
                    else
                        gameBoard[i][--j] = "X";
                    break;
                }

                if (gameBoard[i][j - 1].equals("X") && gameBoard[i][j + 1].equals("X"))
                    continue;
                gameBoard[i][j] = "X";

                if (gameBoard[i][j - 1].equals("X"))
                    gameBoard[i][++j] = "X";
                else
                    gameBoard[i][--j] = "X";
                break;
            }
        }
        //ship length 1
        while(true){
            if (gameBoard[i][j].equals("X")) {
                i = rand.nextInt(6);
                j = rand.nextInt(6);
                continue;
            }
            
            gameBoard[i][j] = "X";
            break;
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
                System.out.print(ANSI_BLUE + "[ " + ANSI_RESET + (matrix[i][j]== "X" ? ANSI_GREEN + matrix[i][j] + ANSI_RESET : matrix[i][j]) + ANSI_BLUE + " ]" + ANSI_RESET);
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
                for(int ii = 0; ii  < computerBoard.length; ii++){
                    for(int jj = 0; jj < computerBoard[ii].length; jj++){
                        if(computerBoard[ii][jj] != userCopy[ii][jj])
                            ship_count++;
                    }
                }
                winBoard(computerBoard);
                winBoard(userVisible);
                System.out.println(ANSI_RED + "You lose!" + ANSI_RESET);
                if(ship_count == 1)
                    System.out.println("You only needed one more hit! :( ");
                else if(ship_count >= 3)  
                    System.out.println("You needed " + ship_count + " more hits! :(\n");
                else
                    System.out.println("You only needed " + ship_count + " more hits! :(\n");
                    
                System.out.println("Stats:");
                System.out.println("\tYour missed moves count: " + user_count);
                System.out.println("\tComputer's missed moves count: " + computer_count);
                break;
            }
            if (Arrays.deepEquals(computerBoard, userCopy)) { //checking if the user wins
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                winBoard(userVisible);
                System.out.println(ANSI_CYAN + "You win!" + ANSI_RESET);
                System.out.println("Stats:");
                System.out.println("\tYour missed moves count: " + user_count);
                System.out.println("\tComputer's missed moves count: " + computer_count);
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
                computer_count++;
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
            boolean checker = true;
            while(checker){
                displayBoard(userVisible);
                System.out.println("Type the row number & column number: ");
                try{
                    val = scanner.nextInt();
                    val2 = scanner.nextInt();
                }
                catch(InputMismatchException ime){
                    System.out.println("Numbers only! :) ");
                    scanner = new Scanner(System.in);
                    checker = true;
                    continue;
                }
                catch(Exception ex){
                    System.out.println("Uh-oh, something went wrong! Please try again :)");
                    scanner = new Scanner(System.in);
                    checker = true;
                    continue;
                }
                if (val > 5 | val2 > 5) {
                    System.out.println(ANSI_RED + "The value must be between 0 and 5 (inclusive)" + ANSI_RESET);
                    checker = true;
                    continue;
                }
                if (userVisible[val][val2].equals("O") | userCopy[val][val2].equals("X")) {
                    System.out.println(ANSI_RED + "You have already picked this position." + ANSI_RESET);
                    checker = true;
                    continue;
                }
                if (computerBoard[val][val2].equals("X")) {
                    checker = false;
                    userCopy[val][val2] = "X";
                    userVisible[val][val2] = ANSI_RED + "H" + ANSI_RESET;
                } else {
                    checker = false;
                    userVisible[val][val2] = "O";
                    user_count++;
                }
            }
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
