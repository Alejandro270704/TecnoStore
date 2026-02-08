/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

public class Celular {
    private Modelo modelo_id;
    private enum sistema_operativo{Android,iOS,WindowsPhone,BlackBerry,HarmonyOS};
    private enum gama{alta,media,baja};
    private int stock ;

    public Celular(Modelo modelo_id, int stock) {
        this.modelo_id = modelo_id;
        this.stock = stock;
    }

    public Celular() {
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
