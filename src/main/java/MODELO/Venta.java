/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.time.LocalDate;


public class Venta {
    private int id;
    private Cliente id_cliente;
    private LocalDate fecha;
    private double total;
    
    public Venta(int id, Cliente id_cliente, LocalDate fecha, double total) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.total = total;
    }
    public Venta(){
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    @Override
    public String toString() {
    return """
           ----------------------------
           VENTA
           ----------------------------
           ID Venta : %d
           Cliente  : %s
           Fecha    : %s
           Total    : %s
           ----------------------------
           """.formatted(
            id,
            id_cliente.getNombre(),
            fecha,
            total
    );
}
    
    
}
