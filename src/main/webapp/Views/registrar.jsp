<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Usuarios</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script type="text/javascript" src="Views/js/registrar.js"></script>
    </head>
    <body>
        <div class="containner">
            <div class="row">
                <div class="col-10 offset-1 col-sm-8 offset-sm-2 col-md-6 offset-md-3">
                    <h1 clasS="text-center">Registrar Usuario</h1>
                    <form method="post" id="formulario">
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" id="nombre" name="nombre" class="form-control form-control-sm" placeholder="Nombre" maxlenght="50" required>
                        </div>
                        <div class="form-group">
                            <label for="apellidos">Apellidos</label>
                            <input type="text" id="apellidos" name="apellidos" class="form-control form-control-sm" placeholder="Apellidos" maxlenght="50" required>
                        </div>
                        <div class="form-group">
                            <label for="edad">Edad</label>
                            <input type="number" id="edad" name="edad" class="form-control form-control-sm" placeholder="Edad" maxlenght="50" required>
                        </div>
                        <input name="btn" value="registrar" class="d-none">
                        <input type="submit" value="Registrar Usuario" class="d-block btn btn-primary">
                    </form>
                    <div class="modal fade" id="modal-success" tab-index="-1">
                        <div class="modal-dialog modal-dialog-centered" style="width:360px" id="modal-success">
                            <div class="modal-content">
                                <div class="modal-header bg-success text-white">
                                    Mensaje
                                    <button type="button" class="close" aria-label="Close">
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
                    <div class="modal fade" id="modal-danger" tab-index="-1">
                        <div class="modal-dialog modal-dialog-centered" style="width:360px" id="modal-danger">
                            <div class="modal-content">
                                <div class="modal-header bg-success text-white">
                                    Error
                                    <button type="button" class="close" aria-label="Close">
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
                </div>
            </div>
        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    
    
</html>
