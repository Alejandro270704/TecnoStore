/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import java.util.Scanner;

public class menuReportes {

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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("volviendo al menu");
                    break;
            }
        } while (op != 4);
    }
}
