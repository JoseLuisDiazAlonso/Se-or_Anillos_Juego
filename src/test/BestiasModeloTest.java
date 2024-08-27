package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import senorAnillosModelos.BestiasModelo;

/**
 * @author José Luis Díaz Alonso. Generamos una clase test para llevar a cabo
 *         los test de los métodos agregarPersonaje y generarPotencia de la
 *         clase BestiasModelo.
 */
public class BestiasModeloTest {

	// Creamos un método para añadir elementos a una lista.

	@Test
	public void testAgregarPersonaje() {

		// Generamos una instancia de bestiasModelo.

		BestiasModelo bestiasModelo = new BestiasModelo("Uruk", 150, 70);

		// Agregamos un elemento a la lista.

		bestiasModelo.agregarPersonaje(bestiasModelo);

		// Comprobamos que se cumple la condición.

		assertTrue(bestiasModelo.getListaBestias().contains(bestiasModelo));

	}

	/**
	 * Creamos un método para generar un test de la función generarPotencia(). El
	 * cual nos devolverá un valor llamado potenciaOfensiva que se obtiene a partir
	 * de un dado con una puntuación comprendida entre 0 y 90.
	 */

	@Test
	public void testGenerarPotencia() {
		// Primero creamos una instancia de la clase

		BestiasModelo bestiasModelo = new BestiasModelo(null, 0, 0);

		// Llamamos al método generarPotencia.

		int potenciaOfensiva = bestiasModelo.generarPotencia();

		// Ahora comprobamos que se cumple la condición.

		assertTrue(potenciaOfensiva >= 0 && potenciaOfensiva <= 90);

	}

}

