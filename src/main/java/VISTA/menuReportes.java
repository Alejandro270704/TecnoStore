/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import CONTROLADOR.Celularimpl;
import CONTROLADOR.Detalleventaimpl;
import CONTROLADOR.GestionCelulares;
import CONTROLADOR.GestionDetalleVenta;
import CONTROLADOR.GestionVenta;
import CONTROLADOR.Ventaimpl;
import MODELO.Celular;
import MODELO.Detalle_venta;
import MODELO.Venta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class menuReportes {

    GestionCelulares gmc = new Celularimpl();
    GestionDetalleVenta gdv = new Detalleventaimpl();
    GestionVenta gv = new Ventaimpl();

    public void menureportes() {
        int op = 0;
        do {
            System.out.println("""
                           ===========================
                                 menu reportes
                           ===========================
                           1.   ver celulares con stock bajo
                           2.   ver top 3 de celulares más vendidos.
                           3.   Ventas totales por mes.
                           4.   atras
                           ===========================
                           """);
            op = new Scanner(System.in).nextInt();
            while (op < 1 || op > 4) {
                System.out.println("Error, opcion no valida");
                op = new Scanner(System.in).nextInt();
            }
            switch (op) {
                case 1:
                    ArrayList<Celular> celulares = gmc.listar();
                    System.out.println(" Celulares con stock bajo menor a 5):");

                    celulares.stream()
                            .filter(c -> c.getStock() < 5)
                            .forEach(c -> System.out.println(c));

                    break;
                case 2:
                    ArrayList<Detalle_venta> ventas = gdv.listar();
                    System.out.println("Top 3 celulares más vendidos:");

                    Map<Celular, Integer> vendidos = new HashMap<>();

                    for (Detalle_venta d : ventas) {

                        Celular cel = d.getId_celular();
                        int cantidad = d.getCantidad();

                        if (vendidos.containsKey(cel)) {
                            int totalActual = vendidos.get(cel);
                            vendidos.put(cel, totalActual + cantidad);
                        } else {
                            vendidos.put(cel, cantidad);
                        }
                    }
                    vendidos.entrySet().stream()
                            .sorted((a, b) -> b.getValue() - a.getValue())
                            .limit(3)
                            .forEach(e -> {
                                System.out.println(e.getKey());
                                System.out.println("Cantidad vendida: " + e.getValue());
                                System.out.println("---------------------------");
                            });

                    break;
                case 3:
                    ArrayList<Detalle_venta> detalles = gdv.listar();

                    System.out.println("Ventas totales por mes:");

                    Map<Integer, Double> ventasPorMes = new HashMap<>();

                    for (Detalle_venta d : detalles) {

                        Venta v = d.getId_venta();
                        int mes = v.getFecha().getMonthValue();
                        double total = v.getTotal();

                        if (ventasPorMes.containsKey(mes)) {
                            ventasPorMes.put(mes, ventasPorMes.get(mes) + total);
                        } else {
                            ventasPorMes.put(mes, total);
                        }
                    }

                    for (Integer mes : ventasPorMes.keySet()) {
                        System.out.println("Mes " + mes + " -> " + ventasPorMes.get(mes));
                    }

                    break;
                case 4:
                    System.out.println("volviendo al menu");
                    break;
            }
        } while (op != 4);
    }
}
