import java.util.*;
import java.io.*;

public class Battleship {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Battleship!");
        System.out.println();

        // Enter the coordinates of ships
        char[][] locationBoards1;
        char[][] locationBoards2;
        locationBoards1 = enterShipCoordinates(1, input);
        for (int i = 0; i < 100; i++){
            System.out.println();
        }
        locationBoards2 = enterShipCoordinates(2, input);
        for (int i = 0; i < 100; i++){
            System.out.println();
        }

        // Fire
        char[][] fireHistory1 = new char[5][5];
        char[][] fireHistory2 = new char[5][5];
        int shipNum1 = 5;
        int shipNum2 = 5;
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                fireHistory1[i][j] = '-';
                fireHistory2[i][j] = '-';
            }
        }
        do {
            fireHistory1 = fire(1, input, fireHistory1, locationBoards2);
            shipNum2 = 0;
            for (int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if (fireHistory1[i][j] != '-'){
                        locationBoards2[i][j] = fireHistory1[i][j];
                    }
                    if (locationBoards2[i][j] == '@'){
                        shipNum2++;
                    }
                }
            }
            if (shipNum2 == 0){
                break;
            }

            fireHistory2 = fire(2, input, fireHistory2, locationBoards1);
            shipNum1 = 0;
            for (int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if (fireHistory2[i][j] != '-'){
                        locationBoards1[i][j] = fireHistory2[i][j];
                    }
                    if (locationBoards1[i][j] == '@'){
                        shipNum1++;
                    }
                }
            }
            if (shipNum1 == 0){
                break;
            }

        }while(true);

        System.out.printf("PLAYER %d WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!\n", shipNum1 == 0 ? 2 : 1);
        System.out.println();
        System.out.println("Final boards:");
        System.out.println();
        printBattleShip(locationBoards1);
        System.out.println();
        printBattleShip(locationBoards2);
    }

    private static char[][] fire(int playId, Scanner input, char[][] fireHistory, char[][] board){
        System.out.printf("Player %s, enter hit row/column:\n", playId);
        int x,y = 0;
        x = input.nextInt();
        y = input.nextInt();
        while (!(0 <= x && x <= 4) || !(0 <= y && y <= 4)){
            System.out.println("Invalid coordinates. Choose different coordinates.");
            System.out.printf("Player %s, enter hit row/column:\n", playId);
            x = input.nextInt();
            y = input.nextInt();
        }
        while(fireHistory[x][y] != '-'){
            System.out.println("You already fired on this spot. Choose different coordinates.");
            System.out.printf("Player %s, enter hit row/column:\n", playId);
            x = input.nextInt();
            y = input.nextInt();
        }
        if (board[x][y] == '@'){
            System.out.printf("PLAYER %d HIT PLAYER %d’s SHIP!\n", playId, playId == 1 ? 2 : 1);
            fireHistory[x][y] = 'X';
        }
        else{
            System.out.printf("PLAYER %d MISSED!\n", playId);
            fireHistory[x][y] = 'O';
        }

        printBattleShip(fireHistory);
        return fireHistory;
    }

    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }

    private static char[][] enterShipCoordinates(int playerId, Scanner input){
        System.out.println("PLAYER " + playerId + ", ENTER YOUR SHIPS’ COORDINATES.");

        char[][] board = new char[5][5];
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                board[i][j] = '-';
            }
        }
        int x,y = 0;

        for (int i = 1; i <= 5; i++){
            System.out.println("Enter ship " + i + " location:");
            try{
                x = input.nextInt();
                y = input.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Invalid coordinates. Choose different coordinates.");
                i--;
                continue;
            }
            if (!(0 <= x && x <= 4) || !(0 <= y && y <= 4)){
                System.out.println("Invalid coordinates. Choose different coordinates.");
                i--;
                continue;
            }
            if (board[x][y] == '@'){
                System.out.println("You already have a ship there. Choose different coordinates.");
                i--;
                continue;
            }
            board[x][y] = '@';
        }

        printBattleShip(board);
        return board;
    }
}
