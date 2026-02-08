/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.Modelo;
import java.util.ArrayList;


public interface GestionarModelo {
    void registrar(Modelo m);
    void actualizar(Modelo m);
    Modelo buscar(int id);
    void eliminar(int id);
    ArrayList<Modelo>listar();
}
