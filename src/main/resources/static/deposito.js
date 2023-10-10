$("#enviarComprovanteDeDeposito").click(depositar);

function depositar(){
    let quantidade = $("#quantidade").val();
    let cpf = $("#cpf").val();
    let conta = $("#conta").val();

    $.ajax({
        type: "POST",
        url: "/deposito",
        data:{
            quantidade:quantidade,
            cpf: cpf,
            conta:conta,
        },
        },
        success:function(data){
            document.write(data);
        },
        error:function(){
            alert("Erro inesperado");
        }
});