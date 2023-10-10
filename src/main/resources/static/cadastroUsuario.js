$("#enviarLogin").click(cadastrarUsuario);

function cadastrarUsuario(){
	let nome = $("#nome").val();
	let cpf = $("#cpf").val();
	let dataNascimento = $("#dataNascimento").val();
	let rg = $("#rg").val();
	let email = $("#email").val();
	let telefone = $("#telefone").val();
	let cep = $("#cep").val();
	let estado = $("#estado").val();
	let cidade = $("#cidade").val();
	let bairro = $("#bairro").val();
	let rua = $("#rua").val();
	let numero = $("#numero").val();
	let senha = $("#senha").val();

	$.ajax({
		type: "POST",
		url: "/cadastro",
		data:{
			nome:nome,
			cpf:cpf,
			dataNascimento:dataNascimento,
			rg:rg,
			email:email,
			telefone:telefone,
			cep:cep,
			estado:estado,
			cidade:cidade,
			bairro:bairro,
			rua:rua,
			numero:numero,
			senha:senha,
		},
        success:function(data){
          	document.write(data);
        },
        error:function(){
          	alert("Erro inesperado");
        }
    });
}