/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panels;

import controller.Basic;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import util.Constantes;
import view.components.CalcText;
import view.components.MyButton;
import view.components.NumberButton;

/**
 *
 * @author ricardo
 */
public class PrincipalPanel extends JPanel implements KeyListener {

    private NumberButton[][] gridNumber;
    private CalcText printIn;
    private MyButton limpar;
    private MyButton operadorSoma;
    private MyButton operadorSub;
    private MyButton operadorDiv;
    private MyButton operadorMul;
    private MyButton operadorIgual;
    private MyButton operadorRadiciacao;
    private MyButton operadorNegacao;
    private MyButton operadorLogaritmo;
    private MyButton operadorPotencia;

    private MyButton ponto;

    public PrincipalPanel() {
        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.DARK_GRAY);

        printIn = new CalcText();
        printIn.setLocation(5, 5);

        limpar = new MyButton(printIn);
        limpar.setText("Limpar");
        limpar.setSize(100, 30);
        limpar.setLocation(printIn.getLocation().x + printIn.getWidth() - limpar.getWidth(), printIn.getLocation().y + printIn.getHeight() + 2);
        limpar.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                printIn.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        gridNumber = new NumberButton[4][3];

        gridNumber[0][0] = new NumberButton(7.0, printIn);
        gridNumber[0][1] = new NumberButton(8.0, printIn);
        gridNumber[0][2] = new NumberButton(9.0, printIn);
        gridNumber[1][0] = new NumberButton(4.0, printIn);
        gridNumber[1][1] = new NumberButton(5.0, printIn);
        gridNumber[1][2] = new NumberButton(6.0, printIn);
        gridNumber[2][0] = new NumberButton(1.0, printIn);
        gridNumber[2][1] = new NumberButton(2.0, printIn);
        gridNumber[2][2] = new NumberButton(3.0, printIn);
        gridNumber[3][0] = new NumberButton(0.0, printIn);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 3 && j > 0) {
                    break;
                }

                gridNumber[i][j].setLocation(printIn.getLocation().x + (j * gridNumber[i][j].getSize().width), limpar.getLocation().y + limpar.getHeight() + (i * gridNumber[i][j].getSize().height) + 2);
            }
        }

        operadorSoma = new MyButton(printIn);
        operadorSub = new MyButton(printIn);
        operadorDiv = new MyButton(printIn);
        operadorMul = new MyButton(printIn);
        operadorIgual = new MyButton(printIn);
        operadorRadiciacao = new MyButton(printIn);
        operadorLogaritmo = new MyButton(printIn);
        operadorPotencia = new MyButton(printIn);
        operadorNegacao = new MyButton(printIn);

        operadorSoma.setSize(gridNumber[0][0].getSize());
        operadorSub.setSize(gridNumber[0][0].getSize());
        operadorDiv.setSize(gridNumber[0][0].getSize());
        operadorMul.setSize(gridNumber[0][0].getSize());
        operadorIgual.setSize(gridNumber[0][0].getSize());
        operadorRadiciacao.setSize(gridNumber[0][0].getSize());
        operadorLogaritmo.setSize(gridNumber[0][0].getSize());
        operadorPotencia.setSize(gridNumber[0][0].getSize());
        operadorNegacao.setSize(gridNumber[0][0].getSize());

        operadorIgual.setLocation(gridNumber[2][2].getLocation().x, gridNumber[2][2].getLocation().y + gridNumber[2][2].getHeight());
        operadorIgual.setText("=");

        operadorSoma.setLocation(operadorIgual.getLocation().x + operadorIgual.getWidth(), operadorIgual.getLocation().y);
        operadorSoma.setText("+");

        operadorSub.setLocation(operadorSoma.getLocation().x, gridNumber[2][2].getLocation().y);
        operadorSub.setText("-");

        operadorMul.setLocation(operadorSoma.getLocation().x, gridNumber[1][2].getLocation().y);
        operadorMul.setText("*");

        operadorDiv.setLocation(operadorSoma.getLocation().x, gridNumber[0][2].getLocation().y);
        operadorDiv.setText("/");

        operadorLogaritmo.setLocation(limpar.getLocation().x, gridNumber[3][0].getLocation().y);
        operadorLogaritmo.setText("log");

        operadorNegacao.setLocation(limpar.getLocation().x, gridNumber[0][2].getLocation().y);
        operadorNegacao.setText("±");

        operadorPotencia.setLocation(limpar.getLocation().x, gridNumber[2][2].getLocation().y);
        operadorPotencia.setText("^");

        operadorRadiciacao.setLocation(limpar.getLocation().x, gridNumber[1][2].getLocation().y);
        operadorRadiciacao.setText("√");

        ponto = new MyButton(printIn);
        ponto.setSize(gridNumber[0][0].getSize());
        ponto.setText(".");
        ponto.setLocation(gridNumber[2][1].getLocation().x, gridNumber[3][0].getLocation().y);

        this.add(gridNumber[0][0]);
        this.add(gridNumber[0][1]);
        this.add(gridNumber[0][2]);
        this.add(gridNumber[1][0]);
        this.add(gridNumber[1][1]);
        this.add(gridNumber[1][2]);
        this.add(gridNumber[2][0]);
        this.add(gridNumber[2][1]);
        this.add(gridNumber[2][2]);
        this.add(gridNumber[3][0]);
        this.add(printIn);
        this.add(limpar);
        this.add(operadorIgual);
        this.add(operadorSoma);
        this.add(operadorSub);
        this.add(operadorMul);
        this.add(operadorDiv);
        this.add(operadorLogaritmo);
        this.add(operadorNegacao);
        this.add(operadorPotencia);
        this.add(operadorRadiciacao);
        this.add(ponto);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        StringBuffer t = new StringBuffer();
        t.append(e.getKeyChar());
        try {
            printIn.setText(printIn.getText() + Integer.parseInt(t.toString()));
        } catch (Exception err) {

            if (!Constantes.operadorDigitado && (e.getKeyChar() == '+' || e.getKeyChar() == '-' || e.getKeyChar() == '/' || e.getKeyChar() == '*' || e.getKeyChar() == '^')) {
                printIn.setText(printIn.getText() + e.getKeyChar());
                Constantes.operadorDigitado = true;
            } else if (!Constantes.operadorDigitado && (e.getKeyChar() == 'L' || e.getKeyChar() == 'l')) {
                printIn.setText(printIn.getText() + "log");
                Constantes.operadorDigitado = true;
            } else if (!Constantes.operadorDigitado && (e.getKeyChar() == 'R' || e.getKeyChar() == 'r')) {
                printIn.setText(printIn.getText() + "√");
                Constantes.operadorDigitado = true;
            } else if (e.getKeyChar() == '.') {
                printIn.setText(printIn.getText() + e.getKeyChar());
            } else if (e.getKeyChar() == '\b') {
                printIn.setText("");
                Constantes.operadorDigitado = false;
            } else if (e.getKeyChar() == '\n') {
                Constantes.operadorDigitado = false;
                Basic b = new Basic();
                try {
                    printIn.setText(b.interpretar(printIn.getText()));
                } catch (UnsupportedOperationException erro) {
                    if (erro.getMessage().equals("Inf.")) {
                        printIn.setText("Inf.");
                    } else {
                        printIn.setText(erro.getMessage());
                    }
                }

            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
