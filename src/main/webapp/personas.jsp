<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de Personas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">Personas Registradas</h1>
    <a href="registroPersona.jsp" class="btn btn-primary mb-3">Registrar Nueva Persona</a>
    <table class="table table-hover table-bordered">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Edad</th>
            <th>Correo</th>
            <th>Teléfono</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="persona" items="${personas}">
            <tr>
                <td>${persona.id}</td>
                <td>${persona.nombre}</td>
                <td>${persona.apellido}</td>
                <td>${persona.edad}</td>
                <td>${persona.correo}</td>
                <td>${persona.telefono}</td>
                <td>
                    <a href="editarPersona?id=${persona.id}" class="btn btn-warning btn-sm">Editar</a>
                    <a href="eliminarPersona?id=${persona.id}" class="btn btn-danger btn-sm"
                       onclick="return confirm('¿Estás seguro de eliminar esta persona?');">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>