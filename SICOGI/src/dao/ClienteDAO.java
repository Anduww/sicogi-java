package dao;

import conexion.ConexionBD;
import modelo.Cliente;

import java.sql.*;

public class ClienteDAO {

    public void insertar(Cliente cliente) {
        String sql = "INSERT INTO clientes(nombre, correo) VALUES (?, ?)";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getCorreo());
            ps.executeUpdate();

            System.out.println("Cliente insertado correctamente");

        } catch (Exception e) {
            System.out.println("Error insertar: " + e.getMessage());
        }
    }

    public void consultar() {
        String sql = "SELECT * FROM clientes";

        try (Connection con = ConexionBD.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("nombre") + " | " +
                        rs.getString("correo")
                );
            }

        } catch (Exception e) {
            System.out.println("Error consultar: " + e.getMessage());
        }
    }

    public void actualizar(int id, String nuevoNombre, String nuevoCorreo) {
        String sql = "UPDATE clientes SET nombre=?, correo=? WHERE id=?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nuevoNombre);
            ps.setString(2, nuevoCorreo);
            ps.setInt(3, id);

            ps.executeUpdate();
            System.out.println("Cliente actualizado");

        } catch (Exception e) {
            System.out.println("Error actualizar: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM clientes WHERE id=?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Cliente eliminado");

        } catch (Exception e) {
            System.out.println("Error eliminar: " + e.getMessage());
        }
    }
}
