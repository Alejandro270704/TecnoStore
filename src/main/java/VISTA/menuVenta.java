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
import CONTROLADOR.GestionVenta;
import CONTROLADOR.Ventaimpl;
import MODELO.Celular;
import MODELO.Cliente;
import MODELO.Detalle_venta;
import MODELO.Persona;
import MODELO.Venta;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class menuVenta {

    GestionVenta gv = new Ventaimpl();
    GestionDetalleVenta gdv = new Detalleventaimpl();
    GestionCliente gc = new Clienteimpl();
    GestionCelulares gcl = new Celularimpl();

    public void menuventa() {
        int op = 0;
        do {
            System.out.println("""
                           ===========================
                                 menu venta
                           ===========================
                           1.   Registrar venta
                           2.   listar ventas
                           3.   Actualizar venta
                           4.   Eliminar venta    
                           5.   atras
                           ===========================
                           """);
            op = new Scanner(System.in).nextInt();
            while (op < 1 || op > 5) {
                System.out.println("Error, opcion no valida");
                op = new Scanner(System.in).nextInt();
            }
            switch (op) {
                case 1:
                    registrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("volviendo al menu");
                    break;

            }
        } while (op != 5);
    }

    private void registrar() {
        Venta v = new Venta();
        for (Persona p : gc.listar()) {
            System.out.println(p);
        }
        System.out.println("Ingrese el numero del cliente:");
        int idCliente = new Scanner(System.in).nextInt();

        Cliente cliente = new Cliente();
        cliente.setId(idCliente);
        v.setId_cliente(cliente);

        for (Celular c : gcl.listar()) {
            System.out.println(c);
        }
        System.out.println("ingrese el numero del celular");
        int idcel = new Scanner(System.in).nextInt();
        Celular cel = gcl.buscar(idcel);
        
        System.out.println("ingrese cuantos celulares se realizo en la compra");
        int cantidad = new Scanner(System.in).nextInt();
        if (cel.getStock() < cantidad) {
            System.out.println("No hay stock suficiente");
            return;
        }
        double precio = cel.getPrecio();
        double subtotal = gdv.calcularSubtotal(cantidad, precio);
        double total = gv.calculartotal(subtotal);
        v.setTotal(total);
        v.setFecha(LocalDate.now());
        int idVenta = gv.guardar(v);
        v.setId(idVenta);
        Detalle_venta dv = new Detalle_venta();
        dv.setId_venta(v);
        dv.setId_celular(cel);
        dv.setCantidad(cantidad);
        dv.setSubtotal(subtotal);
        gcl.actualizarStock(cel.getId(), cantidad);
        gdv.guardar(dv);
        
    }

    private void listar() {
        ArrayList<Detalle_venta> ventas = gdv.listar();
        if (ventas.isEmpty()) {
            System.out.println("no hay ventas registrados");
            return;
        }
        ventas.forEach(n -> System.out.println(n));    
        
  

    }

    private void actualizar() {
              // en construccion

    }

    private void eliminar() {
       // en construccion
    }
}
