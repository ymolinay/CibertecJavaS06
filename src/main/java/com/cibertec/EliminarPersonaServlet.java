package com.cibertec;


import com.cibertec.dao.PersonaDao;
import com.cibertec.dao.impl.PersonaDaoImpl;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EliminarPersonaServlet", urlPatterns = "/eliminarPersona")
public class EliminarPersonaServlet extends HttpServlet {
    private final PersonaDao personaDAO = new PersonaDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            personaDAO.eliminarPersona(id);
            response.sendRedirect("personas");
        } catch (SQLException e) {
            throw new ServletException("Error al eliminar persona", e);
        }
    }
}