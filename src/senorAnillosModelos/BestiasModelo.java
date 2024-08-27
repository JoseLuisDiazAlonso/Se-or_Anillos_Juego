package senorAnillosModelos;

import java.util.ArrayList;
import java.util.List;

/**
 * @author José Luis Díaz Alonso Creamos una clase llamada BestiasModelo que
 *         hereda de la clase PersonajeModelo y con una lista llamada
 *         listaBestias y con los métodos agregar y eliminar personajes a la
 *         lista y generarPotencia.Además generaremos dos clases internas
 *         llamadas Orcos y Trasgos.
 */
public class BestiasModelo extends PersonajeModelo {

	// Atributo

	private List<PersonajeModelo> listaBestias;

	// Constructor

	public BestiasModelo(String nombre, int puntosVida, int nivelArmadura) {
		super(nombre, puntosVida, nivelArmadura);
		listaBestias = new ArrayList<>();
	}

	// Métodos getter y setter

	public List<PersonajeModelo> getListaBestias() {
		return listaBestias;
	}

	public void setListaBestias(List<PersonajeModelo> listaBestias) {
		this.listaBestias = listaBestias;
	}

	// Método para agregar Personaje a la lista.

	public void agregarPersonaje(PersonajeModelo personaje) {
		listaBestias.add(personaje);

	}

	// Método para eliminar al personaje de la lista

	public void eliminarPersonaje(PersonajeModelo personaje) {
		listaBestias.remove(personaje);
	}

	/**
	 * Generamos un método llamado generarPotencia la cual esta basada en un único
	 * dado con valores entre 0 y 90 y que nos devuelva como valor la potencia
	 * Ofensiva.
	 */

	public int generarPotencia() {
		int potenciaOfensiva = (int) (Math.random() * 91);
		return potenciaOfensiva;
	}

	/**
	 * Ahora generamos las clases Internas de BestiasModelo que son Orco y Trasgo
	 */

	// Clase Interna de Orco.

	public class Orco extends BestiasModelo {

		// Constructor

		public Orco(String nombre, int puntosVida, int nivelArmadura) {
			super(nombre, puntosVida, nivelArmadura);
			// TODO Auto-generated constructor stub
		}

		// Método toString.

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return getNombre() + " ,Orco " + getPuntosVida() + " ptos de vida, " + getNivelArmadura()
					+ " ptos de Armadura";
		}

	}

	// Clase Interna de Trasgo

	public class Trasgo extends BestiasModelo {

		// Constructor

		public Trasgo(String nombre, int puntosVida, int nivelArmadura) {
			super(nombre, puntosVida, nivelArmadura);
			// TODO Auto-generated constructor stub
		}

		// Método toString.

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return getNombre() + " ,Trasgo " + getPuntosVida() + " ptos de vida, " + getNivelArmadura()
					+ " ptos de Armadura";
		}

	}

	
}
