/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.components;

import controller.Basic;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import util.Constantes;

/**
 *
 * @author ricardo
 */
public class MyButton extends JButton {
    
    public MyButton(CalcText print) {
        super();
        this.setBackground(Color.gray);
        this.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
        this.setFont(new Font(this.getFont().getFontName(), Font.ROMAN_BASELINE, 20));
        this.setFocusable(false);
        
        this.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                if (getText().equals("=")) {
                    Constantes.operadorDigitado = false;
                    Basic b = new Basic();
                    try {
                        print.setText(b.interpretar(print.getText()));
                    } catch (UnsupportedOperationException erro) {
                        if (erro.getMessage().equals("Inf.")) {
                            print.setText("Inf.");
                        } else {
                            print.setText(erro.getMessage());
                        }
                    }
                } else {
                    if(!Constantes.operadorDigitado || getText().equals(".") ||getText().equals("0") || getText().equals("1") || getText().equals("2") || getText().equals("3") || getText().equals("4") || getText().equals("5") || getText().equals("6") || getText().equals("7") || getText().equals("8") || getText().equals("9")){
                        print.setText(print.getText() + getText());
                    }
                    if(getText().equals("Limpar")) Constantes.operadorDigitado = false;
                    if(getText().equals("±") || getText().equals("^") || getText().equals("√") || getText().equals("log") || getText().equals("*") || getText().equals("/") || getText().equals("-") || getText().equals("+")) Constantes.operadorDigitado = true;
                    
                }
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(new LineBorder(Color.white, 4, true));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
            }
        });
    }
    
}
