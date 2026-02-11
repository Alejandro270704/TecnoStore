/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import CONTROLADOR.Celularimpl;
import CONTROLADOR.Clienteimpl;
import CONTROLADOR.Detalleventaimpl;
import CONTROLADOR.GestionCelulares;
import CONTROLADOR.GestionCliente;
import CONTROLADOR.GestionDetalleVenta;
import CONTROLADOR.GestionReporte;
import CONTROLADOR.GestionVenta;
import CONTROLADOR.ReporteVentas;
import CONTROLADOR.Ventaimpl;
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
