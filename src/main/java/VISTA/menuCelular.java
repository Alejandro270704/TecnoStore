/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import java.util.Scanner;


public class menuCelular {
    public void menucelular(){
        int op = 0;
        do {
            System.out.println("""
                           ===========================
                                 menu celular
                           ===========================
                           1.   Registrar celular
                           2.   actualizar celular
                           3.   eliminar celular
                           4.   listar celulares
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
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("volviendo hacia atras");
                    break;

            }
        } while (op != 5);
    }
}
