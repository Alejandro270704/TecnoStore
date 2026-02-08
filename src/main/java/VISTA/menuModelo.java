/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import CONTROLADOR.GestionarMarca;
import CONTROLADOR.GestionarModelo;
import CONTROLADOR.Marcaimpl;
import CONTROLADOR.Modeloimpl;
import MODELO.Marca;
import MODELO.Modelo;
import java.util.ArrayList;
import java.util.Scanner;

public class menuModelo {

    GestionarModelo gm = new Modeloimpl();
    GestionarMarca gmc = new Marcaimpl();

    public void menumodelo() {
        int op = 0;
        do {
            System.out.println("""
                           ===========================
                                 menu modelo
                           ===========================
                           1.   Registrar modelo
                           2.   actualizar modelo
                           3.   eliminar modelo
                           4.   listar modelo
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
        Modelo m = new Modelo();
        System.out.println("ingrese el nombre");
        m.setNombre_modelo(new Scanner(System.in).nextLine());
        ArrayList<Marca> marcas = gmc.listar();
        if (marcas.isEmpty()) {
            System.out.println("No hay marcas registradas. Registre una marca primero.");
            return;
        }
        System.out.println("Seleccione la marca:");
        for (Marca ma : marcas) {
            System.out.println(ma.getId() + "." + ma.getNombre_marca());
        }
        int idmarca;
        Marca marcaop = null;

        do {
            System.out.print("Ingrese el numero de la marca: ");
            idmarca = new Scanner(System.in).nextInt();
            marcaop = gmc.buscar(idmarca);

            if (marcaop == null) {
                System.out.println("Marca no existe, intente otra vez.");
            }

        } while (marcaop == null);

        m.setMarca_id(marcaop);
        gm.registrar(m);
    }

    private void actualizar() {
        ArrayList<Modelo> modelos = gm.listar();
        if (modelos.isEmpty()) {
            return;
        }
        Modelo m = null;
        do {
            System.out.println("Ingrese el numero del modelo a actualizar:");
            int id = new Scanner(System.in).nextInt();
            m = gm.buscar(id);
            if (m == null) {
                System.out.println("No existe este modelo, intente otra vez.");
            }

        } while (m == null);

        System.out.println("""
                               Ingrese lo quiere modificar
                               1.   Nombre 
                               2.   Marca
                               """);
        int op = new Scanner(System.in).nextInt();
        while (op < 1 || op > 3) {
            System.out.println("Error, opcion no valida");
            op = new Scanner(System.in).nextInt();
        }
        switch (op) {
            case 1:
                System.out.println("Ingrese el nuevo nombre");
                m.setNombre_modelo(new Scanner(System.in).nextLine());
                break;
            case 2:
                ArrayList<Marca> marcas = gmc.listar();
                System.out.println("Seleccione la marca:");
                for (Marca ma : marcas) {
                    System.out.println(ma.getId() + "." + ma.getNombre_marca());
                }
                int idmarca;
                Marca marcaop = null;

                do {
                    System.out.print("Ingrese el numero de la marca: ");
                    idmarca = new Scanner(System.in).nextInt();
                    marcaop = gmc.buscar(idmarca);

                    if (marcaop == null) {
                        System.out.println("Marca no existe, intente otra vez.");
                    }

                } while (marcaop == null);

                m.setMarca_id(marcaop);

        }
        gm.actualizar(m);
    }

    private void eliminar() {
        ArrayList<Modelo> modelos = gm.listar();
        if (modelos.isEmpty()) {
            return;
        }
        Modelo m = null;
        int id = 0;
        do {
            System.out.println("Ingrese el numero del modelo a eliminar:");
            id = new Scanner(System.in).nextInt();
            m = gm.buscar(id);
            if (m == null) {
                System.out.println("No existe este modelo, intente otra vez.");
            }

        } while (m == null);
        gm.eliminar(id);
    }

    private void listar() {
        ArrayList<Modelo> modelos = gm.listar();
        if (modelos.isEmpty()) {
            System.out.println("No hay modelos registrados");
            return;
        }
        modelos.forEach(n -> System.out.println(n));
    }
}
