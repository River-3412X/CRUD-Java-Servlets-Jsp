package Models;

import java.util.Date;

public class Users {
    private int id;
    private String nombre;
    private String apellidos;
    private int edad;
    private Date fecha_registro;

    public Users() {
    }

    public Users(String nombre, String apellidos, int edad, Date fecha_registro) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.fecha_registro = fecha_registro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    
}
