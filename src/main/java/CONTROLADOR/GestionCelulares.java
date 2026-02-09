/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.Celular;
import java.util.ArrayList;

public interface GestionCelulares {
    void guardar (Celular cel);
    void actualizar(Celular cel ,int id);
    void eliminar (int id);
    Celular buscar(int id);
    ArrayList<Celular>listar();
}
