/**
 * 
 */
package es.noletia.clientes.decorator;

import org.displaytag.decorator.TableDecorator;

import es.noletia.clientes.modelo.Cliente;

/**
 * @author ramon
 * 
 */
public class ContactosDecorator extends TableDecorator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.displaytag.decorator.TableDecorator#finishRow()
	 */
	@Override
	public String finishRow() {
		Cliente myRow = (Cliente) this.getCurrentRowObject();
		StringBuffer sb = new StringBuffer();
		boolean l = true;
		String estilo = "cc1";
		String valor = "";
		sb.append("<tr><td colspan='8' id='cont_" + myRow.getIdcliente() + "'>");
		sb.append("<div class='oculto'><div style='float:left; margin-left:10px'>L</div><div style='float:right; width:98%'><table class='elmtos2'>");
		sb.append("<tr><th style='width:25%'>Contacto</th><th style='width:20%'>Departamento</th><th style='width:35%'>Email</th><th style='width:20%'>Teléfono</th></tr>");
		for (int i = 0; i < myRow.getListacontactos().size(); i++) {
			sb.append("<tr>");
			sb.append("<td class='"+estilo+"'>");
			valor = myRow.getListacontactos().get(i).getContacto();
			sb.append((valor != null) ? valor : "");
			sb.append("</td>");
			sb.append("<td class='"+estilo+"'>");
			valor = myRow.getListacontactos().get(i).getDepartamento();
			sb.append((valor != null) ? valor : "");
			sb.append("</td>");
			sb.append("<td class='"+estilo+"'><a href='mailto:"+myRow.getListacontactos().get(i).getEmail()+"'>");
			valor = myRow.getListacontactos().get(i).getEmail();
			sb.append((valor != null) ? valor : "");
			sb.append("</a></td>");
			sb.append("<td class='"+estilo+"'>");
			valor = myRow.getListacontactos().get(i).getTelefono();
			sb.append((valor != null) ? valor : "");
			sb.append("</td>");
			sb.append("</tr>");
			l=!l;
			estilo = (l)?"cc1":"cc2";
		}
		sb.append("</table></div></div>");
		sb.append("</td></tr>");
		return sb.toString();
	}

}
