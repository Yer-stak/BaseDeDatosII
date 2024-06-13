/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author BRANDON
 */
public class Metodos_SQL {

    private static Connection conexion;
    private static PreparedStatement sentencia_preparada;
    private static ResultSet resultado;

    public void guardar_datos_profesor(int id, int numeroEmpleado, String nombre, String apellidoP, String apellidoM, String curp, String email, String gradoEstudio, String rfc, String materias, String carrera) {
        try {
            conexion = Conexion_BD.conectar();
            String consulta = "INSERT INTO profesor(id,numero_empleado,nombre,apellido_p,apellido_m,curp,email,grado_estudio,rfc,materias,carrera) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            sentencia_preparada = conexion.prepareStatement(consulta);
            sentencia_preparada.setInt(1, id);
            sentencia_preparada.setInt(2, numeroEmpleado);
            sentencia_preparada.setString(3, nombre);
            sentencia_preparada.setString(4, apellidoP);
            sentencia_preparada.setString(5, apellidoM);
            sentencia_preparada.setString(6, curp);
            sentencia_preparada.setString(7, email);
            sentencia_preparada.setString(8, gradoEstudio);
            sentencia_preparada.setString(9, rfc);
            sentencia_preparada.setString(10, materias);
            sentencia_preparada.setString(11, carrera);
            int i = sentencia_preparada.executeUpdate();

            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Datos Guardados");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println("Erorr:" + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }

        }

    }

    public void guardar_datos_carrera(int id, String nombreCarrera, String clave) {
        try {
            conexion = Conexion_BD.conectar();
            String consulta = "INSERT INTO profesor(id,nombre_carrera,clave) VALUES (?,?,?)";
            sentencia_preparada = conexion.prepareStatement(consulta);
            sentencia_preparada.setInt(1, id);
            sentencia_preparada.setString(2, nombreCarrera);
            sentencia_preparada.setString(3, clave);
            int i = sentencia_preparada.executeUpdate();

            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Datos Guardados");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println("Erorr:" + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }

        }

    }

    public static String buscarCurp(String curp) {
        String mensaje = null;
        try {
            conexion = Conexion_BD.conectar();
            String consulta = "SELECT FROM profesor WHERE curp = ?";
            sentencia_preparada = conexion.prepareStatement(consulta);
            sentencia_preparada.setString(6, curp);
            resultado = sentencia_preparada.executeQuery();

            if (resultado.next()) {
                mensaje = "Existe Curp";

            } else {
                mensaje = "No existe este Curp";
            }

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();

            } catch (SQLException ex) {
                Logger.getLogger(Metodos_SQL.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return mensaje;
    }

    public static String buscarClave(String clave) {
        String mensaje = null;
        try {
            conexion = Conexion_BD.conectar();
            String consulta = "SELECT FROM carrera WHERE clave = ?";
            sentencia_preparada = conexion.prepareStatement(consulta);
            sentencia_preparada.setString(3, clave);
            resultado = sentencia_preparada.executeQuery();

            if (resultado.next()) {
                mensaje = "Existe Clave";

            } else {
                mensaje = "No existe este Clave";
            }

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();

            } catch (SQLException ex) {
                Logger.getLogger(Metodos_SQL.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return mensaje;

    }

    public void modificar_datos_profesor(int id, int numeroEmpleado, String nombre, String apellidoP, String apellidoM, String curp, String email, String gradoEstudio, String rfc, String materias, String carrera) {
        try {
            conexion = Conexion_BD.conectar();
            String consulta = "UPDATE profesor SET id = ?,numero_empleado = ?,nombre = ?,apellido_p = ?,apellido_m = ?,curp = ?,email = ?,grado_estudio = ?,rfc = ?,materias = ?,carrera = ?    WHERE curp = ?";
            sentencia_preparada = conexion.prepareStatement(consulta);
            sentencia_preparada.setInt(1, id);
            sentencia_preparada.setInt(2, numeroEmpleado);
            sentencia_preparada.setString(3, nombre);
            sentencia_preparada.setString(4, apellidoP);
            sentencia_preparada.setString(5, apellidoM);
            sentencia_preparada.setString(6, curp);
            sentencia_preparada.setString(7, email);
            sentencia_preparada.setString(8, gradoEstudio);
            sentencia_preparada.setString(9, rfc);
            sentencia_preparada.setString(10, materias);
            sentencia_preparada.setString(11, carrera);
            int i = sentencia_preparada.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Datos modificados");
            } else {
                JOptionPane.showMessageDialog(null, "Datos no modificados");
            }
            conexion.close();
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }
    }
    
    public void modificar_datos_carrera(int id, String nombreCarrera, String clave) {
        try {
            conexion = Conexion_BD.conectar();
            String consulta = "UPDATE carrera SET id = ?,nombre_carrera = ?,clave = ? WHERE clave = ?";
            sentencia_preparada = conexion.prepareStatement(consulta);
            sentencia_preparada.setInt(1, id);
            sentencia_preparada.setString(2, nombreCarrera);
            sentencia_preparada.setString(3, clave);
            
            int i = sentencia_preparada.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Datos modificados");
            } else {
                JOptionPane.showMessageDialog(null, "Datos no modificados");
            }
            conexion.close();
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }
    }
    

    public void eliminarProfesor(String curp) {
        try {
            conexion = Conexion_BD.conectar();
            String consulta_eliminacion = "DELETE FROM carrera WHERE clave = ?";
            sentencia_preparada = conexion.prepareStatement(consulta_eliminacion);
            sentencia_preparada.setString(6, curp);
            sentencia_preparada.executeUpdate();
            int resultado_fila_afectada = sentencia_preparada.executeUpdate();
            if (resultado_fila_afectada > 0) {
                JOptionPane.showMessageDialog(null, "Profesor eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el profesor");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                conexion.close();

            } catch (SQLException ex) {
                Logger.getLogger(Metodos_SQL.class
                        .getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error: " + ex);
            }
        }
    }

}
