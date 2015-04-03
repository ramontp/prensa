<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="showmensaje"></div>
<fieldset>
	<legend><a href="#" class="leyenda">Filtrar emails por</a></legend>
	<s:form theme="simple" action="buscarListados" id="form1" onsubmit="recogeCategoriasSeleccionadas();">
			<div id="errores">
				<s:fielderror />
			</div>
		<s:hidden name="categoriasseleccionadas" id="categoriasseleccionadas" theme="simple"></s:hidden>
		<label for="empresa">Cliente</label>
		<s:textfield name="empresa" id="empresa" maxlength="45"></s:textfield>
		<br>
		<label for="provincia">Provincia</label>
		<s:select theme="simple" list="listaProvincias" name="provincia" listKey="idprovincia" listValue="nombre" headerKey="" headerValue="--Seleccione--"></s:select>
		<br>
		<label for="categoria">Categoría</label>
		<div style="float:left">
			<s:iterator value="listaCategorias" var="cat">
				<s:checkbox name="nombrecategoria" id="cat-%{idcategoria}" value="%{seleccionado}"></s:checkbox>${cat.nombrecategoria}<br>
			</s:iterator>
		</div>
		<div style="clear: both"></div>
		<br>
		<s:submit value="Aceptar"></s:submit>
	</s:form>
</fieldset>
<br>
<div id="listaExistentes">
	<h4>Listado de Emails</h4>
	<br>
	<a href="#" onclick="seleccionaEmails(); return false;">Selecciona los emails</a>
	<br><br>
	<textarea id="seleccionaEmails">
		<s:iterator value="listaEmails"><s:property />, </s:iterator>
	</textarea>
	
</div>
<script>
var mensaje = '<c:out value="${mensaje}"/>';
var objeto = "Listados";
var showBuscador = "";
</script>