/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author BRANDON
 */
public class Conexion_BD {
    private static String URL = "jdbc:mysql://localhost/alumno";
    private static String Usuario = "root";
    private static String Contraseña = "root";
    
    public static Connection conectar(){
        Connection conexion = null;
        try{
           Class.forName("com.mysql.jdbc.Driver");
           conexion = DriverManager.getConnection(URL,Usuario,Contraseña);
            System.out.println("Conexion establecida");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error:" + e);
        }
        
        
        return conexion;
    }
}
