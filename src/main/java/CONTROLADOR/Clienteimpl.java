/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Clienteimpl implements GestionCliente {

    Conexion c = new Conexion();

    @Override
    public void guardar(Persona p) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("insert into persona(nombre, identificacion, correo ,telefono) values (?,?,?,?)");
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getIdentificacion());
            ps.setString(3, p.getCorreo());
            ps.setString(4, p.getTelefono());
            ps.executeUpdate();
            System.out.println("REGISTRO EXITOSO!");
            PreparedStatement ps2 = con.prepareStatement("select id from persona where identificacion = ?");
            ps2.setString(1, p.getIdentificacion());

            ResultSet rs = ps2.executeQuery();
            int idPersona = 0;
            if (rs.next()) {
                idPersona = rs.getInt("id");
            }
            PreparedStatement psCliente = con.prepareStatement(
                    "insert into cliente(id) values (?)"
            );
            psCliente.setInt(1, idPersona);
            psCliente.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizar(Persona p) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("update persona set nombre=?, identificacion=?, correo=?, telefono=? where id=?");
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getIdentificacion());
            ps.setString(3, p.getCorreo());
            ps.setString(4, p.getTelefono());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
            System.out.println("ACTUALIZACION EXITOSA!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void eliminar(int id) {
        try (Connection con = c.conectar()) {
            PreparedStatement ps = con.prepareStatement("delete from cliente where id=?");
            ps.setInt(1, id);
            PreparedStatement ps2 = con.prepareStatement("delete from persona where id=?");
            ps2.setInt(1, id);
            System.out.println("""
                               ¿Desea eliminar el cliente?
                               1. Si
                               2. No
                               """);
            int op = new Scanner(System.in).nextInt();
            if (op == 1) {
                ps.executeUpdate();
                ps2.executeUpdate();

                System.out.println("ELIMINACION EXITOSA!");
            } else {
                System.out.println("elimininacion cancelada");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Persona> listar() {
        ArrayList<Persona> personas = new ArrayList<>();

        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select p.id,p.nombre,p.identificacion,p.correo,p.telefono from persona p inner join cliente c on p.id=c.id ");
            while (rs.next()) {
                personas.add(new Persona(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
            }
        } catch (SQLException e) {
        }
        if (personas.isEmpty()) {
            System.out.println("no hay clientes registrados");
        }
        return personas;

    }

    @Override
    public Persona buscar(int id) {
        Persona p = null;
        try (Connection con = c.conectar()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select p.id, p.nombre, p.identificacion, p.correo, p.telefono from cliente c left join persona p on p.id=c.id where c.id=" + id);
            while (rs.next()) {
                p = new Persona();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setIdentificacion(rs.getString(3));
                p.setCorreo(rs.getString(4));
                p.setTelefono(rs.getString(5));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return p;
    }

}
