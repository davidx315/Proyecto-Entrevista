<%-- 
    Document   : modificar
    Created on : 3/04/2021, 03:02:22 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns:h="http://java.sun.com/jsf/html" xmlns:f="http://java.sun.com/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empresa</title>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }
            
            h1 {
                width: 400px;
                font-size: 40px;
                margin-bottom: 20px;
                margin: auto;
                font-family: 'calibri';
                color: white;
            }
            
            .formRegitro {
                width: 400px;
                background: #24303c;
                padding: 30px;
                margin: auto;
                margin-top: 30px;
                border-radius: 4px;
                font-family: 'calibri';
                color: white;
                box-shadow: 7px 13px 37px #000;
            }
            .controles {
                width: 100%;
                background: #24303c;
                padding: 10px;
                border-radius: 4px;
                margin-bottom: 16px;
                border: 1px solid #1f53c5;
                font-family: 'calibri';
                font-size: 18px;
                color:white;
            }
            .botonGuardar {
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
            
            .botonGuardar:hover{
                opacity: 0.6;
                text-decoration: none;
                
            } 
        </style>
    </head>
    <body>
           
        <form action="ProductosController?accion=actualizar" method="POST" autocomplete="off" class="formRegitro">
            <h1>Modificar Pedido</h1>
            
            <input class="controles" id="id" name="id"  type="hidden" value="<c:out value="${producto.id}"/>"/>
            
            <p>
                Codigo Pedido:
                <input class="controles" id="codigoPedido" name="codigoPedido" type="text" value="<c:out value="${producto.codigoPedido}"/>"/>
            </p>
            <p>
                Nombre Producto:
                <input class="controles" id="nombreProducto" name="nombreProducto" type="text" value="<c:out value="${producto.nombreProducto}"/>"/>
            </p>
            <p>
                Descripcion Producto:
                <input class="controles" id="descripcionProducto" name="descripcionProducto" type="text" value="<c:out value="${producto.descripcionProducto}"/>"/>
            </p>
            <p>
                Valor Producto:
                <input class="controles" id="valorProducto" name="valorProducto" type="text" value="<c:out value="${producto.valorProducto}"/>"/>
            </p>
            
            <button class="botonGuardar" id="guardar" name="guardar" type="submit">Guardar</button>
            
        </form>
        
    </body>
</html>

