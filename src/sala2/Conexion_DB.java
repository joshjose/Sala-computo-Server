/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sala2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;
/**
 *
 * @author josue
 */
public class Conexion_DB {
    
    private static Connection conn = null;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3307/sala_computo";
    Properties p = new Properties();
    
    
     public Conexion_DB(){
        p.put("user", "root");
        p.put("password", "");
        conn = null;
        try{
            Class.forName(driver);
            try {
                conn = DriverManager.getConnection(url,p);
                if(conn != null){
                    System.out.println("Conexion establecida " );
                }
            } catch(SQLException e) {
                System.out.println("Error al conectar " + e.getMessage());
                
            }
            
        }catch (ClassNotFoundException e){
            System.out.println("Conexion no establecida" + e);
        }
        
    }
   public Connection getConnection(){
       return conn;
   }
   public void Desconectar(){
       conn = null;
       if(conn == null){
           System.out.println("Conexion terminada");
       }
   }
    
}

    

