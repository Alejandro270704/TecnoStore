/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import CONTROLADOR.Celularimpl;
import CONTROLADOR.GestionCelulares;
import CONTROLADOR.GestionarModelo;
import CONTROLADOR.Modeloimpl;
import MODELO.Celular;
import MODELO.Modelo;
import java.util.ArrayList;
import java.util.Scanner;

public class menuCelular {

    GestionCelulares gmc = new Celularimpl();
    GestionarModelo gm = new Modeloimpl();

    public void menucelular() {
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
        Celular c = new Celular();
        ArrayList<Modelo> modelos = gm.listar();
        if (modelos.isEmpty()) {
            System.out.println("No hay modelos registrados");
            return;
        }
        System.out.println("Seleccione modelo:");
        for (Modelo m : modelos) {
            System.out.println(m.getId() + ". " + m.getNombre_modelo());
        }
        int idModelo = new Scanner(System.in).nextInt();
        Modelo modelo = new Modelo();
        modelo.setId(idModelo);
        c.setModelo_id(modelo);
        System.out.println("""
                                Seleccione sistema operativo:
                                1. Android
                                2. iOS
                                3. WindowsPhone
                                4. BlackBerry
                                5. HarmonyOS
                                """);

                int ops = new Scanner(System.in).nextInt();
                while (ops < 1 || ops > 5) {
                    System.out.println("Error, opcion no valida");
                    ops = new Scanner(System.in).nextInt();
                }
                switch (ops) {
                    case 1:
                        c.setSistema_operativo(Celular.sistema_operativo.Android);
                        break;
                    case 2:
                        c.setSistema_operativo(Celular.sistema_operativo.iOS);
                        break;
                    case 3:
                        c.setSistema_operativo(Celular.sistema_operativo.WindowsPhone);
                        break;
                    case 4:
                        c.setSistema_operativo(Celular.sistema_operativo.BlackBerry);
                        break;
                    case 5:
                        c.setSistema_operativo(Celular.sistema_operativo.HarmonyOS);
                        break;
                }
        System.out.println("""
                                   Seleccione la gama:
                                   1. alta
                                   2. media
                                   3. baja
                                   """);

                int opg = new Scanner(System.in).nextInt();
                while (opg < 1 || opg > 3) {
                    System.out.println("Error, opcion no valida");
                    opg = new Scanner(System.in).nextInt();
                }
                switch (opg) {
                    case 1:
                        c.setGama(Celular.gama.alta);
                        break;
                    case 2:
                        c.setGama(Celular.gama.media);
                        break;
                    case 3:
                        c.setGama(Celular.gama.baja);
                        break;
                }
        System.out.print("Precio: ");
        double p= new Scanner(System.in).nextDouble();
        while(p<0){
            System.out.println("el precio debe ser un numero mayor a 0");
            p= new Scanner(System.in).nextDouble();
        }
        c.setPrecio(p);
        
        System.out.print("Stock: ");
        int s= new Scanner(System.in).nextInt();
        while(s<0){
            System.out.println("el stock debe ser un numero mayor a 0");
            s= new Scanner(System.in).nextInt();
        }
        c.setStock(s);

        gmc.guardar(c);
    }

    private void actualizar() {
        ArrayList<Celular> celulares = gmc.listar();
        if (celulares.isEmpty()) {
            return;
        }

        Celular c = null;
        do {
            System.out.println("Ingrese el numero del celular a actualizar:");
            int id = new Scanner(System.in).nextInt();
            c = gmc.buscar(id);

            if (c == null) {
                System.out.println("No existe este celular, intente otra vez.");
            }

        } while (c == null);

        System.out.println("""
                           Ingrese lo que quiere modificar
                           1. Sistema operativo
                           2. Gama
                           3. Precio
                           4. Stock
                           """);

        int op = new Scanner(System.in).nextInt();
        while (op < 1 || op > 4) {
            System.out.println("Error, opcion no valida");
            op = new Scanner(System.in).nextInt();
        }

        switch (op) {
            case 1:
                System.out.println("""
                                Seleccione sistema operativo:
                                1. Android
                                2. iOS
                                3. WindowsPhone
                                4. BlackBerry
                                5. HarmonyOS
                                """);

                int ops = new Scanner(System.in).nextInt();
                while (ops < 1 || ops > 5) {
                    System.out.println("Error, opcion no valida");
                    ops = new Scanner(System.in).nextInt();
                }
                switch (ops) {
                    case 1:
                        c.setSistema_operativo(Celular.sistema_operativo.Android);
                        break;
                    case 2:
                        c.setSistema_operativo(Celular.sistema_operativo.iOS);
                        break;
                    case 3:
                        c.setSistema_operativo(Celular.sistema_operativo.WindowsPhone);
                        break;
                    case 4:
                        c.setSistema_operativo(Celular.sistema_operativo.BlackBerry);
                        break;
                    case 5:
                        c.setSistema_operativo(Celular.sistema_operativo.HarmonyOS);
                        break;
                }
                break;
            case 2:
                System.out.println("""
                                   Seleccione la gama:
                                   1. alta
                                   2. media
                                   3. baja
                                   """);

                int opg = new Scanner(System.in).nextInt();
                while (opg < 1 || opg > 3) {
                    System.out.println("Error, opcion no valida");
                    opg = new Scanner(System.in).nextInt();
                }
                switch (opg) {
                    case 1:
                        c.setGama(Celular.gama.alta);
                        break;
                    case 2:
                        c.setGama(Celular.gama.media);
                        break;
                    case 3:
                        c.setGama(Celular.gama.baja);
                        break;
                }
                break;

            case 3:
                System.out.println("Ingrese el nuevo precio:");
                c.setPrecio(new Scanner(System.in).nextDouble());
                break;

            case 4:
                System.out.println("Ingrese el nuevo stock:");
                c.setStock(new Scanner(System.in).nextInt());
                break;
        }

        gmc.actualizar(c, c.getId());
    }

    private void eliminar() {
        ArrayList<Celular> celulares = gmc.listar();
        if (celulares.isEmpty()) {
            return;
        }
        System.out.print("Ingrese ID del celular a eliminar: ");
        int id = new Scanner(System.in).nextInt();
        gmc.eliminar(id);
    }

    private void listar() {
        ArrayList<Celular> celulares = gmc.listar();
        if (celulares.isEmpty()) {
            System.out.println("No hay celulares");
            return;
        }
        celulares.forEach(n -> System.out.println(n));
    }

}
