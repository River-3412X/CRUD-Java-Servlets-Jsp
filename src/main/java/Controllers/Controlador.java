package Controllers;

import Models.Users;
import ModelsDao.UsersDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String metodo="";
        
        if(request.getParameter("metodo")!=null){
            metodo = request.getParameter("metodo");    
        }
        
        if (metodo.equalsIgnoreCase("registrar")){
            RequestDispatcher vista = request.getRequestDispatcher("Views/registrar.jsp");
            vista.forward(request, response);
        } else {
            if (metodo.equalsIgnoreCase("editar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                UsersDao usr = new UsersDao();
                try {
                    Users usuario = usr.show(id);
                    request.setAttribute("usuario", usuario);
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                RequestDispatcher vista = request.getRequestDispatcher("Views/editar.jsp");
                vista.forward(request, response);
            }
            else{
                ArrayList<Users> lista;
                lista = mostrar();
                request.setAttribute("lista", lista);
                RequestDispatcher vista = request.getRequestDispatcher("Views/tabla.jsp");
                vista.forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String btn = request.getParameter("btn");
        if (btn.equalsIgnoreCase("registrar")) {
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            int edad =Integer.parseInt(request.getParameter("edad"));
            Date fecha = new Date();
            Users usuario = new Users(nombre, apellidos, edad, fecha);
            UsersDao usr = new UsersDao();
            try {
                if(usr.storage(usuario)==1){
                    response.getWriter().write("Se registro correctamente el usuario");
                }
                else{
                    response.getWriter().write("No registro correctamente el usuario");
                }
            } catch (Exception ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            if (btn.equalsIgnoreCase("modificar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("nombre");
                String apellidos = request.getParameter("apellidos");
                int edad = Integer.parseInt(request.getParameter("edad"));
                Users usuario = new Users();
                usuario.setId(id);
                usuario.setNombre(nombre);
                usuario.setApellidos(apellidos);
                usuario.setEdad(edad);
                UsersDao usr = new UsersDao();
                try {
                    if (usr.update(usuario) == 1) {
                         response.getWriter().write("Se modificó usuario correctamente");
                    } else {
                        response.getWriter().write("no se modificó usuario");
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                if (btn.equalsIgnoreCase("eliminar")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    UsersDao usr = new UsersDao();
                    try {
                        if(usr.eliminar(id)==1){
                            response.getWriter().write("Se eliminó usuario Correctamente");
                        }
                        else{
                            response.getWriter().write("No se eliminó usuario");
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public ArrayList<Users> mostrar() {
        ArrayList<Users> lista = new ArrayList<Users>();
        UsersDao usuario = new UsersDao();
        try {
            lista = (ArrayList<Users>) usuario.show_all();
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hay un error"+ex);
        }
        return lista;
    }
}
