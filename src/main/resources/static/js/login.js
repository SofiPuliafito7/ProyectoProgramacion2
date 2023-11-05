// Call the dataTables jQuery plugin
$(document).ready(function() {

	

});


async function iniciarSesion() {
	let datos = {};
	datos.email = document.getElementById('txtEmail').value;
	datos.password = document.getElementById('txtPassword').value;

	const rawResponse = await fetch('api/login', {
		method: 'POST',
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(datos)
	});
	const respuesta = await rawResponse.text(); //Maneja si hay una sesión
	
	if (respuesta === 'OK') {
		window.location.href = 'usuario.html';
	}
	else {
		alert("Los datos son incorrectos");
	}
//Cambiar el logo y las imagenes

}