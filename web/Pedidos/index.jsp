<%-- 
    Document   : index
    Created on : 3/04/2021, 03:01:43 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empresa</title>
        
        <style>
            h1{

                font-size: 40px;
                margin-bottom: 20px;
                font-family: 'calibri';
                color: black;
            }
            .boton_1{
                text-decoration: none;
                width: 100%;
                background: #1f53c5;
                border: none;
                padding: 12px;
                color: white;
                margin: 16px 0;
                font-size: 16px;
                border-radius: 4px;
                cursor:pointer;
            }

            .boton_1:hover{
                opacity: 0.6;
                text-decoration: none;
            }

            .tabla_1{
                width: 70%; 
                border: 1px solid #000;
            }
            th, td {
                width: 25%;
                text-align: left;
                vertical-align: top;
                border: 1px solid #000;
                border-collapse: collapse;
                padding: 0.3em;
                caption-side: bottom;
            }
            caption {
                padding: 0.3em;
                color: #fff;
                background: #000;
            }
            th {
                background: #eee;
            }

            .botonEditar {
                text-decoration: none;
                width: 100%;
                background: #1f53c5;
                border: none;
                padding: 3px;
                color: white;
                margin: 16px 0;
                font-size: 16px;
                border-radius: 4px;
                cursor:pointer;
            }

            .botonBorrar {
                text-decoration: none;
                width: 100%;
                background: red;
                border: none;
                padding: 3px;
                color: white;
                margin: 16px 0;
                font-size: 16px;
                border-radius: 4px;
                cursor:pointer;
            }
        </style>
    </head>
    <body>
        <h1>Almacen de Productos</h1>

        <a href="ProductosController?accion=nuevoProducto" class="boton_1">Nuevo Registro</a>

        <br/><br/>

        <table border="1" width="80%" class="tabla_1">
            <thead>
                <tr>
                    <th>Codigo Producto</th>
                    <th>Nombre Producto</th>
                    <th>Descripcion del Producto</th>
                    <th>Valor del Producto</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="producto" items="${lista}">
                    <tr>
                        <td><c:out value="${producto.codigoPedido}"/> </td>
                        <td><c:out value="${producto.nombreProducto}"/> </td>
                        <td><c:out value="${producto.descripcionProducto}"/> </td>
                        <td><c:out value="${producto.valorProducto}"/> </td>
                        <td><a class="botonEditar" href="ProductosController?accion=modificarPedido&id=<c:out value="${producto.id}"/>"class="btn btn-primary">Modificar</a></td>
                        <td><a class="botonBorrar" href="ProductosController?accion=eliminar&id=<c:out value="${producto.id}"/>" class="btn btn-primary">Borrar</a></td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

    </body>
</html>
