package CONTROLADOR;

import MODELO.Detalle_venta;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JFrame; 

public class ReporteVentas implements GestionReporte {

    @Override
    public void generarReporte(ArrayList<Detalle_venta> ventas) {
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

                for (Detalle_venta dv : ventas) {
                    String reporte = """
                        ID Detalle : %s
                        Venta ID   : %s
                        Cliente    : %s
                        Fecha      : %s
                        Total Venta: %s
                        Celular ID : %d
                        Modelo     : %s
                        Marca      : %s
                        SO         : %s
                        Gama       : %s
                        Precio     : %s
                        Stock      : %s
                        Cantidad   : %s
                        Subtotal   : %s
                        ----------------------------
                        """.formatted(
                            dv.getId(),
                            dv.getId_venta().getId(),
                            dv.getId_venta().getId_cliente().getNombre(),
                            dv.getId_venta().getFecha(),
                            dv.getId_venta().getTotal(),
                            dv.getId_celular().getId(),
                            dv.getId_celular().getModelo_id().getNombre_modelo(),
                            dv.getId_celular().getModelo_id().getMarca_id().getNombre_marca(),
                            dv.getId_celular().getSistema_operativo(),
                            dv.getId_celular().getGama() ,
                            dv.getId_celular().getPrecio(),
                            dv.getId_celular().getStock(),
                            dv.getCantidad(),
                            dv.getSubtotal()
                        );
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