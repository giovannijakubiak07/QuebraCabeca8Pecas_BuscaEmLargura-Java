/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Controller.Actions;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Visualizacao;

/**
 *
 * @author giova
 */
public class Player implements Runnable {
 
    
    private int[][] estadoObjetivo = new int[3][3];
    private Actions act = new Actions();
    private Visualizacao view = new Visualizacao();
    private ArrayList<No> listaDeNos = new ArrayList<>();
    private Board board = new Board();
    private boolean encontrouSolucao;

    
    
    public void iniciaPensamento() throws InterruptedException{
        estadoObjetivo = board.Objetivo();
        No noZero = new No();
        noZero.setEstadoJogo(board.preencheBoard());
        noZero.setNoPai(null);
        noZero.setD(0);
        
        noAtual(noZero);
        
    }
    
    public ArrayList<Integer> validOptions(No no){
        
        int [][] estadoAtual = no.getEstadoJogo();
        ArrayList<Integer> actions = new ArrayList<>();
        ArrayList<Integer> posicaoZero = act.encontraVazio(estadoAtual);
            /*
            Ações: 
            1 = mover para cima
            2 = mover para direita
            3 = mover para baixo
            4 = mover para esquerda
            
            */
            if((posicaoZero.get(0) == 0) && (posicaoZero.get(1) == 0)){//posicao 0x0
                actions.add(2);
                actions.add(3);
               
                return actions;
                
            }
            if((posicaoZero.get(0) == 0) && (posicaoZero.get(1) == 1)){//posicao 0x1
                actions.add(2);
                actions.add(3);
                actions.add(4);
                
                return actions;
            }
            if((posicaoZero.get(0) == 0) && (posicaoZero.get(1) == 2)){//posicao 0x2
                
                actions.add(3);
                actions.add(4);
                
                return actions;
            }
            if((posicaoZero.get(0) == 1) && (posicaoZero.get(1) == 0)){//posicao 1x0
                
                actions.add(1);
                actions.add(2);
                actions.add(3);
                
                return actions;
            }
            if((posicaoZero.get(0) == 1) && (posicaoZero.get(1) == 1)){//posicao 1x1
                
                actions.add(1);
                actions.add(2);
                actions.add(3);
                actions.add(4);
                
                return actions;
            }
            if((posicaoZero.get(0) == 1) && (posicaoZero.get(1) == 2)){//posicao 1x2
                
                actions.add(1);
                actions.add(3);
                actions.add(4);
                
                return actions;
            }
            if((posicaoZero.get(0) == 2) && (posicaoZero.get(1) == 0)){//posicao 2x0
                
                actions.add(1);
                actions.add(2);
                
                return actions;
            }
            if((posicaoZero.get(0) == 2) && (posicaoZero.get(1) == 1)){//posicao 2x1
                
                actions.add(1);
                actions.add(2);
                actions.add(4);
                
                return actions;
            }
            if((posicaoZero.get(0) == 2) && (posicaoZero.get(1) == 2)){//posicao 2x2
                
                actions.add(1);
                actions.add(4);
                
                return actions;
            }
            
        return null;
        
    }
    
    public void noAtual(No no) throws InterruptedException{
       
        listaDeNos.add(no);
        No currentNode = new No();
       
        
        for (int i = 0; i < listaDeNos.size(); i++) {
            
            System.out.println("Iteração de numero: " + i);
            
            currentNode = listaDeNos.get(i);
            
            view.showMatrix2(currentNode.getEstadoJogo());
            
            expandeGalhosDaArvore(currentNode);
            
            if(board.checkBoard(currentNode.getEstadoJogo(), estadoObjetivo)){
                System.out.println("Estado objetivo encontrado após: " + i + " iterações"
                        + "\nNo nível: d= " + currentNode.getD() );
                view.showMatrix2(currentNode.getEstadoJogo());
                        
                encontrouSolucao = true;
                break;
                
            }
            
            System.out.println("Nível: " + currentNode.getD());
//            for (int j = 0; j < nosFilhos.size(); j++) {
//                System.out.println("Nó filho: " + i);
//                view.setBoard(nosFilhos.get(i).getEstadoJogo());
//                view.showMatrix2();
//                listaDeNos.add(nosFilhos.get(j));
//                
//            }
            
        }
       
        System.out.println("Solução encontrada: " + currentNode.toString());
            
            
        }

       
    

    
    public void expandeGalhosDaArvore(No no){
       
        ArrayList<Integer> opcoes = new ArrayList<>();
        opcoes = validOptions(no);
        System.out.println("-----------------------------------------");
        System.out.println("NOS FILHOS:");
        int[][] estadoDoPai = new int[3][3];
        estadoDoPai = no.getEstadoJogo();
        int[][] estadoDoJogo = new int[3][3];
        estadoDoJogo = passagemPorValor(estadoDoPai);
        
        for (int i = 0; i < opcoes.size(); i++) {
           
           No noFilho = new No(); 
           noFilho.setEstadoJogo(act.selecionaOpcao(opcoes.get(i), estadoDoJogo));
           noFilho.setNoPai(no);
           noFilho.setD(no.getD()+1);
           
           if(no.getNoPai() == null){
                listaDeNos.add(noFilho);
           }
           if(no.getNoPai() != null){
               if(confereExistencia(estadoDoJogo)){
               noFilho = null; 
               estadoDoJogo = passagemPorValor(estadoDoPai);
               }else{
           listaDeNos.add(noFilho);
           }
           }
           
           try{
           view.showMatrix2(noFilho.getEstadoJogo());
           }catch(NullPointerException e){}
           
           System.out.println("==========");
           
           if(noFilho != null && board.checkBoard(estadoDoJogo , estadoObjetivo)){
               System.out.println("Entrou a solução!!!!!!!!!!!!!!" + "  Vou analisar depois como mostrar os resultados");
               encontrouSolucao = true;
               view.showMatrix2(noFilho.getEstadoJogo());
               
               break;
            }
           noFilho = null; 
           estadoDoJogo = passagemPorValor(estadoDoPai);
        
        }
        System.out.println("-----------------------------------------");
    }
    public int [][] passagemPorValor(int [][] valores){
       
        int[][] novoValorDeMemória = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int val1;
                val1 = valores[i][j];
                int val2 = val1;
                novoValorDeMemória[i][j] = val2;
                
                
            }
        }
        return novoValorDeMemória;
        
        
        
    }

    @Override
    public void run() {
        
        try {
            iniciaPensamento();
        } catch (InterruptedException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public boolean confereExistencia(int[][] test){
        for (int i = 0; i < listaDeNos.size(); i++) {
            No get = listaDeNos.get(i);
            
           if(board.checkBoard(test, get.getEstadoJogo()))
               return true;
        }
        return false;
    }
}
