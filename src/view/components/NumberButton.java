/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author ricardo
 */
public class NumberButton extends MyButton {

    private double number;
    private CalcText printIn;

    public NumberButton(double number, CalcText printIn) {
        super(printIn);
        this.setLayout(null);
        this.setText("" + (int) number);
        this.setSize(100, 100);

        
        this.printIn = printIn;
        
        this.setVisible(true);
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    
    
}
