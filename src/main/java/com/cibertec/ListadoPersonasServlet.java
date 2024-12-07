package com.cibertec;

import com.cibertec.dao.PersonaDao;
import com.cibertec.dao.impl.PersonaDaoImpl;
import com.cibertec.models.Persona;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ListadoPersonasServlet", urlPatterns = "/personas")
public class ListadoPersonasServlet extends HttpServlet {
    private final PersonaDao personaDAO = new PersonaDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Persona> personas = personaDAO.listarPersonas();
            request.setAttribute("personas", personas);
            request.getRequestDispatcher("personas.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error al listar personas", e);
        }
    }
}