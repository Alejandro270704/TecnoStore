/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

public class Celular {
    private Marca marca_id;
    private Modelo modelo_id;
    private enum sistema_operativo{Android,iOS,WindowsPhone,BlackBerry,HarmonyOS};
    private enum gama{alta,media,baja};
    private int stock ;

    public Celular(Marca marca_id, Modelo modelo_id, int stock) {
        this.marca_id = marca_id;
        this.modelo_id = modelo_id;
        this.stock = stock;
    }

    public Marca getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(Marca marca_id) {
        this.marca_id = marca_id;
    }

    public Modelo getModelo_id() {
        return modelo_id;
    }

    public void setModelo_id(Modelo modelo_id) {
        this.modelo_id = modelo_id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

   


  
}
