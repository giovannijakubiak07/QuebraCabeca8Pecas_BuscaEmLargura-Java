/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import model.Board;
import model.Player;
import view.Visualizacao;

/**
 *
 * @author giova
 */
public class Play {
    
    public static void main(String[] args) {
        //fazer o usuario colocar ordem dos valores, ou já vir pre definido no sistema
        Visualizacao visual = new Visualizacao();
        
        (new Thread(new Player())).start();
        
       
    }
    
}
