/**
 * Fichero con funciones javascript 
 */

$(document).ready(function(){
	$("tr.odd>td").removeClass("res");
	$("tr.odd>td").addClass("res2");
	
	$('a[href*="borra"]').click(function(){
		var confirma = "";
		if (objeto == 'Prensa'){
			confirma="Vas a eliminar un medio de prensa y todos los contactos asociados. ¿Estás seguro?";
		} else if (objeto == 'Categoria'){
			confirma="Vas a eliminar una categoria. ¿Estás seguro?";
		}
		if (!confirm(confirma)){
			return false;
		}
	});	
	
	if (typeof edicion != 'undefined' && edicion){
		// realizamos los cambios necesarios para la edición
		$("#form1").prop("action","actualiza"+objeto+".action");
		$("#cancelar").css("display","");
		$("#cuerpo>fieldset>legend").html("<a href='#'>Edición de "+objeto+"</a>");
	}
	$("fieldset legend a:nth-child(1)").addClass("leyendaSeleccionada");
	
	// mostramos el buscador o el alta
	if (showBuscador == 'true'){
		$("#boton1").prop('value', 'Buscar');
		$("#form1").prop('action','busca'+objeto);
		$("fieldset legend a:nth-child(1)").removeClass("leyendaSeleccionada");
		$("fieldset legend a:nth-child(2)").addClass("leyendaSeleccionada");
		$("#capa1").css("display","none");
		$("#capa2").css("display","none");
		$("#capa4").css("display","none");
		
		$("#capa3").css("display","block");
	}
	
	// mostramos el mensaje si tuviera algo
	muestraMensaje();
	
	// quitamos la última coma en los listados
	quitaComaListados();
});

function muestraMensaje(){
	if (mensaje != ''){
		$("#showmensaje").html("<div id='spanshowmensaje' class='oculto'>"+mensaje+"</div>");
		$("#spanshowmensaje").fadeIn(500);
		setTimeout(function(){$("#spanshowmensaje").fadeOut(1000);},2000);
	}	
}

function vercontactos(idcliente){
	$("#cont_"+idcliente+">div").slideToggle();
}

var ncontacto=0;

function addContacto(){
	ncontacto++;
	
	var fila = $("<tr id='ncont-"+ncontacto+"'>");
	var col1 = $("<td>").html("<input type='text' class='input1' maxlength='45' />");
	var col2 = $("<td>").html("<input type='text' class='input2' maxlength='45' />");
	var col3 = $("<td>").html("<input type='text' class='input3' maxlength='80' />");
	var col4 = $("<td>").html("<input type='text' class='input4' maxlength='45' />");
	var col5 = $("<td>").html("<a href='#' onclick='borraContacto("+ncontacto+")'><img src='img/borrar.png'></a>");
	col5.append($("<input type='hidden' />"));
	
	fila.append(col1).append(col2).append(col3).append(col4).append(col5);
	
	$("#tablaC").append(fila);
}

function borraContacto(id,idc){
	if (typeof idc == 'undefined'){
		// eliminamos
		$("#ncont-"+id).remove();
	} else {
		// preguntamos
		if (confirm('Vas a eliminar un contacto. ¿Estás seguro?')){
			// eliminamos el registro
			$.get("borraContacto.action?idcontacto="+idc, function(data){
				if (data == 'ok'){
					// borramos la fila
					$("#ncont-"+id).remove();
					// mostramos el mensaje
					mensaje = "El contacto ha sido borrado de la base de datos";
					muestraMensaje();
				}
			});
		}
	}
}

