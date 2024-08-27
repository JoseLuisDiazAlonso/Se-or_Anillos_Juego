package senorAnillosVista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import senorAnillosControlador.Controlador;
import senorAnillosModelos.BestiasModelo;
import senorAnillosModelos.HeroesModelo;
import senorAnillosModelos.JugarModelo;
import senorAnillosModelos.PersonajeModelo;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextArea;

/**
 *@author josel.Creamos la vista de los diferentes elementos del juego. 
 */
public class senorAnillosVista {

	private JFrame frmLaBatallaPor;
	private JTextField textFieldNombreHeroes;
	private JTextField textFieldVidaHeroes;
	private JTextField textFieldArmaduraHeroes;

	private JButton btnAñadirHeroes;

	private JComboBox<String> comboBoxHeroes;

	private JTextArea textAreaHeroes;
	private JTextArea textAreaBestias;
	private JTextArea textAreaJugar;

	private JScrollPane scrollPaneHeroes;
	private JScrollPane scrollPaneBestias;
	private JScrollPane scrollPaneJugar;

	private JLabel lblNewLabel_6;
	private JPanel panel_1;
	private JLabel lblNewLabel_7;
	private JTextField textFieldNombreBestias;
	private JLabel lblNewLabel_8;

	private JComboBox<String> comboBoxBestias;
	private JLabel lblNewLabel_9;
	private JTextField textFieldVidaBestias;
	private JLabel lblNewLabel_10;
	private JTextField textFieldArmaduraBestias;
	private JButton btnAñadirBestias;
	private JButton btnEliminarHeroe;
	private JButton btnEliminarBestia;
	private JButton btnJugar;
	
	//Creamos los diferentes métodos.

	public String getSelectedTipoHeroes() {
		return comboBoxHeroes.getSelectedItem().toString();
	}

	public void addBtnAñadirHeroesListener(ActionListener listener) {
		btnAñadirHeroes.addActionListener(listener);

	}

	public void addBtnEliminarHeroesListener(ActionListener listener) {
		btnEliminarHeroe.addActionListener(listener);
	}

	public String getTextFieldNombreHeroes() {
		return textFieldNombreHeroes.getText();

	}

	public int getTextFieldVidaHeroes() {
		return Integer.parseInt(textFieldVidaHeroes.getText());
	}

	public int getTextFieldArmaduraHeroes() {
		return Integer.parseInt(textFieldArmaduraHeroes.getText());
	}

	public String getTextFieldNombreBestias() {
		return textFieldNombreBestias.getText();
	}

	public int getTextFieldVidaBestias() {
		return Integer.parseInt(textFieldVidaBestias.getText());
	}

	public int getTextFieldArmaduraBestias() {
		return Integer.parseInt(textFieldArmaduraBestias.getText());
	}

	public String getSelectedTipoBestias() {
		return comboBoxBestias.getSelectedItem().toString();
	}

	public void addBtnAñadirBestiasListener(ActionListener listener) {
		btnAñadirBestias.addActionListener(listener);
	}

	public void addBtnEliminarBestiasListener(ActionListener listener) {
		btnEliminarBestia.addActionListener(listener);
	}

	public void addBtnJugarListener(ActionListener listener) {
		btnJugar.addActionListener(listener);
	}

	public senorAnillosVista(HeroesModelo modelo, BestiasModelo modeloBestias, JugarModelo jugarModelo) {
		super();
		initialize();
		Controlador controlador = new Controlador(modelo, modeloBestias, this, frmLaBatallaPor, jugarModelo);
	}

	public void actualizarTextAreaHeroes(List<PersonajeModelo> listaHeroes) {
		// Limpiamos el textArea

		textAreaHeroes.setText("");

		// Agregamos cada héroe al textArea

		for (PersonajeModelo heroe : listaHeroes) {
			textAreaHeroes.append(heroe.toString() + "\n");
		}
	}

