// Call the dataTables jQuery plugin
$(document).ready(function() {
	
	cargarUsuarios();
	
  $('#usuario').DataTable();
});

async function cargarUsuarios() {
//	(async () => {
  const rawResponse = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
//    body: JSON.stringify({a: 1, b: 'Textual content'})
  });
  const content = await rawResponse.json();

	let listadoHTML='';
	
	for(let usuario of content) {
		let botonEliminar='<a href="#" onclick="eliminarUsuarios(' + usuario.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i> </a>';
		let usuarioHtml = '<tr><td> ' + usuario.id + '</td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>'
			+ usuario.email + '</td><td>' + usuario.telefono + '</td><td>' + botonEliminar + '</td></tr> ';
		listadoHTML += usuarioHtml;
	}
	document.querySelector('#usuario tbody').outerHTML = listadoHTML

//})();
}


async function eliminarUsuarios(id) {
	//alert(id);
	if(!confirm("¿Desea realmente eliminar esta entrada? Esta acción es irreversible")){
		return;
	}
	
	const rawResponse = await fetch('api/usuarios/' + id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  cargarUsuarios();
}