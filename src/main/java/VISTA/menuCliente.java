/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import CONTROLADOR.Clienteimpl;
import CONTROLADOR.GestionCliente;
import MODELO.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

public class menuCliente {
    GestionCliente gc= new Clienteimpl();
    public void menucliente() {
      int op=0;
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
        cl.setIdentificacion(new Scanner(System.in).nextLine());
        System.out.println("Ingrese el correo:");
        cl.setCorreo(new Scanner(System.in).nextLine());
        System.out.println("ingrese el numero de telefono");
        cl.setTelefono(new Scanner(System.in).nextLine());
        gc.guardar(cl);
    }
    private void listar() {
        ArrayList<Cliente> clientes = gc.listar();
        clientes.stream().forEach(n-> System.out.println(n.getId()+"."+n.getNombre() ));
    }
    private void actualizar(){
    System.out.println("Ingrese el numero del cliente a actualizar");
        int id = new Scanner(System.in).nextInt();
        Cliente cl = gc.buscar(id);
        System.out.println("""
                               Ingrese lo quiere modificar
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
                    cl.setNombre(new Scanner(System.in).nextLine());
                    break;
                case 2:
                    System.out.println("Ingrese la nueva identificacion");
                    cl.setIdentificacion(new Scanner(System.in).nextLine());
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo correo");
                    cl.setCorreo(new Scanner(System.in).nextLine());
                    break;
                case 4:
                    System.out.println("Ingrese el nuevo telefono");
                    cl.setTelefono(new Scanner(System.in).nextLine());
                    
                    
                    break;
            }
            gc.actualizar(cl);
    }
   
}
