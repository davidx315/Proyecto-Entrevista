package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Productos;
import modelo.ProductosDAO;

@WebServlet(name = "ProductosController", urlPatterns = {"/ProductosController"})
public class ProductosController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProductosDAO ProductosDAO = new ProductosDAO();
        String accion;
        RequestDispatcher dispatcher = null;
        
        accion = request.getParameter("accion");
        
        if(accion == null || accion.isEmpty()){
           dispatcher = request.getRequestDispatcher("Pedidos/index.jsp");
           List<Productos> listadoProductos = ProductosDAO.listarPedidos();
           request.setAttribute("lista", listadoProductos);
           
        }
        
        // Insertar Usuario
        
        else if("nuevoProducto".equals(accion)){
            dispatcher = request.getRequestDispatcher("Pedidos/nuevoProducto.jsp");
            
        }else if("insertar".equals(accion)){
            String codigoPedido = request.getParameter("codigoPedido");
            String nombreProducto = request.getParameter("nombreProducto");
            String descripcionProducto = request.getParameter("descripcionProducto");
            float    valorProducto = Float.parseFloat(request.getParameter("valorProducto"));
            
            Productos producto = new Productos(0, codigoPedido, nombreProducto, descripcionProducto, valorProducto);
            
            ProductosDAO.ingresarPedido(producto);            
            dispatcher = request.getRequestDispatcher("Pedidos/index.jsp");
            List<Productos> listadoProductos = ProductosDAO.listarPedidos();
            request.setAttribute("lista", listadoProductos);
            
        }
        
        // Modificar Usuario
        
        else if("modificarPedido".equals(accion)){
            dispatcher = request.getRequestDispatcher("Pedidos/modificarPedido.jsp");
            int    id = Integer.parseInt(request.getParameter("id"));
            Productos producto = ProductosDAO.mostrarPedidos(id);
            request.setAttribute("producto", producto);
            
        }else if("actualizar".equals(accion)){
            int    id = Integer.parseInt(request.getParameter("id"));           
            String codigoPedido = request.getParameter("codigoPedido");
            String nombreProducto = request.getParameter("nombreProducto");
            String descripcionProducto = request.getParameter("descripcionProducto");
            float    valorProducto = Float.parseFloat(request.getParameter("valorProducto"));
            
            Productos producto = new Productos(id, codigoPedido, nombreProducto, descripcionProducto, valorProducto);
            
            ProductosDAO.actualizarPedido(producto);            
            dispatcher = request.getRequestDispatcher("Pedidos/index.jsp");
            List<Productos> listadoProductos = ProductosDAO.listarPedidos();
            request.setAttribute("lista", listadoProductos);
            
        }
        
        // Eliminar Usuario
        
        else if("eliminar".equals(accion)){
            int    id = Integer.parseInt(request.getParameter("id"));                       
            ProductosDAO.EliminarPedido(id);            
            dispatcher = request.getRequestDispatcher("Pedidos/index.jsp");
            List<Productos> listadoProductos = ProductosDAO.listarPedidos();
            request.setAttribute("lista", listadoProductos);
            
        } 
        
        // Si no encuentra nin gun metodo vuelve a el Inicio
        
        else {
           dispatcher = request.getRequestDispatcher("Pedidos/index.jsp");
           List<Productos> listadoProductos = ProductosDAO.listarPedidos();
           request.setAttribute("lista", listadoProductos); 
        }
        
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
