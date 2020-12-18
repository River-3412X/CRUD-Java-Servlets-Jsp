package ModelsDao;

import Config.Conexion;
import Interfaces.Crud;
import Models.Users;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsersDao implements Crud{
    Conexion con ;
    Connection connection;
    PreparedStatement pstatement;
    ResultSet result;
    
    public UsersDao(){
        this.con = new Conexion();
    }

    @Override
    public List<Users> show_all()throws Exception{
        ArrayList<Users> lista = new ArrayList<Users>();
        Calendar cal= Calendar.getInstance(TimeZone.getDefault());
        try {
            con.conectar();
            connection =con.getConnection();
            pstatement=connection.prepareStatement("select *from users");
            result= pstatement.executeQuery();
            while(result.next()){
                Users usuario = new Users();
                usuario.setId(result.getInt("id"));
                usuario.setNombre(result.getString("nombre"));
                usuario.setApellidos(result.getString("apellidos"));
                usuario.setEdad(result.getInt("edad"));
                
                usuario.setFecha_registro(result.getTimestamp("fecha_registro",cal));
                lista.add(usuario);
            }
        } catch (Exception ex) {
            throw ex;
        }finally{
            try{
                con.desconectar();
            }catch(Exception e){
                throw e;
            }
        }
        return lista;
    }

    @Override
    public Users show(int id)throws Exception{
        Users usuario = new Users();
        try {
            con.conectar();
            connection =con.getConnection();
            pstatement=connection.prepareStatement("select *from users where id=?");
            pstatement.setInt(1, id);
            result= pstatement.executeQuery();
            while(result.next()){
                usuario.setId(result.getInt("id"));
                usuario.setNombre(result.getString("nombre"));
                usuario.setApellidos(result.getString("apellidos"));
                usuario.setEdad(result.getInt("edad"));
                usuario.setFecha_registro(result.getDate("fecha_registro"));
            }
        } catch (Exception ex) {
            throw ex;
        }finally{
            try{
                con.desconectar();
            }catch(Exception e){
                throw e;
            }
        }
        return usuario;
    }

    @Override
    public int storage(Users usuario)throws Exception{
        try {
            con.conectar();
            connection =con.getConnection();
            pstatement=connection.prepareStatement("insert into users(nombre,apellidos,edad,fecha_registro)values(?,?,?,?)");
            pstatement.setString(1, usuario.getNombre());
            pstatement.setString(2, usuario.getApellidos());
            pstatement.setInt(3, usuario.getEdad());
            Date f= usuario.getFecha_registro();
            pstatement.setString(4, (f.getYear()+1900)+"-"+(f.getMonth()+1)+"-"+f.getDate()+" "+f.getHours()+":"+f.getMinutes()+":"+f.getSeconds());
            
            return pstatement.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        }finally{
            try{
                con.desconectar();
            }catch(Exception e){
                throw e;
            }
        }
    }

    @Override
    public int update(Users usuario)throws Exception {
        try {
            con.conectar();
            connection =con.getConnection();
            pstatement=connection.prepareStatement("update users set nombre=?,apellidos=?,edad=? where id=?");
            pstatement.setString(1, usuario.getNombre());
            pstatement.setString(2, usuario.getApellidos());
            pstatement.setInt(3, usuario.getEdad());
            pstatement.setInt(4,usuario.getId());
            return pstatement.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        }finally{
            try{
                con.desconectar();
            }catch(Exception e){
                throw e;
            }
        }
    }

    @Override
    public int eliminar(int id)throws Exception {
        try {
            con.conectar();
            connection =con.getConnection();
            pstatement=connection.prepareStatement("delete from users where id=?");
            pstatement.setInt(1,id);
            
            return pstatement.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        }finally{
            try{
                con.desconectar();
            }catch(Exception e){
                throw e;
            }
        }
    }
    
}
