/**
 * 
 */
package es.noletia.prensa.dao;

import java.util.List;

import es.noletia.prensa.modelo.Medio;

/**
 * @author ramon
 *
 */
public interface MedioDAO extends CRUDDAO<Medio> {

	public List<Medio> getMediosSelect();

}
