/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;

/**
 *
 * @author giova
 */
public class Actions {
    
    
    public int[][] selecionaOpcao(int opcao , int board[][]){
        int[][] estadoDoJogo = new int[3][3];
        estadoDoJogo = board;
        /*
            Ações: 
            1 = mover para cima
            2 = mover para direita
            3 = mover para baixo
            4 = mover para esquerda
            
            */
        switch(opcao){
            case 1:{
                return moverParaCima(estadoDoJogo);
            }
            case 2:{
                return moverParaDireita(estadoDoJogo);
            }
            case 3:{
                return moverParaBaixo(estadoDoJogo);
                
            }
            case 4:{
                return moverParaEsquerda(estadoDoJogo);
            }
        }
        return null;
    }
    
    public int[][] moverParaCima(int board[][]){
        
        ArrayList<Integer> retorno  = new ArrayList<>();
        retorno = encontraVazio(board);
        
        int valor = board[retorno.get(0)-1][retorno.get(1)]; //pega um valor acima da matriz 
        board[retorno.get(0)-1][retorno.get(1)] = 0; //acrescenta 0 a posicao dele
        board[retorno.get(0)][retorno.get(1)] = valor; //coloca ele na posicao do zero
        
        return board;
        
    }
    
    public int[][] moverParaBaixo(int board[][]){
         ArrayList<Integer> retorno  = new ArrayList<>();
        retorno = encontraVazio(board);
        
        int valor = board[retorno.get(0)+1][retorno.get(1)]; //pega um valor abaixo da matriz 
        board[retorno.get(0)+1][retorno.get(1)] = 0; //acrescenta 0 a posicao dele
        board[retorno.get(0)][retorno.get(1)] = valor; //coloca ele na posicao do zero
        
        return board;
    }
    
    public int[][] moverParaEsquerda(int board[][]){
        ArrayList<Integer> retorno  = new ArrayList<>();
        retorno = encontraVazio(board);
        
        int valor = board[retorno.get(0)][(retorno.get(1)-1)]; //pega um valor a esquerda da matriz 
        board[retorno.get(0)][(retorno.get(1)-1)] = 0; //acrescenta 0 a posicao dele
        board[retorno.get(0)][retorno.get(1)] = valor; //coloca ele na posicao do zero
        
        return board;
    }
    
    public int[][]  moverParaDireita(int board[][]){
        ArrayList<Integer> retorno  = new ArrayList<>();
        retorno = encontraVazio(board);
        
        int valor = board[retorno.get(0)][retorno.get(1)+1]; //pega um valor a esquerda da matriz 
        board[retorno.get(0)][retorno.get(1)+1] = 0; //acrescenta 0 a posicao dele
        board[retorno.get(0)][retorno.get(1)] = valor; //coloca ele na posicao do zero
        
        return board;
    }
    
    /**
     *
     * @param board
     * @return
     */
    public ArrayList<Integer> encontraVazio(int board[][]){
        
        ArrayList<Integer> retorno  = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
          
            for (int j = 0; j < board.length; j++) {
                
                if(board[i][j] == 0){
                    
                    retorno.add(i);
                    retorno.add(j);
                    return retorno;         
                }
            }   
        }
    return retorno;
    }
}
