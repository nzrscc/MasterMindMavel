package it.mastermind.models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Dao {

    private static Dao instance;

    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String serverName;
    private String databaseName;
    private String username;
    private String password;
    private FileInputStream fin;
    private Properties p;
    private String url;
    private Connection connection;
    private Statement stmt;

    private Dao(){
        this.ConnessioneDb();
    }

    public static Dao newIstance()
    {
        if(instance==null)
        {
            instance = new Dao();
        }
        return instance;
    }

    public void ConnessioneDb() {
        try {
            this.fin=new FileInputStream("src/main/java/it/mastermind/models/db.properties");
            this.p = new Properties();
            this.p.load(fin);
            this.serverName=p.getProperty("sN");
            this.databaseName=p.getProperty("dN");
            this.username=p.getProperty("uN");
            this.password=p.getProperty("uP");
            this.url = "jdbc:mysql://" + this.serverName + "/" + this.databaseName + "?user=" + this.username + "?password=" + this.password;
            Class.forName(this.driverName);
            System.out.println("Connessione al database selezionato ...");
            this.connection = DriverManager.getConnection(this.url, this.username, this.password);
            System.out.println("Connessione effettuata!");
            this.stmt = this.connection.createStatement();
            this.stmt.executeUpdate("CREATE TABLE IF NOT EXISTS COMBINATION (ID INTEGER PRIMARY KEY AUTO_INCREMENT," +
                    " User VARCHAR(20), Soluzione VARCHAR(20), Data_Operazione VARCHAR(30))");
            System.out.println("Accesso alla tabella!");

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public Connection getConnection(){
        return this.connection;
    }

    public void popolaTabella(String sql)
    {
        try
        {
            this.stmt.executeUpdate(sql);
            System.out.print("Registrazione effettuata!");
        }catch(SQLException se)
        {
            se.printStackTrace();
        }
    }


}
