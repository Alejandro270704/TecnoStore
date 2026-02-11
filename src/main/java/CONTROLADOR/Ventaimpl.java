/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.Cliente;
import MODELO.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ventaimpl implements GestionVenta {

   

    @Override
    public int guardar(Venta v) {
        int idVenta = 0;
        try (Connection con = Conexion.getconexion().conectar()) {
            PreparedStatement ps = con.prepareStatement("insert into venta(id_cliente, fecha, total) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, v.getId_cliente().getId());
            ps.setString(2, v.getFecha().toString());
            ps.setDouble(3, v.getTotal());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idVenta = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return idVenta;
    }

    @Override
    public void actualizar(Venta v, int id) {
    try (Connection con = Conexion.getconexion().conectar()) {

        PreparedStatement ps = con.prepareStatement("update venta set id_cliente=?, fecha=?, total=? where id=?");
        ps.setInt(1, v.getId_cliente().getId());
        ps.setTimestamp(2, java.sql.Timestamp.valueOf(v.getFecha().atStartOfDay()));
        ps.setDouble(3, v.getTotal());
        ps.setInt(4, id);
        ps.executeUpdate();

        System.out.println("ACTUALIZACION EXITOSA!");

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

    @Override
    public void eliminar(int id) {
        try (Connection con = Conexion.getconexion().conectar()) {
            PreparedStatement ps = con.prepareStatement("delete from venta where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Venta buscar(int id) {
        Venta v = null;
        try (Connection con = Conexion.getconexion().conectar()) {
            PreparedStatement ps = con.prepareStatement("select v.id_cliente, v.id,v.fecha,v.total from venta v where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                v = new Venta();
                v.setId(rs.getInt(2));
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                v.setId_cliente(c);
                v.setFecha(rs.getDate(3).toLocalDate());
                v.setTotal(rs.getDouble(4));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return v;
    }

    @Override
    public double calculartotal(double subtotal) {
        double total = 0;
        total = subtotal * 0.19 + subtotal;
        return total;
    }

}
