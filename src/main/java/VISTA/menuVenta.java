/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import java.util.Scanner;

public class menuVenta {
     public void menuventa(){
        int op = 0;
        do {
            System.out.println("""
                           ===========================
                                 menu venta
                           ===========================
                           1.   Registrar venta
                           2.   Calcular el total de la venta
                           3.   Actualizar el stock del celular vendido
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
