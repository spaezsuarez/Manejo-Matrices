package gui.components;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//Logica
import logic.ManejoMatriz;

public class MatrizComponent extends JPanel {

    private JTextField[][] entrada;
    private double[][] conversion;
    private ManejoMatriz objeto;
    
    public MatrizComponent(){
        this.objeto = new ManejoMatriz();
    }

    public void setMatrices(int filas, int columnas) {

        entrada = new JTextField[filas][columnas];
        conversion = new double[filas][columnas];

    }

    private double[][] getConversion() {
        for (int i = 0; i < entrada.length; i++) {
            for (int j = 0; j < entrada[i].length; j++) {
                conversion[i][j] = Double.parseDouble(entrada[i][j].getText());

            }
        }

        return conversion;
    }

    public void initComponent() {
        setLayout(null);
        setSize(new Dimension(1200, 650));
        setLocation(200, 0);
        initInputElements();
        setVisible(true);
    }

    public void initInputElements() {
        for (int i = 0; i < entrada.length; i++) {
            for (int j = 0; j < entrada[i].length; j++) {
                entrada[i][j] = new JTextField();
                entrada[i][j].setBounds(j * 75 + 6, i * 75 + 6, 50, 50);
                entrada[i][j].setHorizontalAlignment(JLabel.CENTER);
                add(entrada[i][j]);
            }
        }
    }

    public void test() {
        for (int i = 0; i < entrada.length; i++) {
            for (int j = 0; j < entrada[i].length; j++) {
                entrada[i][j] = new JTextField();
                entrada[i][j].setText("" + conversion[i][j]);
            }
        }
    }

    public void showOutPutReductionElements() {

        try {
            objeto.escalonar(getConversion());
        } catch (NullPointerException a) {
            JOptionPane.showMessageDialog(null, "Error inesperado", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException e) {} 
        
          catch(NumberFormatException q){
            JOptionPane.showMessageDialog(null, "Primero llene la matriz", "Error", JOptionPane.ERROR_MESSAGE);
        }

        String result = "";

        for (int i = 0; i < conversion.length; i++) {
            for (int j = 0; j < conversion[i].length; j++) {
                result += String.valueOf((conversion[i][j]));
                result += "     ";
            }
            result += "\n";
        }
        
        result += "\nRango: " + objeto.rangoMatriz(conversion) + "\n";
        result += "<html><body><p>Orden:N<sup>2</sup></p></body></html>";
        //result += "";

        JOptionPane.showMessageDialog(null, result, "Matriz Escalonada", JOptionPane.DEFAULT_OPTION);
    }

    public void showDeterminant() {
        double[] respuestas = objeto.Determinante(getConversion());
        String result = "";
        
        if(objeto.getIsNan()){
            result = "Determinante: " + "No existe" + "\n"
                + "Contador: " + respuestas[1] + "\n"
                + "Formula: " + respuestas[2] + "\n"
                + "<html><body><p>Complejidad: O(N<sup>3</sup>)<p></body></html> \n"
                + "<html><body><p>Expresion: 21N<sup>2</sup> - 31N + ((32N<sup>3</sup>-159N<sup>2</sup> + 223N - 96)/ 6) + 10 </p></body></html>";
        }else{
            result = "Determinante: " + respuestas[0] + "\n"
                + "Contador: " + respuestas[1] + "\n"
                + "Formula: " + respuestas[2] + "\n"
                + "<html><body><p>Complejidad: O(N<sup>3</sup>)<p></body></html> \n"
                + "<html><body><p>Expresion: 21N<sup>2</sup> - 31N + ((32N<sup>3</sup>-159N<sup>2</sup> + 223N - 96)/ 6) + 10 </p></body></html>";
        }
        

        JOptionPane.showMessageDialog(null, result, "Determinante", JOptionPane.DEFAULT_OPTION);
    }

}
