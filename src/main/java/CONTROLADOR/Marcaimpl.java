/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Marcaimpl implements GestionarMarca {

    Conexion c = new Conexion();

    @Override
    public void registrar(Marca m) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("insert into marca(nombre_marca) values (?)");
            ps.setString(1, m.getNombre_marca());
            ps.executeUpdate();
            System.out.println("REGISTRO EXITOSO!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizar(Marca m) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("update marca set nombre_marca=? where id=?");
            ps.setString(1, m.getNombre_marca());
            ps.setInt(2, m.getId());
            ps.executeUpdate();
            System.out.println("ACTUALIZACION EXITOSA!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Marca buscar(int id) {
        Marca m = null;
        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement("select m.id,m.nombre_marca from marca m where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                m = new Marca();
                m.setId(rs.getInt("id"));
                m.setNombre_marca(rs.getString("nombre_marca"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return m;
    }

    @Override
    public void eliminar(int id) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("delete from marca where id=?");
            ps.setInt(1, id);
            System.out.println("""
                               ¿Desea eliminar la marca?
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
    public ArrayList<Marca> listar() {
        ArrayList<Marca> marcas = new ArrayList<>();

        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from marca ");
            while (rs.next()) {
                marcas.add(new Marca(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
        } catch (SQLException e) {
        }
        return marcas;
    }

}
