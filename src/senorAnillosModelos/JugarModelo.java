package senorAnillosModelos;

import java.util.List;

import senorAnillosControlador.Controlador;
import senorAnillosModelos.BestiasModelo.Orco;
import senorAnillosModelos.BestiasModelo.Trasgo;

/**
 * @author josel Creamos la clase JugarModelo en la cual desarrollaremos el
 *         método para desarrollar nuestra partida por turnos.
 */
public class JugarModelo {

	private Controlador controlador;

	public JugarModelo(Controlador controlador) {
		super();
		this.controlador = controlador;
	}

	public void jugar(List<PersonajeModelo> heroes, List<PersonajeModelo> bestias, Controlador controlador) {
		int numeroTurno = 1;

		while (!heroes.isEmpty() && !bestias.isEmpty()) {
			controlador.actualizarTextAreaJugar("Turno " + numeroTurno + ":");

			for (int i = 0; i < heroes.size(); i++) {
				if (i < bestias.size()) {
					HeroesModelo heroe = (HeroesModelo) heroes.get(i);
					BestiasModelo bestia = (BestiasModelo) bestias.get(i);

					controlador.actualizarTextAreaJugar(
							"Lucha entre " + heroe.getNombre() + " (Vida=" + heroe.getPuntosVida() + " Armadura="
									+ heroe.getNivelArmadura() + ") y " + bestia.getNombre() + " (Vida="
									+ bestia.getPuntosVida() + " Armadura=" + bestia.getNivelArmadura() + ")");

					int potenciaOfensivaHeroe = 0;
					int potenciaOfensivaBestia = 0;

					if (heroe instanceof HeroesModelo.Elfo && bestia instanceof Orco) {
						potenciaOfensivaHeroe = ((HeroesModelo.Elfo) heroe).generarPotencia() + 10;
					} else if (heroe instanceof HeroesModelo.Hobbit && bestia instanceof Trasgo) {
						potenciaOfensivaHeroe = ((HeroesModelo.Hobbit) heroe).generarPotencia() - 5;
					} else {
						// Verificar si bestia es Orcos o Trasgos
						if (bestia instanceof Orco) {
							potenciaOfensivaBestia = ((Orco) bestia).generarPotencia();
							heroe.setNivelArmadura((int) (heroe.getNivelArmadura() * 0.1));
						} else if (bestia instanceof Trasgo) {
							potenciaOfensivaBestia = ((Trasgo) bestia).generarPotencia();
						}
					}

					// Ataque del Heroe a la bestia

					if (potenciaOfensivaHeroe > bestia.getNivelArmadura()) {
						int vidaQuitadaBestia = potenciaOfensivaHeroe - bestia.getNivelArmadura();

						bestia.setPuntosVida(bestia.getPuntosVida() - vidaQuitadaBestia);

						controlador.actualizarTextAreaJugar(heroe.getNombre() + " saca " + potenciaOfensivaHeroe
								+ " y le quita " + vidaQuitadaBestia + " de vida a " + bestia.getNombre());
					} else {
						controlador.actualizarTextAreaJugar(heroe.getNombre() + " falla");
					}

					// Ataque de la Bestia al Héroe.

					if (potenciaOfensivaBestia > heroe.getNivelArmadura()) {
						int vidaQuitadaHeroe = potenciaOfensivaBestia - heroe.getNivelArmadura();
						heroe.setPuntosVida(heroe.getPuntosVida() - vidaQuitadaHeroe);

						controlador.actualizarTextAreaJugar(bestia.getNombre() + " saca " + potenciaOfensivaBestia
								+ " y le quita " + vidaQuitadaHeroe + " de vida a " + heroe.getNombre());
					} else {
						controlador.actualizarTextAreaJugar(bestia.getNombre() + " falla");
					}

					// Verificamos si el héroe ha muerto y lo eliminamos de la lista.

					if (heroe.getPuntosVida() <= 0) {
						heroes.remove(heroe);
						controlador.actualizarTextAreaJugar(heroe.getNombre() + " ha muerto");
					}

					// Verificamos si la bestia ha muerto y lo eliminamos de la lista.

					if (bestia.getPuntosVida() <= 0) {
						bestias.remove(bestia);
						controlador.actualizarTextAreaJugar(bestia.getNombre() + " ha muerto");
					}
				}
			}

			numeroTurno++;
		}

		// Imprimir mensaje de victoria al final del juego
		if (heroes.isEmpty()) {
			controlador.actualizarTextAreaJugar("¡VICTORIA DE LAS BESTIAS!");
		} else if (bestias.isEmpty()) {
			controlador.actualizarTextAreaJugar("¡VICTORIA DE LOS HEROES!");
		}
	}

}
