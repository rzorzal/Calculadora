/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import caracteristicas.Interpretador;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.InternalError;
import javax.swing.JOptionPane;

/**
 *
 * @author ricardo
 */
public class Basic implements Interpretador {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double sub(double a, double b) {
        return a - b;
    }

    public static double mult(double a, double b) {
        return a * b;
    }

    public static double div(double a, double b) {
        return a / b;
    }

    public static double log(double logaritmando, double base) {
        return Math.log(logaritmando) / Math.log(base);
    }

    public static double raiz(double numero, double base) {
        return Math.pow(numero, (1 / base));
    }

    public static double potencia(double base, double potencia) {
        return Math.pow(base, potencia);
    }

    @Override
    public String interpretar(String line) {
        System.out.println("Linha para interpretar: " + line);

        if (line.contains("±")) {
                int operador = line.indexOf("±");
                double a = Double.parseDouble(line.substring(0, operador));
                return "" + (a * (-1));
            }
        
        if (line.contains("log")) {
                int operador = line.indexOf("log");
                double a = Double.parseDouble(line.substring(0, operador));
                double b = Double.parseDouble(line.substring(operador + 3, line.length()));
                return "" + Basic.log(a, b);

            }
        
        try {
            
            if (line.contains("+")) {
                int operador = line.indexOf("+");
                double a = Double.parseDouble(line.substring(0, operador));
                double b = Double.parseDouble(line.substring(operador, line.length()));
                return "" + Basic.add(a, b);

            }

            if (line.contains("-")) {
                int operador = line.indexOf("-");
                double a = Double.parseDouble(line.substring(0, operador));
                double b = Double.parseDouble(line.substring(operador, line.length()));
                return "" + Basic.add(a, b);

            }

            if (line.contains("*")) {
                int operador = line.indexOf("*");
                double a = Double.parseDouble(line.substring(0, operador));
                double b = Double.parseDouble(line.substring(operador + 1, line.length()));
                return "" + Basic.mult(a, b);

            }

            if (line.contains("/")) {
                int operador = line.indexOf("/");
                double a = Double.parseDouble(line.substring(0, operador));
                double b = Double.parseDouble(line.substring(operador + 1, line.length()));
                double retorno;
                if (line.substring(operador + 1, line.length()).equals("0.0")) {
                    throw new UnsupportedOperationException("Inf.");
                }
                if(b == 0){
                    throw new UnsupportedOperationException("O denominador da divisão não pode ser 0.");
                }
                try {
                    retorno = Basic.div(a, b);
                } catch (UnsupportedOperationException erro) {
                    throw new UnsupportedOperationException(erro.getMessage());
                }
                return "" + retorno;

            }

            

            if (line.contains("√")) {
                int operador = line.indexOf("√");
                double a = Double.parseDouble(line.substring(0, operador));
                double b = Double.parseDouble(line.substring(operador + 1, line.length()));
                return "" + Basic.raiz(a, b);

            }

            if (line.contains("^")) {
                int operador = line.indexOf("^");
                double a = Double.parseDouble(line.substring(0, operador));
                double b = Double.parseDouble(line.substring(operador + 1, line.length()));
                return "" + Basic.potencia(a, b);

            }

            
        }catch(NumberFormatException | UnsupportedOperationException err){
            throw new UnsupportedOperationException(err.getMessage());
        }

        throw new UnsupportedOperationException("Operador não suportado");

    }

}