	public void actualizarTextAreaBestias(List<PersonajeModelo> listaBestias) {
		// Limpiamos el textArea

		textAreaBestias.setText("");

		// Agregamos cada bestia al textArea.

		for (PersonajeModelo bestia : listaBestias) {
			textAreaBestias.append(bestia.toString() + "\n");
		}
	}

	public void actualizarTextAreaJugar(String texto) {

		// Agregamos el texto al textAreaJugar

		textAreaJugar.append(texto + "\n");
	}

	public Component getFrmLaBatallaPor() {
		return frmLaBatallaPor;
	}

	public void limpiarCamposHeroes() {
		textFieldNombreHeroes.setText("");
		textFieldVidaHeroes.setText("");
		textFieldArmaduraHeroes.setText("");
		comboBoxHeroes.setSelectedIndex(0);

	}

	public void limpiarCamposBestias() {
		textFieldNombreBestias.setText("");
		textFieldVidaBestias.setText("");
		textFieldArmaduraBestias.setText("");
		comboBoxHeroes.setSelectedIndex(0);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HeroesModelo modelo = new HeroesModelo("Nombre", 100, 50);
					BestiasModelo modeloBestias = new BestiasModelo("Nombre", 100, 50);
					JugarModelo jugarModelo = new JugarModelo(null);
					senorAnillosVista window = new senorAnillosVista(modelo, modeloBestias, jugarModelo);

					window.frmLaBatallaPor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public senorAnillosVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLaBatallaPor = new JFrame();
		frmLaBatallaPor.setTitle("La Batalla por la Tierra Media");
		frmLaBatallaPor.setBounds(100, 100, 1431, 520);
		frmLaBatallaPor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLaBatallaPor.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Heroes");
		lblNewLabel.setBounds(20, 20, 45, 13);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		frmLaBatallaPor.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(20, 45, 225, 193);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmLaBatallaPor.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(10, 10, 45, 13);
		panel.add(lblNewLabel_1);

		textFieldNombreHeroes = new JTextField();
		textFieldNombreHeroes.setBounds(86, 7, 96, 19);
		panel.add(textFieldNombreHeroes);
		textFieldNombreHeroes.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Tipo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setBounds(10, 48, 45, 13);
		panel.add(lblNewLabel_2);

		comboBoxHeroes = new JComboBox<String>();
		comboBoxHeroes.setBounds(86, 44, 96, 21);
		panel.add(comboBoxHeroes);
		comboBoxHeroes.addItem("Humano");
		comboBoxHeroes.addItem("Elfo");
		comboBoxHeroes.addItem("Hobbit");

		JLabel lblNewLabel_3 = new JLabel("Vida");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3.setBounds(10, 90, 45, 13);
		panel.add(lblNewLabel_3);

		textFieldVidaHeroes = new JTextField();
		textFieldVidaHeroes.setBounds(86, 87, 96, 19);
		panel.add(textFieldVidaHeroes);
		textFieldVidaHeroes.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Armadura");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4.setBounds(10, 126, 59, 13);
		panel.add(lblNewLabel_4);

		textFieldArmaduraHeroes = new JTextField();
		textFieldArmaduraHeroes.setBounds(86, 123, 96, 19);
		panel.add(textFieldArmaduraHeroes);
		textFieldArmaduraHeroes.setColumns(10);

		btnAñadirHeroes = new JButton("Añadir");
		btnAñadirHeroes.setBounds(10, 162, 205, 21);
		panel.add(btnAñadirHeroes);

		JLabel lblNewLabel_5 = new JLabel("Heroes");
		lblNewLabel_5.setBounds(297, 20, 45, 13);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		frmLaBatallaPor.getContentPane().add(lblNewLabel_5);

		textAreaHeroes = new JTextArea();
		textAreaHeroes.setEditable(false);
		textAreaHeroes.setBounds(295, 47, 290, 191);
		frmLaBatallaPor.getContentPane().add(textAreaHeroes);

		scrollPaneHeroes = new JScrollPane(textAreaHeroes);
		scrollPaneHeroes.setBounds(295, 47, 290, 191);
		frmLaBatallaPor.getContentPane().add(scrollPaneHeroes);

		lblNewLabel_6 = new JLabel("Bestias");
		lblNewLabel_6.setBounds(683, 20, 45, 13);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		frmLaBatallaPor.getContentPane().add(lblNewLabel_6);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(683, 45, 197, 193);
		frmLaBatallaPor.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel_7 = new JLabel("Nombre");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_7.setBounds(10, 10, 45, 13);
		panel_1.add(lblNewLabel_7);

		textFieldNombreBestias = new JTextField();
		textFieldNombreBestias.setBounds(75, 7, 96, 19);
		panel_1.add(textFieldNombreBestias);
		textFieldNombreBestias.setColumns(10);

		lblNewLabel_8 = new JLabel("Tipo");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8.setBounds(10, 41, 45, 13);
		panel_1.add(lblNewLabel_8);

		comboBoxBestias = new JComboBox<String>();
		comboBoxBestias.setBounds(75, 37, 96, 21);
		panel_1.add(comboBoxBestias);
		comboBoxBestias.addItem("Orco");
		comboBoxBestias.addItem("Trasgo");

		lblNewLabel_9 = new JLabel("Vida");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_9.setBounds(10, 79, 45, 13);
		panel_1.add(lblNewLabel_9);

		textFieldVidaBestias = new JTextField();
		textFieldVidaBestias.setBounds(75, 76, 96, 19);
		panel_1.add(textFieldVidaBestias);
		textFieldVidaBestias.setColumns(10);

		lblNewLabel_10 = new JLabel("Armadura");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_10.setBounds(10, 121, 61, 13);
		panel_1.add(lblNewLabel_10);

		textFieldArmaduraBestias = new JTextField();
		textFieldArmaduraBestias.setBounds(75, 118, 96, 19);
		panel_1.add(textFieldArmaduraBestias);
		textFieldArmaduraBestias.setColumns(10);

		btnAñadirBestias = new JButton("Añadir");
		btnAñadirBestias.setBounds(10, 162, 177, 21);
		panel_1.add(btnAñadirBestias);

		JLabel lblNewLabel_6_1 = new JLabel("Bestias");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_6_1.setBounds(950, 20, 45, 13);
		frmLaBatallaPor.getContentPane().add(lblNewLabel_6_1);

		textAreaBestias = new JTextArea();
		textAreaBestias.setEditable(false);
		textAreaBestias.setBounds(917, 45, 258, 193);
		frmLaBatallaPor.getContentPane().add(textAreaBestias);

		scrollPaneBestias = new JScrollPane(textAreaBestias);
		scrollPaneBestias.setBounds(917, 45, 258, 193);
		frmLaBatallaPor.getContentPane().add(scrollPaneBestias);

		btnEliminarHeroe = new JButton("Eliminar Heroe");
		btnEliminarHeroe.setBounds(1196, 65, 156, 68);
		frmLaBatallaPor.getContentPane().add(btnEliminarHeroe);

		btnEliminarBestia = new JButton("Eliminar Bestia");
		btnEliminarBestia.setBounds(1196, 153, 156, 68);
		frmLaBatallaPor.getContentPane().add(btnEliminarBestia);

		btnJugar = new JButton("Jugar");
		btnJugar.setBounds(105, 260, 1168, 21);
		frmLaBatallaPor.getContentPane().add(btnJugar);

		textAreaJugar = new JTextArea();
		textAreaJugar.setEditable(false);
		textAreaJugar.setBounds(20, 295, 1367, 178);
		frmLaBatallaPor.getContentPane().add(textAreaJugar);

		scrollPaneJugar = new JScrollPane(textAreaJugar);
		scrollPaneJugar.setBounds(20, 295, 1367, 178);
		frmLaBatallaPor.getContentPane().add(scrollPaneJugar);

	}
}
