package com.cibertec;

import com.cibertec.dao.PersonaDao;
import com.cibertec.dao.impl.PersonaDaoImpl;
import com.cibertec.models.Persona;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegistrarPersonaServlet", urlPatterns = "/registrarPersona")
public class RegistrarPersonaServlet extends HttpServlet {
    private final PersonaDao personaDAO = new PersonaDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");

        try {
            Persona persona = new Persona(nombre, apellido, edad, correo, telefono);
            personaDAO.registrarPersona(persona);
            response.sendRedirect("personas");
        } catch (SQLException e) {
            throw new ServletException("Error al registrar persona", e);
        }
    }
}