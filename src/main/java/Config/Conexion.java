package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection connection;
    private String usuario;
    private String password;
    private String database;
    private String host;

    public void conectar()throws Exception{
        this.usuario ="root";
        this.password="";
        this.database="usuarios";
        this.host="localhost";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection=DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.database+"?serverTimezone=UTC",this.usuario,this.password);
            
        }catch(Exception ex){
            throw ex;
        }
    }
    public void desconectar() throws SQLException{
        if(connection!=null){
            if(!connection.isClosed()){
                connection.close();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
    
}
