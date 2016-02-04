/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConecBD;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * 08/01 - Maycon Conexão com o Banco de dados
 */
/**
 *
 * @author Maycon
 */
public class ConexaoBanco {
   
    public static Connection concliente() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:BDSigma.sqlite");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM cliente");
            //cliente e o nome da tabela
            //JOptionPane.showMessageDialog(null, "Conectado"); //Comentar no futuro
            
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro. Código: 00-01-01.", "Conexão banco de dados", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * Juliano
     * Conecta ao banco na abertura da tela de login
    */
    public static Connection login() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:BDSigma.sqlite");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM Login");
            //Banco de senhas
            //JOptionPane.showMessageDialog(null, "Conectado"); Se tudo estiver bem, nem mostra essa janela
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro. Código: 00-01-02.", "Conexão banco de dados", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    /**
     * 06/01/16 - Juliano
     * Conecta ao banco de versão
    */
    public static Connection Version() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:BDSigma.sqlite");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM Version");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro. Código: 00-01-03.", "Conexão banco de dados", JOptionPane.ERROR_MESSAGE);        
        }
        return null;
    } 
    
    /**
     * 04/02 - Maycon 
     * Conexao com financas
     */
    public static Connection confinanca() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:BDSigma.sqlite");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM financa");
            //cliente e o nome da tabela
            //JOptionPane.showMessageDialog(null, "Conectado"); //Comentar no futuro
            System.out.println("Conexao com o banco de dados feita");
            
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro. Código: DEFINIR ERRO!!!!.", "Conexão banco de dados", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
