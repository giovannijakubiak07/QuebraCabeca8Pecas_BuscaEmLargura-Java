/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author giova
 */
public class Board {




    public int[][] preencheBoard() {
       
        ArrayList<Integer> valores = new ArrayList<>();
        int board[][] = new int[3][3];
        
        valores.add(4);
        valores.add(7);
        valores.add(1);
        
        valores.add(0);
        valores.add(6);
        valores.add(3);
        
        valores.add(8);
        valores.add(2);
        valores.add(5);
//        valores.add(1);
//        valores.add(2);
//        valores.add(3);
//        valores.add(4);
//        valores.add(5);
//        valores.add(6);
//        valores.add(7);
//        valores.add(0);
//        valores.add(8);
        
        int index = 0; 
        
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                int numero = valores.get(0);
                board[i][j] = numero;
                valores.remove(0);
            }
        }
        return board;
    }
    public int[][] Objetivo() {
        
        ArrayList<Integer> valores = new ArrayList<>();
        
        int boardObjetivo[][] = new int[3][3];
        
        valores.add(1);
        valores.add(2);
        valores.add(3);
        valores.add(4);
        valores.add(5);
        valores.add(6);
        valores.add(7);
        valores.add(8);
        valores.add(0);
        int index = 0; 
        
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                int numero = valores.get(0);
                boardObjetivo[i][j] = numero;
                valores.remove(0);
            }
        }
        return boardObjetivo;
    }
    
    public boolean checkBoard(int[][] matrix, int[][] objetivo){
     
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int obj = objetivo[i][j];
                int attempt = matrix[i][j];
                if(obj != attempt){
                    return false; //retorna false se tiver um item diferente na lista
                }
            }
        }
        return true; //retorna true se todos forem iguais
    }

//    public int geraNumero() {
//
//        double newDouble = 10 * Math.random();
//        int newNum = (int) newDouble;
//        System.out.println("Numero: " + newNum);
//        if (verificaExistencia(newNum)) {
//            geraNumero();
//        }
//      
//        return newNum;
//    }
//
//    public boolean verificaExistencia(int newNum) {
//        
//        for (int i = 0; i < valores.size(); i++) {
//            System.out.println("Conferindo, iteração: " + i);
//            if(newNum == 0){
//                System.out.println("Novo numero foi igual a zero");
//                return true;
//            }
//            if (valores.get(i) == newNum) {
//                System.out.println("Novo numero ja existe na lista");
//                return true;
//            }else
//                System.out.println("Novo numero aprovado");
//                valores.add(newNum);
//                return false;   
//        }
//        return false;
//    }
}
