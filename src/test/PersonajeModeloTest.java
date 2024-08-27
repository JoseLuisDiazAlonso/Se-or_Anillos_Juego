package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import senorAnillosModelos.PersonajeModelo;

/**
 * @author Jose Luis Díaz. Vamos a hacer los test de los métodos getter y setter
 *         de la clase PersonajeModelo usando jUnit5.
 */
public class PersonajeModeloTest {

	@Test
	public void testGetterAndSetter() {

		// Creamos una instancia de la clase

		PersonajeModelo personaje = new PersonajeModelo(null, 0, 0);

		// Establecemos valores usando los setter.

		personaje.setNombre("Legolas");
		personaje.setPuntosVida(120);
		personaje.setNivelArmadura(50);

		// Obtenemos los valores usando getter y setter.

		String nombre = personaje.getNombre();
		int puntosVida = personaje.getPuntosVida();
		int nivelArmadura = personaje.getNivelArmadura();

		// Ahora comprobamos que los valores son los esperados.

		Assertions.assertEquals("Legolas", nombre);
		Assertions.assertEquals(120, puntosVida);
		Assertions.assertEquals(50, nivelArmadura);

	}

}
