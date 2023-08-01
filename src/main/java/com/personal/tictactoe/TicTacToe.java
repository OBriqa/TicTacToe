/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.personal.tictactoe;

import java.util.Scanner;

/**
 *
 * @author Omar
 */
public class TicTacToe {

    private final static char[][] BOARD = {
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}
    };
    
    private final static int X_WINNER = 1;
    private final static int O_WINNER = 0;
    private final static int NO_WINNER = -1;
    
    private final static String X_WINS = "XXX";
    private final static String O_WINS = "OOO";    
    
    private final static char EMPTY_POS = ' ';
    private final static char[] PLAYERS = {'O', 'X'};
        
    public static void main(String[] args) {
        
        char[][] game = BOARD;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your token [X (1), O (0)]: ");
        int player = scanner.nextInt();
        
        printBoard(game);
        
        int i = player, empty = 9;
        while((checkWinner(game) == NO_WINNER) && empty > 0){
            System.out.println("Put your token [" + PLAYERS[i%2] + "]: ");
            int pos = scanner.nextInt();
            
            if(turn(game, pos, i % 2)) {
                printBoard(game);
                empty--; i++;
            }
            else System.out.println("Incorrect placement!");
        }
        
        int winner = (checkWinner(game));
        
        switch (winner) {
            case NO_WINNER:
                System.out.println("DRAW!");
                break;
            case O_WINNER:
                System.out.println("O WINS!");
                break;
            case X_WINNER:
                System.out.println("X WINS!");
                break;
            default:
                break;
        }
                        
    }
    
    
    // Print game board
    public static void printBoard(char board[][]){
        for(char row[] : board){
            for(char j : row){
                System.out.print(j);
            }
            System.out.println();
        } 
    }
    
    public static boolean turn(char[][] game, int pos, int player){
        
        switch(pos){
            case 1:
                if (game[0][0] == EMPTY_POS) {
                    game[0][0] = PLAYERS[player % 2];
                    return true;
                }
                return false;
            
            case 2:
               if (game[0][2] == EMPTY_POS) {
                    game[0][2] = PLAYERS[player % 2];
                    return true;
                }
                return false;
                
            case 3:
               if (game[0][4] == EMPTY_POS) {
                    game[0][4] = PLAYERS[player % 2];
                    return true;
                }
                return false;
                
            case 4:
               if (game[2][0] == EMPTY_POS) {
                    game[2][0] = PLAYERS[player % 2];
                    return true;
                }
                return false; 
                
            case 5:
               if (game[2][2] == EMPTY_POS) {
                    game[2][2] = PLAYERS[player % 2];
                    return true;
                }
                return false;
                
            case 6:
               if (game[2][4] == EMPTY_POS) {
                    game[2][4] = PLAYERS[player % 2];
                    return true;
                }
                return false;
                
            case 7:
               if (game[4][0] == EMPTY_POS) {
                    game[4][0] = PLAYERS[player % 2];
                    return true;
                }
                return false;
                
            case 8:
               if (game[4][2] == EMPTY_POS) {
                    game[4][2] = PLAYERS[player % 2];
                    return true;
                }
                return false;  
                
            case 9:
               if (game[4][4] == EMPTY_POS) {
                    game[4][4] = PLAYERS[player % 2];
                    return true;
                }
                return false;
                
            default:
                return false;
        }
        
    }
  

    // -1 -> no winner
    //  0 or 1, player _ wins
    public static int checkWinner(char[][] game){
        
        
        // rows
        for (int i = 0; i < 5; i += 2){
                    
            String res = "";
            for (int j = 0; j < 5; j += 2) res += game[i][j];
            
            if (res.equals(X_WINS)) return 1;
            else if (res.equals(O_WINS)) return 0;
        }
        
        // columns
        for (int i = 0; i < 5; i += 2){
                    
            String res = "";
            for (int j = 0; j < 5; j += 2) res += game[j][i];
            
            if (res.equals(X_WINS)) return 1;
            else if (res.equals(O_WINS)) return 0;
        }
        
        // diagonals
        
        String res = "";
        for (int i = 0; i < 5; i += 2) res += game[i][i];
        
        if (res.equals(X_WINS)) return 1;
        else if (res.equals(O_WINS)) return 0;
        
        
        res = "";
        for (int i = 0; i < 5; i += 2) res += game[i][4-i];
        
        if (res.equals(X_WINS)) return 1;
        else if (res.equals(O_WINS)) return 0;
                 
        return -1;
    }
}
