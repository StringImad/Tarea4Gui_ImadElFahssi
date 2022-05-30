/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.tarea4gui_imadelfahssi_calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author MSI
 */
public class PanelPrincipal extends JPanel implements ActionListener {

    // Atributos de la clase (privados)
    private PanelBotones botonera;
    private JTextArea areaTexto;
    private int tipoOperacion;

    // Constructor
    public PanelPrincipal() {
        initComponents();
        tipoOperacion = -1; // No hay operaciones en la calculadora
    }

    // Se inicializan los componentes gráficos y se colocan en el panel
    private void initComponents() {
        // Creamos el panel de botones
        botonera = new PanelBotones();
        // Creamos el área de texto
        areaTexto = new JTextArea(10, 50);
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.white);

        //Establecemos layout del panel principal
        this.setLayout(new BorderLayout());
        // Colocamos la botonera y el área texto
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);
        for (JButton boton : this.botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
// Se obtiene el objeto que desencadena el evento
        Object o = ae.getSource();
        String num1="", num2 = "";
        String signoOperacion = null;

        // Si es un botón
        if (o instanceof JButton) {
            JButton botonCreado = (JButton) o;

            //condicion que  recorre el array y cada vez que pulsa un boton escribe valor pulsado pulsado
            for (int i = 0; i < this.botonera.getgrupoBotones().length; i++) {

                if (ae.getSource() == botonera.grupoBotones[i] && i < 10) {

                    areaTexto.setText(areaTexto.getText() + ("" + i));
                }

                if (ae.getSource() == botonera.grupoBotones[i] && i > 9) {

                    if (botonCreado.getText().equals("+")) {
                        //Si el area de texto no esta vacia me almacena lo que hay en num1
                        if (!areaTexto.getText().equals("")) {
                            num1 = areaTexto.getText();
                            // areaTexto.setText(areaTexto.getText() + ("+"));

                            //almacenamos el signo en esta variable
                            signoOperacion = "+";

                            //volevemos a limpiar el panel
                            areaTexto.setText("");

                        }
                        signoOperacion = "+";

                    } else if (botonCreado.getText().equals("-")) {

                        //nos aseguramos que no este en blanco
                        if (!areaTexto.getText().equals("")) {
                            num1 = areaTexto.getText();
                            signoOperacion = "-";

                            areaTexto.setText("");

                        }
                        signoOperacion = "-";

                    } else if (botonCreado.getText().equals("/")) {

                        if (!areaTexto.getText().equals("")) {
                            num1 = areaTexto.getText();
                            signoOperacion = "/";
                            areaTexto.setText("");

                        }
                        signoOperacion = "/";

                    } else if (botonCreado.getText().equals("*")) {

                        num1 = areaTexto.getText();
                        signoOperacion = "*";
                        areaTexto.setText("");
                    }

                    if (botonCreado.getText().equals("=")) {
                        String resultado2;

                        //al limpiar siempre los paneles cada vez que damos a un signo, ahora cogemos el siguiente numero y lo almacenamos en num2
                        num2 = areaTexto.getText();
                        if (!num2.equals("")) {
                            resultado2 = calculo(num1, num2, signoOperacion);
                            areaTexto.setText(resultado2);
                        }
                    } else if (botonCreado.getText().equals("C")) {
                        areaTexto.setText(" ");
                    }

                }
            }

            // RESTO DEL CÓDIGO DE LA LÓGICA DE LA CALCULADORA
        }

    }
    // metodo privado estatico que recibe los numeros pulsados y el signo de operacion 

    private static String calculo(String num1, String num2, String signoOperacion) {
        Double resultado = 0.0;
        String resuelto;

        switch (signoOperacion) {
            case "+":
                //hago conversiones para poder sumar strings
                resultado = Double.parseDouble(num1) + Double.parseDouble(num2);

                break;
            case "-":
                resultado = Double.parseDouble(num1) - Double.parseDouble(num2);

                break;
            case "/":
                resultado = Double.parseDouble(num1) / Double.parseDouble(num2);

                break;
            case "*":
                resultado = Double.parseDouble(num1) * Double.parseDouble(num2);

                break;
        }
        //Debemos de hacer una conversion para guardar double en string 
        resuelto = resultado.toString();

        return resuelto;

    }
}
