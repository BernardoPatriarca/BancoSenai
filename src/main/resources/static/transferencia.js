$("#enviarComprovanteDeTransferencia").click(transferir);

function transferir(){
    let agencia = $("#agencia").val();
    let quantidade = $("#quantidade").val();
    let nome = $("#nome").val();
    let cpf = $("#cpf").val();
    let conta = $("#conta").val();

    $.ajax({
        type: "POST",
        url: "/transferencia",
        data:{
            agencia:agencia,
            quantidade:quantidade,
            nome:nome,
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