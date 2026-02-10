/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.Venta;

public interface GestionVenta {
   int guardar (Venta v);
   void actualizar(Venta v ,int id);
   void eliminar (int id);
   Venta buscar(int id);
   double calculartotal(double subtotal);
}
