package senorAnillosModelos;

import java.util.ArrayList;
import java.util.List;

/**
 * @author josel Creamos la clase HeroesModelo que extiende de
 *         PersonajeModelo.Creamos la lista listaHeroes con sus métodos set y
 *         get y los métodos para agregar y eliminar personajes a la lista y
 *         generar Potencia. Igualmente creamos las clases internas Humanos,
 *         Elfo, Hobbit.
 */
public class HeroesModelo extends PersonajeModelo {

	// Atributo. Lista de Heroes.

	private List<PersonajeModelo> listaHeroes;

	// Constructor

	public HeroesModelo(String nombre, int puntosVida, int nivelArmadura) {
		super(nombre, puntosVida, nivelArmadura);
		listaHeroes = new ArrayList<>();
	}

	// Método getter y setter de listaHeroes.

	public List<PersonajeModelo> getListaHeroes() {
		return listaHeroes;
	}

	public void setListaHeroes(List<PersonajeModelo> listaHeroes) {
		this.listaHeroes = listaHeroes;
	}

	// Creamos el método para agregar personajes a la lista.

	public void agregarPersonaje(PersonajeModelo personaje) {
		listaHeroes.add(personaje);

	}

	// Creamos un método para eliminar un personaje de la lista.

	public void eliminarPersonaje(PersonajeModelo personaje) {
		listaHeroes.remove(personaje);
	}

	/**
	 * Creamos un método llamado generarPotencia que consistirá en que tenemos dos
	 * dados con una puntuación comprendida entre 0 y 100 puntos. Escogeremos el
	 * valor máximo de uno de los dos dados. Para ello usaremos los métodos
	 */

	public int generarPotencia() {

		int dado1 = (int) (Math.random() * 101);
		int dado2 = (int) (Math.random() * 101);

		int potenciaOfensiva = Math.max(dado1, dado2);
		return potenciaOfensiva;

	}

	/**
	 * Ahora generamos las clases internas de Humano, Elfo y Hobbit que heredan de
	 * personaje.
	 */

	// Clase Interna Elfo

	public class Elfo extends HeroesModelo {

		// Constructor

		public Elfo(String nombre, int puntosVida, int nivelArmadura) {
			super(nombre, puntosVida, nivelArmadura);
			// TODO Auto-generated constructor stub
		}

		// Método toString.

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return getNombre() + ", Elfo, " + getPuntosVida() + " ptos de vida, " + getNivelArmadura()
					+ " ptos de Armadura.";
		}

	}

	// Clase interna Humano.

	public class Humano extends HeroesModelo {

		// Constructor

		public Humano(String nombre, int puntosVida, int nivelArmadura) {
			super(nombre, puntosVida, nivelArmadura);
			// TODO Auto-generated constructor stub
		}

		// Método toString

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return getNombre() + ", Humano, " + getPuntosVida() + " ptos de vida, " + getNivelArmadura()
					+ " ptos Armadura.";
		}

	}

	// Clase Interna Hobbit.

	public class Hobbit extends HeroesModelo {

		// Constructor

		public Hobbit(String nombre, int puntosVida, int nivelArmadura) {
			super(nombre, puntosVida, nivelArmadura);
			// TODO Auto-generated constructor stub
		}

		// Método toString.

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return getNombre() + ", Hobbit, " + getPuntosVida() + " ptos de vida, " + getNivelArmadura()
					+ " ptos de Armadura.";
		}

	}

}
