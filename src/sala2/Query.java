/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sala2;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author josue
 */
public class Query {
    
    public boolean execute(String query) {
        try {
            Conexion_DB con = new Conexion_DB();
            Statement st = con.getConnection().createStatement();
            st.execute(query);
            con.getConnection().close();
            con = null;
            return true;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    public ResultSet executeQuery(String query, Conexion_DB con) {
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.err.println("Error executeQuery: " + e.getMessage());
            return null;
        }
    }
    
}
