/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

public class Detalle_venta {

    private int id;
    private Venta id_venta;
    private Celular id_celular;
    private int cantidad;
    private double subtotal;

    public Detalle_venta() {
    }

    public Detalle_venta(int id, Venta id_venta, Celular id_celular, int cantidad, double subtotal) {
        this.id = id;
        this.id_venta = id_venta;
        this.id_celular = id_celular;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Venta getId_venta() {
        return id_venta;
    }

    public void setId_venta(Venta id_venta) {
        this.id_venta = id_venta;
    }

    public Celular getId_celular() {
        return id_celular;
    }

    public void setId_celular(Celular id_celular) {
        this.id_celular = id_celular;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return String.format("""
        ----------------------------
                  VENTA
        ----------------------------
        Venta ID  : %s
        Cliente   : %s
        Fecha     : %s
        ----------------------------
        Celular ID: %s
        Modelo    : %s
        Marca     : %s
        SO        : %s
        Gama      : %s
        Precio    : %s
        Stock     : %s
        ----------------------------
        Cantidad  : %s
        Subtotal  : %s
        Total + iva: %s
        ----------------------------
        """,
                id_venta.getId(),
                id_venta.getId_cliente().getNombre(),
                id_venta.getFecha(),
                id_celular.getId(),
                id_celular.getModelo_id().getNombre_modelo(),
                id_celular.getModelo_id().getMarca_id().getNombre_marca(),
                id_celular.getSistema_operativo(),
                id_celular.getGama(),
                id_celular.getPrecio(),
                id_celular.getStock(),
                cantidad,
                subtotal,
                id_venta.getTotal()
        );
    }

}
