/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;


public class Marca {
    private int id;
    private String nombre_marca;

    public Marca() {
    }

    public Marca(int id, String nombre_marca) {
        this.id = id;
        this.nombre_marca = nombre_marca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_marca() {
        return nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }

    

    @Override
    public String toString() {
        return"""
              ID: %s
              NOMBRE: %s
              """.formatted(id,nombre_marca);
    }

    
    
}
