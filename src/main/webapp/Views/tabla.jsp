<%@page import="Models.Users"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Usuarios</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script type="text/javascript" src="Views/js/eliminar.js"></script>
    </head>
    <body>
        <div class="container">
            <%
               try{
                   if(request.getAttribute("success")!=null){
                        out.println("<div class='alert alert-success p-1'>"+request.getAttribute("success")+"</div>");
                    }
                    else{
                        if(request.getAttribute("danger")!=null){
                             out.println("<div class='alert alert-danger p-1'>"+request.getAttribute("danger")+"</div>");
                         }
                    }
               }catch(NullPointerException ex){
                   out.println("hay un error en esta madre: "+ex);
               }
            %>
            <h1 class="text-center">Usuarios Registrados</h1>
            <a href="Controlador?metodo=registrar" class="btn btn-success">Registrar Nuevo Usuario</a>
            <table class="table table-stripped table-responsive-sm table-hover text-center table-sm" >
                <thead >
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Edad</th>
                        <th>Fecha de Registro</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Users> lista=(ArrayList<Users>) request.getAttribute("lista");
                    if(lista.size()==0){
                        out.println("<div class='alert alert-danger p-1'>No hay registros de usuarios</div>");    
                    }
                    else{
                        for (Users usuario :lista) {
                         out.println("<tr>");   
                         out.println("<td>"+usuario.getId()+"</td>");   
                         out.println("<td>"+usuario.getNombre()+"</td>");   
                         out.println("<td>"+usuario.getApellidos()+"</td>");   
                         out.println("<td>"+usuario.getEdad()+"</td>");   
                         out.println("<td>"+usuario.getFecha_registro()+"</td>");
                         
                         
                         out.println("<td><div class='row p-0' style='width:170px'>");   
                         out.println("<div class='col-6'><a href='Controlador?metodo=editar&id="+usuario.getId()+"' class='btn btn-primary btn-sm'>Modificar</a></div>");
                         out.println("<div class='col-6'><a href='Controlador?id="+usuario.getId()+"'  class='eliminar btn btn-danger btn-sm'>Eliminar</a></div>");
                        
                         out.println("</div></td>");   
                         out.println("<tr>");   
                         
                        }
                    }
                %>                    
                </tbody>
            </table>
            <div class="modal fade" tabindex="-1" id="modal-success">
                <div class="modal-dialog modal-dialog-centered" style="width:360px">
                    <div class="modal-content">
                        <div class="modal-header bg-success text-white">
                            Mensaje
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body" id="modal_success">
                            
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-success" data-dismiss="modal">Aceptar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" tabindex="-1" id="modal-danger">
            <div class="modal-dialog modal-diaglog-centered" style="width:360px">
                <div class="modal-content">
                    <div class="modal-header bg-danger text-white">
                        Error
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body" id="modal_danger">
                        
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-danger" data-dismiss="modal">Aceptar</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</html>