function validaform(){

	if (showBuscador == 'true'){
		// recogemos las categorias seleccionadas
		recogeCategoriasSeleccionadas('b_');
		return true;
	}
	
	var l = true;
	var error1="";
	var error2="";
	var ul = $("<ul>").prop("class","errorMessage");
	
	// validamos si la empresa es vacía
	if ($("#empresa").val() == ''){
		l=false;
		error1="<li>El campo 'Medio' no puede estar vacío</li>";
		ul.append(error1);
	}

	// comprobamos que los datos fiscales no exceden de 1000 caracteres
//	if ($("#datosfiscales").val().length > 1000){
//		l=false;
//		error1="<li>El campo 'Datos Fiscales' no puede exceder de 1000 caracteres</li>";
//		ul.append(error1);
//	}

	// comprobamos que las observaciones no exceden de 1000 caracteres
	if ($("#observaciones").val().length > 1000){
		l=false;
		error1="<li>El campo 'Observaciones' no puede exceder de 1000 caracteres</li>";
		ul.append(error1);
	}

	// validamos los emails de los contacto
	$("tr[id|='ncont']").each(function(index,para){
		$(para).find("input").each(function(i,inp){
			if (i==2){
				email = $(inp).val();
				if (email != '' && !isValidEmailAddress(email)){
					l = false;
					error2="<li>El campo email ('"+email+"') no tiene el formato adecuado</li>";
					ul.append(error2);
				}
			}
		});
	});
	
	
	if (!l){
		// mostramos el error
		$(".errorMessage").remove();
		$("#errores").append(ul);
	}
	
	//recogemos los valores de los contactos si no hay errores
	if (l){
		var contactos = "";
		$("tr[id|='ncont']").each(function(index,para){
			contactos += "[";
			$(para).find("input").each(function(i,inp){
				contactos += (($(inp).val() != '')?$(inp).val():"-")+"|";
			});
			contactos += "],";
		});
		
		$("#contactos").val(contactos);
	}
	
	// recogemos las categorias seleccionadas
	recogeCategoriasSeleccionadas('');

	return l;
}

function recogeCategoriasSeleccionadas(prefijo){
	var categoriassel = "";
	$("input[id|='"+prefijo+"cat']").each(function(i,chk){
		categoriassel += $(chk).attr("id") + ":" + $(chk).is(':checked')+"#";
	});
	$("#categoriasseleccionadas").val(categoriassel);
}

function cancelarEdicion(){
	$("#form2").submit();
}

function muestraBuscador(){
	$("#boton1").prop('value', 'Buscar');
	$("#form1").prop('action','busca'+objeto);
	$("fieldset legend a:nth-child(1)").removeClass("leyendaSeleccionada");
	$("fieldset legend a:nth-child(2)").addClass("leyendaSeleccionada");
	//borramos los posibles mensajes de error
	$("#form1>ul").remove();
	$("#errores>ul").remove();
	// mostramos/ocultamos las capas adecuada
	$("#capa1").slideUp();
	$("#capa2").slideUp();
	$("#capa4").slideUp();
	$("#capa3").slideDown();
	showBuscador='true';
}

function muestraAlta(){
	$("#boton1").prop('value', 'Aceptar');
	$("#form1").prop('action','alta'+objeto);
	$("fieldset legend a:nth-child(1)").addClass("leyendaSeleccionada");
	$("fieldset legend a:nth-child(2)").removeClass("leyendaSeleccionada");
	// mostramos/ocultamos las capas adecuada
	$("#capa1").slideDown();
	$("#capa2").slideDown();
	$("#capa4").slideDown();
	$("#capa3").slideUp();
	showBuscador='';
}

//función tomada del foro de stackoverflow
function isValidEmailAddress(emailAddress) {
	var pattern = new RegExp(/^[+a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i);
  return pattern.test(emailAddress);
};//fin de isValidEmailAddress

function quitaComaListados(){
	if (objeto == 'Listados'){
		if ($("#seleccionaEmails").html() != ''){
			var emails = $.trim($("#seleccionaEmails").html());
			emails = emails.substr(0, emails.length - 1);
			$("#seleccionaEmails").html(emails);
		}
	}
}

function seleccionaEmails(){
	$("#seleccionaEmails").focus().select();
}

function copiaseguridad(){
	$.post("ejecutaCopiaSeguridad.action", function(data){
		if (data == 'ok'){
			mensaje = 'La copia de seguridad se ha realizado correctamente';
			muestraMensaje();
		} else {
			// ko
			mensaje = 'Se ha producido un error en la aplicación. Consulte el log de la aplicación';
			muestraMensaje();
		}
	});
}

function abrecarpeta(){
	$.post("abreCarpetaCopiaSeguridad.action");
}