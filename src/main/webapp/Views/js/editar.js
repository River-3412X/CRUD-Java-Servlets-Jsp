$().ready(function(){
    $("#formulario").submit(function(e){
        e.preventDefault();
        var formulario=$(this);
        $.ajax({
            url:formulario.attr("action"),
            type:formulario.attr("method"),
            data:formulario.serialize(),
            dataType:"text",
            success:function(response){
                 if(response=="Se modificó usuario correctamente"){
                    $("#modal_success").html(response);
                    $("#modal-success").modal();
                    $("#modal-success").on("hidden.bs.modal",function(){
                        location.href="Controlador";
                    });
                }
                else{
                    if(response=="no se modificó usuario"){
                        $("#modal_danger").html(response);
                        $("#modal-danger").modal();
                        $("#modal-danger").on("hidden.bs.modal",function(){
                            location.href="Controlador";
                        });    
                    }  
                
                }
            },error:function(respuesta){
                console.log("error:"+respuesta);
            }
        });
    });
});