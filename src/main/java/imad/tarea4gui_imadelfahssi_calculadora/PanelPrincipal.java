/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.tarea4gui_imadelfahssi_calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author MSI
 */
public class PanelPrincipal extends JPanel {
    
	// Atributos de la clase (privados)
	private PanelBotones botonera;
	private JTextArea areaTexto;
	private int tipoOperacion;
    
	// Constructor
	public PanelPrincipal(){
    		initComponents();
    		tipoOperacion = -1; // No hay operaciones en la calculadora
	}
    
	// Se inicializan los componentes gráficos y se colocan en el panel
	private void initComponents(){
    		// Creamos el panel de botones
    		botonera = new PanelBotones();
    		// Creamos el área de texto
    		areaTexto = new JTextArea(10,50);
    		areaTexto.setEditable(false);
    		areaTexto.setBackground(Color.white);
   
    		//Establecemos layout del panel principal
    		this.setLayout(new BorderLayout());
    		// Colocamos la botonera y el área texto
    		this.add(areaTexto, BorderLayout.NORTH);
    		this.add(botonera, BorderLayout.SOUTH);
	 
	}
}