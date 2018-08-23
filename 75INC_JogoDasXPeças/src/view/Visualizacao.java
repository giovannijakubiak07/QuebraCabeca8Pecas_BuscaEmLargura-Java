/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author giova
 */
public class Visualizacao {
    

    public void showMatrix2( int board[][] ){
        System.out.println("| "+board[0][0]+"  "+board[0][1]+"  "+board[0][2]+" |");
        System.out.println("| "+board[1][0]+"  "+board[1][1]+"  "+board[1][2]+" |");
        System.out.println("| "+board[2][0]+"  "+board[2][1]+"  "+board[2][2]+" |");
    }
}
