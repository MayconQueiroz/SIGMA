/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tolteco.sigma.model.dao.jdbc;

import java.sql.Connection;

/**
 *
 * @author Juliano Felipe da Silva
 */
public class JDBCAbstractDAO {
    protected Connection connection;
    
    public JDBCAbstractDAO() {
        connection = ConnectionFactory.getConnection();
    }
}
