/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicBorders;

/**
 *
 * @author ricardo
 */
public class CalcText extends JTextField{
    
    public CalcText(){
        this.setLayout(null);
        this.setSize(500,60);
        this.setFocusable(false);
        this.setEditable(false);
        this.setBackground(new java.awt.Color(155, 135, 140));
        this.setForeground(Color.WHITE);
        this.setBorder(new LineBorder(new Color(185, 185, 189), 2, true));
        this.setHorizontalAlignment(JTextField.RIGHT);
        this.setFont(new Font(this.getFont().getFontName(), Font.ROMAN_BASELINE, 20));
        this.setText("");
        this.setVisible(true);
    }
    
}
