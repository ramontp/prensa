/**
 *
 */
package es.noletia.prensa.modelo;

import java.io.Serializable;

/**
 * @author ramon
 *
 */
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1644376208445705738L;
    private Long idcontacto;
    private String contacto;
    private String nombre;
    private String observaciones;
    private String email;
    private String email2;
    private String telefono;
    private Medio medio;
    private Integer destacado;
    private Integer fotografo;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the idcontacto
     */
    public Long getIdcontacto() {
        return idcontacto;
    }

    /**
     * @param idcontacto the idcontacto to set
     */
    public void setIdcontacto(Long idcontacto) {
        this.idcontacto = idcontacto;
    }

    /**
     * @return the contacto
     */
    public String getContacto() {
        return contacto;
    }

    /**
     * @param contacto the contacto to set
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the medio
     */
    public Medio getMedio() {
        return medio;
    }

    /**
     * @param medio the medio to set
     */
    public void setMedio(Medio cliente) {
        this.medio = cliente;
    }

    /**
     * @return the departamento
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    /**
     * @return the destacado
     */
    public Integer getDestacado() {
        return destacado;
    }

    /**
     * @param destacado the destacado to set
     */
    public void setDestacado(Integer destacado) {
        this.destacado = destacado;
    }

    public Integer getFotografo() {
        return fotografo;
    }

    public void setFotografo(Integer fotografo) {
        this.fotografo = fotografo;
    }
}
