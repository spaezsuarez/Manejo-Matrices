package gui;

import gui.components.MainComponent;
import javax.swing.JFrame;
import java.awt.Dimension;

public class Ventana extends JFrame {
    
    private final int WIDTH,HEIGHT;
    private MainComponent panel;
   
    
    public  Ventana() {
        WIDTH = 600;
        HEIGHT = 400; 
       
    }
    
    public void initTemplate(){
        setLayout(null);
        setTitle("Manejo de Matrices");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setSize(new Dimension(WIDTH,HEIGHT));
        setMaximumSize(new Dimension(WIDTH,HEIGHT));
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        setLocationRelativeTo(null);
        initComponents();
        pack();
        setVisible(true);
        
    }
    
    public void initComponents(){
        panel = new MainComponent();
        panel.initElements();
        getContentPane().add(panel);
    }

    
}
