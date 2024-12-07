package com.cibertec.dao;

import com.cibertec.models.Persona;
import java.sql.SQLException;
import java.util.List;

public interface PersonaDao {
    List<Persona> listarPersonas() throws SQLException;
    Persona obtenerPersona(int id) throws SQLException;
    void registrarPersona(Persona persona) throws SQLException;
    void editarPersona(Persona persona) throws SQLException;
    void eliminarPersona(int id) throws SQLException;
}