/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import CONTROLADOR.Clienteimpl;
import CONTROLADOR.GestionCliente;
import MODELO.Cliente;
import MODELO.Persona;
import java.util.ArrayList;
import java.util.Scanner;

public class menuCliente {

    GestionCliente gc = new Clienteimpl();

    public void menucliente() {
        int op = 0;
        do {
            System.out.println("""
                           ===========================
                                 menu cliente
                           ===========================
                           1.   Registrar cliente
                           2.   actualizar cliente
                           3.   eliminar cliente
                           4.   listar clientes
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
                    System.out.println("volviendo al menu");
                    break;

            }
        } while (op != 5);

    }

    private void registrar() {
        Cliente cl = new Cliente();
        System.out.println("Ingrese el nombre:");
        cl.setNombre(new Scanner(System.in).nextLine());
        System.out.println("Ingrese su identificacion:");
        String identificacion = new Scanner(System.in).nextLine();
        for (Persona p: gc.listar()) {
            while (p.getIdentificacion().equals(identificacion)) {
                System.out.println("Identificacion repetida ingrese otra:");
                identificacion = new Scanner(System.in).nextLine();
            }
        }
        cl.setIdentificacion(identificacion);
        System.out.println("Ingrese el correo:");
        String correo = new Scanner(System.in).nextLine();
        while (!correo.contains("@")|| !correo.contains(".")) {
            System.out.println("correo invalido");
            System.out.println("ingrese el correo:");
            correo = new Scanner(System.in).nextLine();
        }
        cl.setCorreo(correo);
        System.out.println("ingrese el numero de telefono");
        cl.setTelefono(new Scanner(System.in).nextLine());
        gc.guardar(cl);
    }

    private void listar() {
        ArrayList<Persona> personas = gc.listar();
        if (personas.isEmpty()) {
            System.out.println("no hay clientes registrados");
            return;
        }
        personas.forEach(n -> {
            System.out.println("-----------------------------");
            System.out.println("ID: " + n.getId());
            System.out.println("Nombre: " + n.getNombre());
            System.out.println("Identificación: " + n.getIdentificacion());
            System.out.println("Correo: " + n.getCorreo());
            System.out.println("Teléfono: " + n.getTelefono());
            System.out.println("-----------------------------");
        });

    }

    private void actualizar() {
        ArrayList<Persona> personas = gc.listar();
        if (personas.isEmpty()) {
            return;
        }
        Persona p = null;
        do {
            System.out.println("Ingrese el numero del cliente a actualizar:");
            int id = new Scanner(System.in).nextInt();
            p = gc.buscar(id);
            if (p == null) {
                System.out.println("No existe este cliente, intente otra vez.");
            }

        } while (p == null);

        System.out.println("""
                               Ingrese el numero de lo quiere modificar
                               1.   Nombre
                               2.   Identificacion
                               3.   Correo
                               4.   Telefono 
                               """);
        int op = new Scanner(System.in).nextInt();
        while (op < 1 || op > 4) {
            System.out.println("Error, opcion no valida");
            op = new Scanner(System.in).nextInt();
        }
        switch (op) {
            case 1:
                System.out.println("Ingrese el nuevo nombre");
                p.setNombre(new Scanner(System.in).nextLine());
                break;
            case 2:
                System.out.println("Ingrese la nueva identificacion");
                p.setIdentificacion(new Scanner(System.in).nextLine());
                break;
            case 3:
                System.out.println("Ingrese el nuevo correo");
                p.setCorreo(new Scanner(System.in).nextLine());
                break;
            case 4:
                System.out.println("Ingrese el nuevo telefono");
                p.setTelefono(new Scanner(System.in).nextLine());

                break;
        }
        gc.actualizar(p);
    }

    private void eliminar() {
        ArrayList<Persona> personas = gc.listar();
        if (personas.isEmpty()) {
            return;
        }
        Persona p = null;
        int id = 0;
        do {
            System.out.println("Ingrese el numero del cliente a eliminar:");
            id = new Scanner(System.in).nextInt();
            p = gc.buscar(id);
            if (p == null) {
                System.out.println("No existe este cliente, intente otra vez.");
            }

        } while (p == null);
        gc.eliminar(id);
    }

}
