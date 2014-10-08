/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import javax.swing.JFrame;
import util.Constantes;
import view.panels.PrincipalPanel;

/**
 *
 * @author ricardo
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame janela = new JFrame("Calculadora");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(null);
        janela.setSize(510,505);
        janela.setLocation((Constantes.resolution.width - janela.getWidth())/2, (Constantes.resolution.height - janela.getHeight())/2);
        janela.setResizable(false);
        
        
        PrincipalPanel pp = new PrincipalPanel();
        pp.setSize(janela.getSize());
        pp.setLocation(0, 0);
        janela.add(pp);
        
        Constantes.frame = janela;
        Constantes.operadorDigitado = false;
        
        janela.setVisible(true);
    }
    
}
