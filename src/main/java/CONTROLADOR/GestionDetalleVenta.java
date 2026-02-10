/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.Detalle_venta;
import java.util.ArrayList;

public interface GestionDetalleVenta {
    void guardar (Detalle_venta dv);
   void actualizar(Detalle_venta dv ,int id);
   void eliminar (int id);
   double calcularSubtotal(int cantidad,double precio);
   Detalle_venta buscar(int id);
   ArrayList<Detalle_venta>listar();
}
