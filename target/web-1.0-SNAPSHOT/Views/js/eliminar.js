$().ready(function(){
    $(".eliminar").each(function(){
        $(this).click(function(e){
            e.preventDefault();
            var a=$(this);
            $.ajax({
                url:a.attr("href"),
                type:"post",
                dataType:"text",
                data:{
                  "btn":"eliminar"
                },
                success:function(response){
                     if(response=="Se eliminó usuario Correctamente"){
                        $("#modal_success").html(response);
                        $("#modal-success").modal();
                        $("#modal-success").on("hidden.bs.modal",function(){
                            location.href="Controlador";
                        });
                    }
                    else{
                        if(response=="No se eliminó usuario"){
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
});
