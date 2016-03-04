/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author MegaKingBR
 */
public class Dados {
    private Statement stmt;
    private Connection conn;

    public Statement conectar() throws ClassNotFoundException, SQLException {
        return this.conectarPostGreSql();
    }

    public void desconectar() throws SQLException {
        conn.close();
    }

    private Statement conectarPostGreSql() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String local = "localhost";
        String banco = "BDConsulta";
        String usuario = "postgres";
        String senha = "unibratec";
        conn = DriverManager.getConnection("jdbc:postgresql://"
                + local + "/" + banco
                + "?charSet=LATIN1", usuario,
                senha);
        //stmt = conn.createStatement();
        return conn.createStatement();
        //return stmt;
    }
    
}
