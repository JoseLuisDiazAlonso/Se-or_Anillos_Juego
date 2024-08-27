package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import senorAnillosModelos.HeroesModelo;
import senorAnillosModelos.PersonajeModelo;

/**
 * @author Jose Luis Díaz Alonso. Ahora vamos a hacer un test para la clase
 *         HeroesModelo, en la cual tendremos una lista de tipo Array llamada
 *         listaHeroes. Para ello usaremos jUnit5 para llevar a cabo los test
 *         sobre las funciones: añadir un elemento a la lista y el método de
 *         generarPotencia.
 */
public class HeroesModeloTest {

	// Llevamos a cabo el test para añadir elementos a la lista.

	@Test
	public void testAgregarPersonaje() {

		// Creamos una instancia de la clase HeroesModelo.

		HeroesModelo heroesModelo = new HeroesModelo("Aragon", 150, 50);

		// Añadimos el objeto a la lista.

		heroesModelo.agregarPersonaje(heroesModelo);

		// Ahora comprobamos que la lista contiene el personaje añadido.

		assertTrue(heroesModelo.getListaHeroes().contains(heroesModelo));

	}

	@Test
	public void testPotenciaOfensiva() {
		// Generamos dos valores aleatorios entre 0 y 100.

		int dado1 = (int) (Math.random() * 101);
		int dado2 = (int) (Math.random() * 101);

		// Calculamos la potencia Ofensiva.

		int potenciaOfensiva = Math.max(dado1, dado2);

		// Verificamos que la potencia ofensiva sea el valor mayor de los dados.

		Assertions.assertTrue(potenciaOfensiva == dado1 || potenciaOfensiva == dado2);
	}

	@Test
	public void testEliminarPersonaje() {
		// Crear un nuevo héroe para eliminar
		PersonajeModelo personajeAEliminar = new PersonajeModelo("Personaje a Eliminar", 100, 5);

		// Crear una instancia de la clase HeroesModelo
		HeroesModelo heroesModelo = new HeroesModelo("Nombre", 100, 10);

		// Agregar el personaje a la lista de héroes
		heroesModelo.agregarPersonaje(personajeAEliminar);

		// Verificar que el personaje se encuentra en la lista antes de eliminarlo
		assertTrue(heroesModelo.getListaHeroes().contains(personajeAEliminar));

		// Llamar al método eliminarPersonaje
		heroesModelo.eliminarPersonaje(personajeAEliminar);

		// Verificar que el personaje ha sido eliminado de la lista
		assertFalse(heroesModelo.getListaHeroes().contains(personajeAEliminar));
	}

	 
	       
	        
	        

	        
}

