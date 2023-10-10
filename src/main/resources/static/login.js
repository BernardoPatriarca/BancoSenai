$("#login").click(enviarLogin);

$("#cpf").keyup(function(event){
    if (event.key === "Enter") {
        $("#senha").focus();
    }
});

$("#senha").keyup(function(event){
    if (event.key === "Enter") {
        enviarLogin();
    }
});

function enviarLogin(){
    let cpf = $("#cpf").val();
    let senha = $("#senha").val();

    $.ajax({
        type: "POST",
        url: "/login",
        data:{
            cpf: cpf,
            senha: senha
        },
        success: function(data){
            if(data){
                window.location.href="/home";
            }else{
                alert("Errooouuu!");
            }
        },
        error: function(){
            alert("Falha ao tentar realizar o login!");
        }
    });
}