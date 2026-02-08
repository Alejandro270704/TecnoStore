/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import CONTROLADOR.GestionarMarca;
import CONTROLADOR.Marcaimpl;
import MODELO.Marca;
import java.util.ArrayList;
import java.util.Scanner;

public class menuMarca {

    GestionarMarca gm = new Marcaimpl();

    public void menumarca() {
        int op = 0;
        do {
            System.out.println("""
                           ===========================
                                 menu marca
                           ===========================
                           1.   Registrar marca
                           2.   actualizar marca
                           3.   eliminar marca
                           4.   listar marcas
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
                    actualizar();
                    break;
                case 3:
                    listar();
                    eliminar();
                    break;
                case 4:
                    listar();
                    break;
                case 5:
                    System.out.println("volviendo hacia atras");
                    break;

            }
        } while (op != 5);
    }

    private void registrar() {
        Marca m = new Marca();
        System.out.println("ingrese el nombre");
        m.setNombre_marca(new Scanner(System.in).nextLine());
        gm.registrar(m);
    }

    private void actualizar() {
        ArrayList<Marca> marcas = gm.listar();
        if (marcas.isEmpty()) {
            return;
        }
        Marca m = null;
        do {
            System.out.println("Ingrese el numero de la marca a actualizar:");
            int id = new Scanner(System.in).nextInt();
            m = gm.buscar(id);
            if (m == null) {
                System.out.println("No existe esta marca, intente otra vez.");
            }

        } while (m == null);

        System.out.println("""
                               Ingrese lo quiere modificar
                               1.   Nombre 
                               """);
        int op = new Scanner(System.in).nextInt();
        while (op < 1 || op > 1) {
            System.out.println("Error, opcion no valida");
            op = new Scanner(System.in).nextInt();
        }
        switch (op) {
            case 1:
                System.out.println("Ingrese el nuevo nombre");
                m.setNombre_marca(new Scanner(System.in).nextLine());
                break;

        }
        gm.actualizar(m);
    }

    private void eliminar() {
        ArrayList<Marca> marcas = gm.listar();
        if (marcas.isEmpty()) {
            return;
        }
        Marca m = null;
        int id = 0;
        do {
            System.out.println("Ingrese el numero de la marca a eliminar:");
            id = new Scanner(System.in).nextInt();
            m = gm.buscar(id);
            if (m == null) {
                System.out.println("No existe esta marca, intente otra vez.");
            }

        } while (m == null);
        gm.eliminar(id);
    }

    private void listar() {
        ArrayList<Marca> marcas = gm.listar();
        if (marcas.isEmpty()) {
            System.out.println("No hay marcas registradas");
            return;
        }
        marcas.forEach(n -> System.out.println(n));
        
    }
}
