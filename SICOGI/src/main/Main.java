package main;

import dao.ClienteDAO;
import modelo.Cliente;

public class Main {

    public static void main(String[] args) {

        ClienteDAO dao = new ClienteDAO();

        Cliente cliente1 = new Cliente(0, "Carlos Perez", "carlos@gmail.com");

        dao.insertar(cliente1);
        dao.consultar();
        dao.actualizar(1, "Carlos Actualizado", "nuevo@gmail.com");
        dao.eliminar(1);
    }
}
