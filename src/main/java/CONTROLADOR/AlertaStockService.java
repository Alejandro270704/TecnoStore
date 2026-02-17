/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.Celular;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;




public class AlertaStockService implements GestionAlertaStockService {

    @Override
    public void archivo_txt(ArrayList<Celular> celulares) {
        JFrame frameTemporal = new JFrame();
        frameTemporal.setAlwaysOnTop(true);
        frameTemporal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JFileChooser selector = new JFileChooser();
        selector.setDialogTitle("Seleccione la ubicación y nombre del reporte");

        int resultado = selector.showSaveDialog(frameTemporal);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            String ruta = selector.getSelectedFile().getAbsolutePath();
            if (!ruta.toLowerCase().endsWith(".txt")) {
                ruta += ".txt";
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
                bw.write("======= REPORTE DE VENTAS =======\n");

                for (Celular c : celulares) {
                    String reporte = c.toString();
                    bw.write(reporte);
                }

                JOptionPane.showMessageDialog(frameTemporal, "Reporte guardado con éxito.");

            } catch (IOException e) {
                JOptionPane.showMessageDialog(frameTemporal, "Error: " + e.getMessage());
            }
        }
        
        frameTemporal.dispose();
    }

    
    }

        
    

