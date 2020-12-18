$().ready(function(){
    
    $("#formulario").submit(function(e){
        e.preventDefault();
        var url = $(this).attr("action");
        var type= $(this).attr("method");
        $.ajax({
            url:url,
            type:type,
            data:$(this).serialize(),
            dataType:"text",
            success:function(response){
                if(response=="Se registro correctamente el usuario"){
                    $("#modal_success").html(response);
                    $("#modal-success").modal();
                    $("#modal-success").on("hidden.bs.modal",function(){
                        location.href="Controlador";
                    });
                }
                else{
                    if(response=="No registro correctamente el usuario"){
                        $("#modal_danger").html(response);
                        $("#modal-danger").modal();
                        $("#modal-danger").on("hidden.bs.modal",function(){
                            location.href="Controlador";
                        });    
                    }  
                
                }
            }
            ,
            error:function(error){
                alert("ocurrio un error"+error);
            }
        });
    });
});