/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ProductosDAO {
    
    Connection conexion;
    
    public ProductosDAO() {
        Conexion con = new Conexion();
        conexion  = con.getConexion();
    }
    
    //Metodo que muestra todos los registros
    
    public List<Productos> listarPedidos(){
        
        PreparedStatement ps;
        ResultSet rs;
        
        List<Productos> lista = new ArrayList<>();
        
        try{
            
            ps = conexion.prepareStatement("SELECT id, codigoPedido, nombreProducto, descripcionProducto, valorProducto FROM producto");
            rs = ps.executeQuery();
            
            while(rs.next()){
                int     id                      = rs.getInt("id");
                String  codigoPedido            = rs.getString("codigoPedido");
                String  nombreProducto          = rs.getString("nombreProducto");
                String  descripcionProducto     = rs.getString("descripcionProducto");
                float     valorProducto           = rs.getFloat("valorProducto");
                
                //Instancia de la clase
                
                Productos producto = new Productos (id, codigoPedido, nombreProducto, descripcionProducto, valorProducto);
                lista.add(producto);
            }
            
            return lista;
            
        }   catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }
    
    //Metodo que muestra un solo registro
    
    public Productos mostrarPedidos(int _id){
        
        PreparedStatement ps;
        ResultSet rs;       
        Productos producto = null;
        
        try{
            
            ps = conexion.prepareStatement("SELECT id, codigoPedido, nombreProducto, descripcionProducto, valorProducto FROM producto  WHERE id=?");
            ps.setInt(1,_id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int     id                      = rs.getInt("id");
                String  codigoPedido            = rs.getString("codigoPedido");
                String  nombreProducto          = rs.getString("nombreProducto");
                String  descripcionProducto     = rs.getString("descripcionProducto");
                float     valorProducto           = rs.getFloat("valorProducto");
                
                //Instancia de la clase
                
                producto = new Productos (id, codigoPedido, nombreProducto, descripcionProducto,valorProducto);
            }
            
            return producto;
            
        }   catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }
    
    //Metodo de Agregar usuario
    
    public boolean ingresarPedido(Productos producto){
        
        PreparedStatement ps;
        
        try{
            
            ps = conexion.prepareStatement("INSERT INTO producto (codigoPedido, nombreProducto, descripcionProducto,valorProducto) "
                                         + "VALUES (?,?,?,?)");
            ps.setString(1, producto.getCodigoPedido());
            ps.setString(2, producto.getNombreProducto());
            ps.setString(3, producto.getDescripcionProducto());
            ps.setFloat (4, producto.getValorProducto());
            ps.execute();                     
            return true;
            
        }   catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    //Metodo de Actualizar Usuario
    
    public boolean actualizarPedido(Productos producto){
        
        PreparedStatement ps;
        
        try{
            
            ps = conexion.prepareStatement("UPDATE producto SET codigoPedido = ?, nombreProducto = ?, descripcionProducto = ?,valorProducto = ?"
                                         + "WHERE id=?");
            ps.setString(1, producto.getCodigoPedido());
            ps.setString(2, producto.getNombreProducto());
            ps.setString(3, producto.getDescripcionProducto());
            ps.setFloat  (4, producto.getValorProducto());
            ps.setInt   (5, producto.getId());
            ps.execute();                     
            return true;
            
        }   catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    //Metodo de Eliminar Usuario
    
    public boolean EliminarPedido(int _id){
        
        PreparedStatement ps;
        
        try{
            
            ps = conexion.prepareStatement("DELETE FROM producto WHERE id=?");
            ps.setInt(1, _id);
            ps.execute();                     
            return true;
            
        }   catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
}
