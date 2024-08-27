package senorAnillosModelos;

/**
 * @author josel Generamos la clase PersonajeModelo con los atributos nombre,
 *         puntosVida y nivelArmadura y sus métodos getter y setter.
 */
public class PersonajeModelo {

	// Atributos.

	protected String nombre;
	protected int puntosVida;
	protected int nivelArmadura;

	// Constructor.

	public PersonajeModelo(String nombre, int puntosVida, int nivelArmadura) {
		super();
		this.nombre = nombre;
		this.puntosVida = puntosVida;
		this.nivelArmadura = nivelArmadura;
	}

	// Método getter and setter.

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntosVida() {
		return puntosVida;
	}

	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}

	public int getNivelArmadura() {
		return nivelArmadura;
	}

	public void setNivelArmadura(int nivelArmadura) {
		this.nivelArmadura = nivelArmadura;
	}

}
