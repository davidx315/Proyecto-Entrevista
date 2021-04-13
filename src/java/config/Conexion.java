/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class Conexion {
    
    private static final String url = "jdbc:mysql://localhost:3306/almacen?serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "1234";
    
    
    private static Connection conexion;
     
    public static  Connection getConexion() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion establecida");
        }catch (SQLException e){
            System.out.println(e.toString());
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return(conexion);
    } 
    
}
