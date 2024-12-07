package com.cibertec;

import com.cibertec.dao.PersonaDao;
import com.cibertec.dao.impl.PersonaDaoImpl;
import com.cibertec.models.Persona;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditarPersonaServlet", urlPatterns = "/editarPersona")
public class EditarPersonaServlet extends HttpServlet {
    private final PersonaDao personaDAO = new PersonaDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Persona persona = personaDAO.obtenerPersona(id);
            if (persona != null) {
                request.setAttribute("persona", persona);
                request.getRequestDispatcher("editarPersona.jsp").forward(request, response);
            } else {
                response.sendRedirect("personas");
            }
        } catch (SQLException e) {
            throw new ServletException("Error al cargar persona", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");

        try {
            Persona persona = new Persona(id, nombre, apellido, edad, correo, telefono);
            personaDAO.editarPersona(persona);
            response.sendRedirect("personas");
        } catch (SQLException e) {
            throw new ServletException("Error al editar persona", e);
        }
    }
}