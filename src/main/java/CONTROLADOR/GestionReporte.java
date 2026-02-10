/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.Detalle_venta;
import java.util.ArrayList;

public interface GestionReporte {
    void generarReporte(ArrayList<Detalle_venta> ventas);
}
