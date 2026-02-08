/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import java.util.Scanner;

public class menuPaquete {
    public void menupaquete(){
        int op = 0;
        do {
            System.out.println("""
                           ===========================
                                      menu
                           ===========================
                           1.   gestionar celular
                           2.   gestionar modelo
                           3.   gestionar marca 
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
                    menuCelular mc=new menuCelular();
                    mc.menucelular();;
                    break;
                case 2:
                    menuModelo mm= new menuModelo();
                    mm.menumodelo();
                    break;
                case 3:
                    menuMarca mrc= new menuMarca();
                    mrc.menumarca();
                    break;
                case 4:
                    System.out.println("volviendo al menu");
                    break;
                

            }
        } while (op != 4);
    }
}
