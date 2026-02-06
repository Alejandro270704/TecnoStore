/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package VISTA;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int op=0;
        do {
            System.out.println("""
                           ===========================
                           1.   Gestión de Celulares
                           2.   Gestión de Clientes
                           3.   Gestión de Ventas
                           4.   Reportes y análisis
                           5.   Generar reporte
                           6.   salir
                           ===========================
                           """);
            op = new Scanner(System.in).nextInt();
            while (op < 1 || op > 6) {
                System.out.println("Error, opcion no valida");
                op = new Scanner(System.in).nextInt();
            }
            switch (op) {
                case 1:
                    
                    break;
                case 2:
                    menuCliente m=new menuCliente();
                    m.menucliente();
                    break;
                case 3:
                    
                    break;
                case 4: 
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    System.out.println("Gracias por usar nuestro sistema!");
                    break;
                
            }
        } while (op != 6);   
    }
}
