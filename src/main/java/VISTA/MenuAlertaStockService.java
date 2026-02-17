/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import CONTROLADOR.AlertaStockService;
import CONTROLADOR.Celularimpl;
import CONTROLADOR.GestionAlertaStockService;
import CONTROLADOR.GestionCelulares;
import MODELO.Celular;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuAlertaStockService {

    GestionCelulares gmc = new Celularimpl();

    public void menuStock() {
        ArrayList<Celular> celulares = null;
        int op = 0;

        do {
            System.out.println("""
                           ===========================
                            menu stock bajo celulares
                           ===========================
                           1.   ver celulares con stock bajo
                           2.   generar archivo txt.
                           3.   atras
                           ===========================
                           """);
            op = new Scanner(System.in).nextInt();
            while (op < 1 || op > 3) {
                System.out.println("Error, opcion no valida");
                op = new Scanner(System.in).nextInt();
            }
            switch (op) {
                case 1:
                    celulares = gmc.listar();
                    System.out.println(" Celulares con stock bajo menor a 5):");
                    System.out.println("-----------------------------");

                    celulares.stream()
                            .filter(c -> c.getStock() <= 5)
                            .forEach(c -> System.out.println(c));
                    break;

                case 2:
                    celulares = gmc.listar();
                    System.out.println("espere generando el reporte....");
                    GestionAlertaStockService alerta = new AlertaStockService();
                    alerta.archivo_txt(celulares);
                   
                    break;

                case 3:
                    System.out.println("volviendo al menu");
                    break;
            }
        } while (op != 3);
    }

}
