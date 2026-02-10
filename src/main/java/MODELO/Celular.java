/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

public class Celular {

    private int id;
    private Modelo modelo_id;
    private sistema_operativo sistema_operativo;
    private gama gama;
    private double precio;
    private int stock;

    public Celular() {
    }

    public enum sistema_operativo {
        Android, iOS, WindowsPhone, BlackBerry, HarmonyOS
    }

    public enum gama {
        alta, media, baja
    }

    public Celular(int id, Modelo modelo_id, sistema_operativo sistema_operativo, gama gama, double precio, int stock) {
        this.id = id;
        this.modelo_id = modelo_id;
        this.sistema_operativo = sistema_operativo;
        this.gama = gama;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Modelo getModelo_id() {
        return modelo_id;
    }

    public void setModelo_id(Modelo modelo_id) {
        this.modelo_id = modelo_id;
    }

    public sistema_operativo getSistema_operativo() {
        return sistema_operativo;
    }

    public void setSistema_operativo(sistema_operativo sistema_operativo) {
        this.sistema_operativo = sistema_operativo;
    }

    public gama getGama() {
        return gama;
    }

    public void setGama(gama gama) {
        this.gama = gama;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getSistemaenum() {
        switch (sistema_operativo) {
            case Android:
                return "Android";
            case iOS:
                return "iOS";
            case WindowsPhone:
                return "Windows Phone";
            case BlackBerry:
                return "BlackBerry";
            case HarmonyOS:
                return "HarmonyOS";

        }
        throw new IllegalStateException("error valor desconocido");
    }

    public String getGamaenum() {
        switch (gama) {
            case alta:
                return "Alta";
            case media:
                return "Media";
            case baja:
                return "Baja";

        }
        throw new IllegalStateException("error valor desconocido");
    }

    public String toString() {
        return """
           ID: %s
           Modelo: %s
           Marca: %s
           SO: %s
           Gama: %s
           Precio: %s
           Stock: %s
           ---------------------------
           """.formatted(id, modelo_id.getNombre_modelo(), modelo_id.getMarca_id().getNombre_marca(), sistema_operativo, gama, precio, stock);
    }

}
