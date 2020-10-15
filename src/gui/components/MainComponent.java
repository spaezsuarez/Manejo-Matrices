package gui.components;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class MainComponent extends JPanel implements ActionListener {

    private final int WIDTH, HEIGHT;
    private JButton btnGrilla,btnRedux,btnClear,btnDeterminante;
    private JTextField txtFilas,txtColumnas;
    private JLabel lFilas,lColumnas;
    private MatrizComponent tablero;

    public MainComponent() {
        WIDTH = 2000;
        HEIGHT = 650;

        initComponent();
    }

    public void initComponent() {
        setLayout(null);
        setSize(new Dimension(WIDTH, HEIGHT));
        setLocation(0, 0);
        setFont(new Font("Bitstream Vera Sans", Font.PLAIN, 30));
        setVisible(true);
    }

    public void initElements() {
        lFilas = new JLabel("Filas: ");
        lFilas.setSize(new Dimension(100,20));
        lFilas.setLocation(20, 50);
        add(lFilas);
        
        lColumnas = new JLabel("Columnas: ");
        lColumnas.setSize(new Dimension(100,20));
        lColumnas.setLocation(20, 100);
        add(lColumnas);
        
        txtFilas = new JTextField();
        txtFilas.setSize(new Dimension(50,20));
        txtFilas.setLocation(100, 50);
        add(txtFilas);
        
        txtColumnas = new JTextField();
        txtColumnas.setSize(new Dimension(50,20));
        txtColumnas.setLocation(100, 100);
        add(txtColumnas);
        
        btnGrilla = new JButton("Crear Grilla");
        btnGrilla.setSize(new Dimension(150, 20));
        btnGrilla.setLocation(20, 150);
        btnGrilla.addActionListener(this);
        add(btnGrilla);
        
        tablero = new MatrizComponent();
        add(tablero);
        
        btnRedux = new JButton("Escalonar Matriz");
        btnRedux.setSize(new Dimension(150, 20));
        btnRedux.setLocation(20, 200);
        btnRedux.addActionListener(this);
        add(btnRedux);
        
        btnClear = new JButton("Limpiar");
        btnClear.setSize(new Dimension(150, 20));
        btnClear.setLocation(20, 300);
        btnClear.addActionListener(this);
        add(btnClear);
        
        btnDeterminante = new JButton("Determinante");
        btnDeterminante.setSize(new Dimension(150,20));
        btnDeterminante.setLocation(20, 250);
        btnDeterminante.addActionListener(this);
        add(btnDeterminante);
        
    }
   
    @Override
    public void actionPerformed(ActionEvent event) {
        
        if(event.getSource() == btnGrilla){
            
            int rowSize = 1;
            int colSize = 1;
            
            try{
                rowSize = Integer.parseInt(txtFilas.getText());
                colSize = Integer.parseInt(txtColumnas.getText());
                tablero.setMatrices(rowSize, colSize);
                tablero.initComponent();
                add(tablero);
                repaint();
                
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ingrese solo numeros", "Error", JOptionPane.ERROR_MESSAGE);
                txtFilas.setText("");
                txtColumnas.setText("");
            }
          
        }else if(event.getSource() == btnRedux){
            try{
                tablero.showOutPutReductionElements();
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ingrese Primero los numeros de la matriz", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }else if(event.getSource() == btnClear){
            tablero.removeAll();
            remove(tablero);
            repaint();
        }else if(event.getSource() == btnDeterminante){
            
             if(txtFilas.getText().equals(txtColumnas.getText())){
                  tablero.showDeterminant();
             }else{
                  JOptionPane.showMessageDialog(null, "La matriz debe ser cuadrada", "Error", JOptionPane.ERROR_MESSAGE);
             }
            
            
            
            
        }
    }

}
