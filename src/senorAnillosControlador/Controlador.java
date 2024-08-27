package senorAnillosControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import senorAnillosModelos.BestiasModelo;
import senorAnillosModelos.HeroesModelo;
import senorAnillosModelos.JugarModelo;
import senorAnillosModelos.PersonajeModelo;
import senorAnillosVista.senorAnillosVista;

/**
 * @author josel. Ahora creamos la clase controladora en la que se relacionará la vista y el modelo
 * y se da funcionalidad a los botones.
 */
public class Controlador {

	private HeroesModelo modelo;
	private BestiasModelo modeloBestias;
	private senorAnillosVista vista;
	private JFrame frame;
	private JugarModelo jugarModelo;

	public Controlador(HeroesModelo modelo, BestiasModelo modeloBestias, senorAnillosVista vista,
			JFrame frmLaBatallaPor, JugarModelo jugarModelo) {
		this.modelo = modelo;
		this.modeloBestias = modeloBestias;
		this.vista = vista;
		this.frame = frmLaBatallaPor;
		this.jugarModelo = jugarModelo;

		vista.addBtnAñadirHeroesListener(new BtnAñadirHeroesListener());
		vista.addBtnEliminarHeroesListener(new BtnEliminarHeroesListener());
		vista.addBtnAñadirBestiasListener(new BtnAñadirBestiasListener());
		vista.addBtnEliminarBestiasListener(new BtnEliminarBestiasListener());
		vista.addBtnJugarListener(new BtnJugarListener());

	}
	
	//Damos funcionaidad al botón AñadirHeroes.

	public class BtnAñadirHeroesListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Obtenemos los datos de la vista

			String nombre = vista.getTextFieldNombreHeroes();
			int vida = vista.getTextFieldVidaHeroes();
			int armadura = vista.getTextFieldArmaduraHeroes();
			String tipo = vista.getSelectedTipoHeroes();

			PersonajeModelo nuevoHeroe = null;

			// Creamos un nuevo personaje dependiendo del tipo seleccionado.

			switch (tipo) {
			case "Humano":
				nuevoHeroe = modelo.new Humano(nombre, vida, armadura);
				break;
			case "Elfo":
				nuevoHeroe = modelo.new Elfo(nombre, vida, armadura);
				break;
			case "Hobbit":
				nuevoHeroe = modelo.new Hobbit(nombre, vida, armadura);
				break;
			default:
				break;

			}

			// Agregamos el nuevo personaje a la lista

			if (nuevoHeroe != null) {
				modelo.agregarPersonaje(nuevoHeroe);
			}

			// Actualizamos la vista

			vista.actualizarTextAreaHeroes(modelo.getListaHeroes());

			vista.limpiarCamposHeroes();
		}

	}
	
	//Damos funcionalidad al botón EliminarHeroes.

	public class BtnEliminarHeroesListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			/* Mostramos el cuadro de diálogo que nos pida un nombre del Héroe a eliminar */

			String nombreHeroe = JOptionPane.showInputDialog(vista.getFrmLaBatallaPor(),
					"Ingrese el nombre del héroe a eliminar.");

			/* Verificamos si el nombre ingresado no es nulo y no está vacio */

			if (nombreHeroe != null && !nombreHeroe.isEmpty()) {

				// Obtenemos la lista de héroes del modelo

				List<PersonajeModelo> listaHeroes = modelo.getListaHeroes();

				boolean encontrado = false;

				// Buscamos el héroe con el nombre Ingresado

				for (PersonajeModelo heroe : listaHeroes) {

					if (heroe.getNombre().equalsIgnoreCase(nombreHeroe)) {

						// Eliminamos el héroe del modelo

						modelo.eliminarPersonaje(heroe);

						// Actualizamos la vista

						vista.actualizarTextAreaHeroes(modelo.getListaHeroes());

						// Mostramos el mensaje de éxito

						JOptionPane.showMessageDialog(vista.getFrmLaBatallaPor(),
								"El Héroe se ha eliminado con éxito.");

						encontrado = true;

						break;
					}
				}

				/*
				 * Si no se encuentra un héroe con el nombre ingresado se muestra el mensaje de
				 * error.
				 */

				if (!encontrado) {
					JOptionPane.showMessageDialog(vista.getFrmLaBatallaPor(), "No se encuentra ningún Héroe.");
				}
			}

		}

	}
	
	//Damos funcionalidad al botón Añadir Bestias

	public class BtnAñadirBestiasListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Obtenemos datos de la vista

			String nombre = vista.getTextFieldNombreBestias();
			int vida = vista.getTextFieldVidaBestias();
			int armadura = vista.getTextFieldArmaduraBestias();
			String tipo = vista.getSelectedTipoBestias();

			// Creamos un nuevo personaje dependiendo del tipo.

			PersonajeModelo nuevaBestia = null;

			switch (tipo) {
			case "Orco":
				nuevaBestia = modeloBestias.new Orco(nombre, vida, armadura);
				break;
			case "Trasgo":
				nuevaBestia = modeloBestias.new Trasgo(nombre, vida, armadura);
				break;
			default:
				break;

			}

			// Agregamos un nuevo personaje a la lista.

			if (nuevaBestia != null) {
				modeloBestias.agregarPersonaje(nuevaBestia);
			}

			// Actualizamos la vista

			vista.actualizarTextAreaBestias(modeloBestias.getListaBestias());

			// Limpiamos los Campos

			vista.limpiarCamposBestias();

		}

	}
	
	//Damos funcionalidad al botón Eliminar Bestias.

	public class BtnEliminarBestiasListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			/*
			 * Creamos un cuadro de diálogo en el que pedimos al usuario que introduzca un
			 * nombre de la bestia a Eliminar.
			 */

			String nombreBestia = JOptionPane.showInputDialog(vista.getFrmLaBatallaPor(),
					"Ingrese el nombre de la Bestia a Eliminar");

			/* Establecemos la condición que el nombre no sea nulo ni este vacío. */

			if (nombreBestia != null && !nombreBestia.isEmpty()) {
				// Obtenemos la listade Bestias del modelo.

				List<PersonajeModelo> listaBestias = modeloBestias.getListaBestias();

				boolean encontrado = false;

				// Buscamos la Bestia con el nombre introducido

				for (PersonajeModelo bestia : listaBestias) {
					if (bestia.getNombre().equalsIgnoreCase(nombreBestia)) {

						// Eliminamos la bestia del modelo.

						modeloBestias.eliminarPersonaje(bestia);

						// Actualizamos la vista

						vista.actualizarTextAreaBestias(modeloBestias.getListaBestias());

						// Mostramos el mensaje de éxito

						JOptionPane.showMessageDialog(vista.getFrmLaBatallaPor(), "La Bestia Ha sido Eliminada");

						encontrado = true;
						break;
					}
				}

				if (!encontrado) {
					JOptionPane.showMessageDialog(vista.getFrmLaBatallaPor(), "No se Ha Encontrado la Bestia");
				}
			}

		}

	}
	
	//Método para actualizar el TextArea Jugar

	public void actualizarTextAreaJugar(String texto) {
		vista.actualizarTextAreaJugar(texto);
	}
	
	//Damos funcionalidad al botón para Jugar.

	public class BtnJugarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// Llamamos al método jugar de la clase JugarModelo

			JugarModelo jugarModelo = new JugarModelo(null);

			jugarModelo.jugar(modelo.getListaHeroes(), modeloBestias.getListaBestias(), Controlador.this);

		}

	}

}
