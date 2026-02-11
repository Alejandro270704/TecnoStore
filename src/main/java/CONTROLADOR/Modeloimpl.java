/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.Marca;
import MODELO.Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Modeloimpl implements GestionarModelo {

    

    @Override
    public void registrar(Modelo m) {
        try (Connection con = Conexion.getconexion().conectar()) {
            PreparedStatement ps = con.prepareStatement("insert into modelo(nombre_modelo,marca_id) values (?,?)");
            ps.setString(1, m.getNombre_modelo());
            ps.setInt(2, m.getMarca_id().getId());
            ps.executeUpdate();
            System.out.println("REGISTRO EXITOSO!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizar(Modelo m) {
        try (Connection con = Conexion.getconexion().conectar()) {
            PreparedStatement ps = con.prepareStatement("update modelo set nombre_modelo=? ,marca_id=? where id=?");
            ps.setString(1, m.getNombre_modelo());
            ps.setInt(2, m.getMarca_id().getId());
            ps.setInt(3, m.getId());

            ps.executeUpdate();
            System.out.println("ACTUALIZACION EXITOSA!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Modelo buscar(int id) {
        Modelo m = null;
        try (Connection con = Conexion.getconexion().conectar()) {
            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement("select m.id, m.nombre_modelo, m.marca_id from modelo m where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                m = new Modelo();
                m.setId(rs.getInt(1));
                m.setNombre_modelo(rs.getString(2));
                Marca mc = new Marca();
                mc.setId(rs.getInt(3));
                m.setMarca_id(mc);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return m;
    }

    @Override
    public void eliminar(int id) {
        try (Connection con = Conexion.getconexion().conectar()) {
            PreparedStatement ps = con.prepareStatement("delete from modelo where id=?");
            ps.setInt(1, id);
            System.out.println("""
                               ¿Desea eliminar el cliente?
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
    public ArrayList<Modelo> listar() {
        ArrayList<Modelo> modelos = new ArrayList<>();

        try (Connection con = Conexion.getconexion().conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select m.id, m.nombre_modelo, mc.id, mc.nombre_marca FROM modelo m inner join marca mc on m.marca_id  = mc.id ");
            while (rs.next()) {

                Marca mc = new Marca();
                mc.setId(rs.getInt(3));
                mc.setNombre_marca(rs.getString(4));
                Modelo m = new Modelo();
                m.setId(rs.getInt(1));
                m.setNombre_modelo(rs.getString(2));
                m.setMarca_id(mc);
                modelos.add(m);
            }

        } catch (SQLException e) {
        }
        return modelos;
    }

}
