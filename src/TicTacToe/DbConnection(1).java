/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

class DbConnection1 {

    public Connection connect1;
    public Connection connect2;
    public Statement createDB;
    public Statement createTable;

    static final String user = "root"; //insert your sql user name
    static final String password = "";//insert your sql user passward
    static final String dbName = "TicTacToe";
    static final String path = "jdbc:mysql://localhost/";
    static final String dbPath = path + dbName;

    public DbConnection1() {

        try {

            connect1 = DriverManager.getConnection(path, user, password);
            createDB = connect1.createStatement();
            createDB.execute("CREATE DATABASE IF NOT EXISTS " + dbName);

        } catch (SQLException ex) {
            System.out.println("No connection with MySql");
            Logger.getLogger(DbFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                createDB.close();
                connect1.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Connection getConnection() {

        try {

           // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connect2 = DriverManager.getConnection(dbPath, user, password);

            try {
                createTable = connect2.createStatement();
                createTable.execute("create table IF NOT EXISTS player(id int(100) auto_increment,name char(21) not null, score int(100) ,primary key(id) )");
                createTable.execute("create table IF NOT EXISTS game(player1 int ,player2name char(21)  ,gdate datetime, p1 char(20),  p2 char(20), p3 char(20), p4 char(20), p5 char(20), p6 char(20), p7 char(20), p8 char(20),p9 char(20),foreign key(player1) references player(id),primary key(player1,gdate))");

            } catch (SQLException ex) {

                Logger.getLogger(DbFunctions.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    createTable.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DbFunctions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException ex) {
            System.out.println("No connection with MySql");
            Logger.getLogger(DbFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return connect2;
        }
    }

    public void closeConnection() {
        try {
            connect2.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
