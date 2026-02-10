/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.Celular;
import MODELO.Marca;
import MODELO.Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Celularimpl implements GestionCelulares {

    Conexion c = new Conexion();

    @Override
    public void guardar(Celular cel) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("insert into celular(modelo_id, sistema_operativo, gama ,precio,stock) values (?,?,?,?,?)");
            ps.setInt(1, cel.getModelo_id().getId());
            ps.setString(2, cel.getSistemaenum());
            ps.setString(3, cel.getGamaenum());
            ps.setDouble(4, cel.getPrecio());
            ps.setInt(5, cel.getStock());
            ps.executeUpdate();
            System.out.println("REGISTRO EXITOSO!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizar(Celular cel, int id) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("update celular set modelo_id=?, sistema_operativo=?, gama=?, precio=?, stock=?  where id=?");
            ps.setInt(1, cel.getModelo_id().getId());
            ps.setString(2, cel.getSistemaenum());
            ps.setString(3, cel.getGamaenum());
            ps.setDouble(4, cel.getPrecio());
            ps.setInt(5, cel.getStock());
            ps.setInt(6, cel.getId()); // 

            ps.executeUpdate();
            System.out.println("ACTUALIZACION EXITOSA!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("delete from celular where id=?");
            ps.setInt(1, id);
            System.out.println("""
                               ¿Desea eliminar el celular?
                               1. Si
                               2. No
                               """);
            int op = new Scanner(System.in).nextInt();
            if (op == 1) {
                ps.executeUpdate();
                System.out.println("ELIMINACION EXITOSA!");
            } else {
                System.out.println("elimininacion cancelada");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Celular buscar(int id) {
        Celular cel = null;
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("select c.id, c.sistema_operativo, c.gama ,c.precio,c.stock,c.modelo_id from celular c where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cel = new Celular();
                cel.setId(rs.getInt(1));
                String sistema = rs.getString(2);
                cel.setSistema_operativo(Celular.sistema_operativo.valueOf(sistema));

                String gama = rs.getString(3); // columna gama
                cel.setGama(Celular.gama.valueOf(gama));

                cel.setPrecio(rs.getDouble(4));
                cel.setStock(rs.getInt(5));

                Modelo m = new Modelo();
                m.setId(rs.getInt(6));
                cel.setModelo_id(m);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cel;
    }

    @Override
    public ArrayList<Celular> listar() {
        ArrayList<Celular> celulares = new ArrayList<>();

        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select c.id, c.sistema_operativo, c.gama, c.precio, c.stock, m.id as modelo_id, m.nombre_modelo, mc.id as marca_id, mc.nombre_marca from celular c inner join modelo m on c.modelo_id = m.id inner join marca mc on m.marca_id = mc.id");
            while (rs.next()) {

                Celular cel = new Celular();
                cel.setId(rs.getInt(1));

                cel.setSistema_operativo(Celular.sistema_operativo.valueOf(rs.getString(2)));
                cel.setGama(Celular.gama.valueOf(rs.getString(3)));

                cel.setPrecio(rs.getDouble(4));
                cel.setStock(rs.getInt(5));

                Modelo m = new Modelo();
                m.setId(rs.getInt(6));
                m.setNombre_modelo(rs.getString(7));

                Marca mc = new Marca();
                mc.setId(rs.getInt(8));
                mc.setNombre_marca(rs.getString(9));

                m.setMarca_id(mc);
                cel.setModelo_id(m);

                celulares.add(cel);
            }

        } catch (SQLException e) {
        }
        return celulares;
    }

    @Override
    public void actualizarStock(int idCelular, int cantidadVendida) {

        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("update celular set stock = stock - ? where id = ?");
            ps.setInt(1, cantidadVendida);
            ps.setInt(2, idCelular);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
