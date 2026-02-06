/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Clienteimpl implements GestionCliente {

    Conexion c = new Conexion();

    @Override
    public void guardar(Cliente cl) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("insert into cliente(nombre, identificacion, correo ,telefono) values (?,?,?,?)");
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getIdentificacion());
            ps.setString(3, cl.getCorreo());
            ps.setString(4, cl.getTelefono());
            ps.executeUpdate();
            System.out.println("REGISTRO EXITOSO!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizar(Cliente cl) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("update cliente set nombre=?, identificacion=?, correo=?, telefono=? where id=?");
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getIdentificacion());
            ps.setString(3, cl.getCorreo());
            ps.setString(4, cl.getTelefono());
            ps.setInt(5, cl.getId());
            ps.executeUpdate();
            System.out.println("ACTUALIZACION EXITOSA!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cliente> listar() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from cliente");
            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException e) {
        }
        return clientes;

    }
    @Override
    public Cliente buscar(int id) {
        Cliente cl = null;
        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from cliente where id=" + id);
            while (rs.next()) {
                cl = new Cliente();
                cl.setId(rs.getInt(1));
                cl.setNombre(rs.getString(2));
                cl.setIdentificacion(rs.getString(3));
                cl.setCorreo(rs.getString(4));
                cl.setTelefono(rs.getString(5));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cl;
    }


}
