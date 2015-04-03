<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="showmensaje"></div>

<fieldset>
	<legend><a href="#" class="leyenda">Alta de Categorias</a></legend>
	<s:form theme="simple" action="altaCategoria" id="form1">
			<div id="errores">
				<s:fielderror />
			</div>
		<s:hidden name="idcategoria" id="idcategoria"></s:hidden>
		<s:textfield name="nombrecategoria" id="nombrecategoria" maxlength="45"></s:textfield>
		<br><br>
		<s:submit value="Aceptar"></s:submit>
	</s:form>
</fieldset>
<br>
<div id="listaExistentes">
	<h4>Listado de Categorias</h4>
	<br>
	<display:table name="listaCategorias" id="lista" class="elmtos">
		<display:column property="nombrecategoria" class="res"></display:column>
		<display:column class="res">
			<a href="editaCategoria.action?idcategoria=${lista.idcategoria}"><img src="img/editar.gif" /></a>
			<a href="borraCategoria.action?idcategoria=${lista.idcategoria}"><img src="img/borrar.png" /></a>
		</display:column>
	</display:table>
</div>
<script>
var showBuscador = '';
var mensaje = '<c:out value="${mensaje}"/>';
var edicion = ($("#idcategoria").val().length > 0)?true:false;
var objeto = "Categoria";
</script>