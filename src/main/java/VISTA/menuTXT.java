/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;


import CONTROLADOR.Detalleventaimpl;
import CONTROLADOR.GestionDetalleVenta;
import CONTROLADOR.GestionReporte;
import CONTROLADOR.ReporteVentas;
import MODELO.Detalle_venta;
import java.util.ArrayList;


public class menuTXT {
    GestionDetalleVenta gdv = new Detalleventaimpl();
    public void menu(){
        ArrayList<Detalle_venta> ventas = gdv.listar();
                    
                    if (!ventas.isEmpty()) {
                        System.out.println("espere generando el reporte....");
                        GestionReporte reporte = new ReporteVentas();
                        reporte.generarReporte(ventas);
                    } else {
                        System.out.println("No hay ventas para generar el reporte");
                    }
    }   
}
