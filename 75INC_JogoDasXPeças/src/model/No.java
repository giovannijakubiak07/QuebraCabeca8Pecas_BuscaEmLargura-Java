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
public class No {
    
    private No noPai;
    private int[][] estadoJogo = new int[3][3];
    private ArrayList<No> nosFilhos = new ArrayList<>();
    public int d;

    public No() {
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
    
    

    public No getNoPai() {
        return noPai;
    }

    public void setNoPai(No noPai) {
        this.noPai = noPai;
    }

    public int[][] getEstadoJogo() {
        return estadoJogo;
    }

    public void setEstadoJogo(int[][] estadoJogo) {
        this.estadoJogo = estadoJogo;
    }

    public ArrayList<No> getNosFilhos() {
        return nosFilhos;
    }

    public void setNosFilhos(ArrayList<No> nosFilhos) {
        this.nosFilhos = nosFilhos;
    }
    public void addNoFilho(No noFilho){
        
        this.nosFilhos.add(noFilho);
        
    }

    
    
    
    
}
