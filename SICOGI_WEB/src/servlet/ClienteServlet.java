package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cliente")
public class ClienteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");

        request.setAttribute("nombre", nombre);
        request.setAttribute("correo", correo);

        request.getRequestDispatcher("clientes.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Listado de Clientes (simulado)</h2>");
        out.println("<p>Cliente 1</p>");
        out.println("<p>Cliente 2</p>");
    }
}
