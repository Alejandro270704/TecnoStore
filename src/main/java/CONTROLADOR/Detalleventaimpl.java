/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.Celular;
import MODELO.Cliente;
import MODELO.Detalle_venta;
import MODELO.Marca;
import MODELO.Modelo;
import MODELO.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Detalleventaimpl implements GestionDetalleVenta {

    Conexion c = new Conexion();

    @Override
    public void guardar(Detalle_venta dv) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("insert into detalle_venta(id_venta, id_celular, cantidad,subtotal) values (?,?,?,?)");
            ps.setInt(1, dv.getId_venta().getId());
            ps.setInt(2, dv.getId_celular().getId());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getSubtotal());
            ps.executeUpdate();
            System.out.println("REGISTRO EXITOSO!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizar(Detalle_venta dv, int id) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("update detalle_venta set id_venta = ?, id_celular = ?, cantidad = ?, subtotal = ? where id = ?");
            ps.setInt(1, dv.getId_venta().getId());
            ps.setInt(2, dv.getId_celular().getId());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getSubtotal());
            ps.setInt(5, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Detalle_venta buscar(int id) {
        Detalle_venta dv = null;
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement(
                    "select id, id_venta, id_celular, cantidad, subtotal from detalle_venta where id=?"
            );
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dv = new Detalle_venta();
                dv.setId(rs.getInt(1)); 

                Venta v = new Venta();
                v.setId(rs.getInt(2));
                dv.setId_venta(v);

                Celular cel = new Celular();
                cel.setId(rs.getInt(3));
                dv.setId_celular(cel);

                dv.setCantidad(rs.getInt(4));
                dv.setSubtotal(rs.getDouble(5));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dv;
    }

    @Override
    public ArrayList<Detalle_venta> listar() {
        ArrayList<Detalle_venta> ventas = new ArrayList<>();

        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select dv.id, p.nombre, v.id, v.fecha, v.total, c.id as id_celular, c.sistema_operativo, c.gama, c.precio, c.stock, m.id as id_modelo, m.nombre_modelo, mc.nombre_marca, dv.cantidad, dv.subtotal from detalle_venta dv inner join venta v on dv.id_venta = v.id inner join cliente cl on v.id_cliente = cl.id inner join persona p on cl.id = p.id inner join celular c on dv.id_celular = c.id inner join modelo m on c.modelo_id = m.id inner join marca mc on m.marca_id = mc.id order by v.fecha desc");
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setNombre(rs.getString(2));

                Venta v = new Venta();
                v.setId(rs.getInt(3));
                v.setFecha(rs.getDate(4).toLocalDate());
                v.setTotal(rs.getDouble(5));
                v.setId_cliente(cl);

                Marca mc = new Marca();
                mc.setNombre_marca(rs.getString(13));

                Modelo m = new Modelo();
                m.setId(rs.getInt(11));
                m.setNombre_modelo(rs.getString(12));
                m.setMarca_id(mc);

                Celular cel = new Celular();
                cel.setId(rs.getInt(6));
                cel.setModelo_id(m);

                String so = rs.getString(7);
                if (so != null) {
                    cel.setSistema_operativo(Celular.sistema_operativo.valueOf(so.trim()));
                }

                String ga = rs.getString(8);
                if (ga != null) {
                    cel.setGama(Celular.gama.valueOf(ga.trim()));
                }

                cel.setPrecio(rs.getDouble(9));
                cel.setStock(rs.getInt(10));

                Detalle_venta dv = new Detalle_venta();
                dv.setId(rs.getInt(1));
                dv.setCantidad(rs.getInt(14));
                dv.setSubtotal(rs.getDouble(15));
                dv.setId_venta(v);
                dv.setId_celular(cel);

                ventas.add(dv);
            }
        } catch (SQLException e) {
        }
        return ventas;
    }

    @Override
    public double calcularSubtotal(int cantidad, double precio) {
        double subtotal = 0;
        subtotal = cantidad * precio;
        return subtotal;
    }

}
