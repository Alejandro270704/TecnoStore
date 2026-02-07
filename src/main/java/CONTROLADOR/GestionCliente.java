/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.Persona;
import java.util.ArrayList;


public interface GestionCliente {
    void guardar (Persona p);
    void actualizar(Persona p );
    void eliminar (int id);
    Persona buscar(int id);
    ArrayList<Persona>listar();
}
