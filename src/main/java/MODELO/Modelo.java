/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;


public class Modelo {
    private int id;
    private String nombre_modelo;
    private Marca marca_id;

    public Modelo(int id, String nombre_modelo, Marca marca_id) {
        this.id = id;
        this.nombre_modelo = nombre_modelo;
        this.marca_id = marca_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_modelo() {
        return nombre_modelo;
    }

    public void setNombre_modelo(String nombre_modelo) {
        this.nombre_modelo = nombre_modelo;
    }

    public Marca getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(Marca marca_id) {
        this.marca_id = marca_id;
    }



    public Modelo() {
    }

    @Override
    public String toString() {
    String nombreMarca = (marca_id != null) ? marca_id.getNombre_marca() : "";
        return """
               -----------------------------
               ID:  %s
               Nombre: %s
               Marca:  %s
               -----------------------------
               """.formatted(id,nombre_modelo,nombreMarca);
    }

    
}
