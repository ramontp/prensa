/**
 * 
 * /
/*
package es.noletia.clientes.struts;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author ramon
 * 
 * /
@Component
@Scope("prototype")
public class CopiaSeguridadAction extends ComunAction {
	/**
	 * Logger for this class
	 * /
	private static final Logger logger = Logger
			.getLogger(CopiaSeguridadAction.class);

	private static final long serialVersionUID = 1L;

	// para mostrar los mensajes
	private String mensaje;

	public String copiaSeguridad() {

		return SUCCESS;
	}

	public String ejecutaCopiaSeguridad() {
		PrintWriter writer = null;
		try {
			writer = ServletActionContext.getResponse().getWriter();
			try {
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd_HH-mm-ss");

				ResourceBundle props = ResourceBundle.getBundle("global");

				String path = props.getString("carpetaCopiaSeguridad")
						+ "copia_seguridad_" + sdf.format(date) + ".dmp";
				String executeCmd = "mysqldump -u "
						+ props.getString("usuarioCopia") + " -p"
						+ props.getString("passwordCopia")
						+ " --add-drop-database -B clientes -r " + path;

				Process runtimeProcess;

				runtimeProcess = Runtime.getRuntime().exec(executeCmd);
				int processComplete = runtimeProcess.waitFor();

				if (processComplete == 0) {
					writer.print("ok");
				} else {
					writer.print("ko");
				}
			} catch (Exception e) {
				writer.print("ko");
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			logger.error("Error en ejecutaCopiaSeguridad", e);
			mensaje = "Se ha producido un error en la aplicación. Consulte el log para más información";
		}
		return NONE;
	}

	public String abreCarpetaCopiaSeguridad() {
		PrintWriter writer = null;
		try {
			writer = ServletActionContext.getResponse().getWriter();
			ResourceBundle props = ResourceBundle.getBundle("global");
			Process runtimeProcess;

			String executeCmd = props.getString("comandoAperturaCarpeta") + " "
					+ props.getString("carpetaCopiaSeguridad");
			runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			int processComplete = runtimeProcess.waitFor();

			if (processComplete == 0) {
				writer.print("ok");
			} else {
				writer.print("ko");
			}
		} catch (Exception e) {
			logger.error("Error en abreCarpetaCopiaSeguridad", e);
		}
		return NONE;
	}

	/**
	 * @return the mensaje
	 * /
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 *            the mensaje to set
	 * /
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
*/