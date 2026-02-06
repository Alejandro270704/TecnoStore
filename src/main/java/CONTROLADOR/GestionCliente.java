/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.Cliente;
import java.util.ArrayList;


public interface GestionCliente {
    void guardar (Cliente cl);
    void actualizar(Cliente cl );
    void eliminar (int id);
    Cliente buscar(int id);
    ArrayList<Cliente>listar();
}
