package vista;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controlador.Clientes;
import controlador.Peliculas;

public class VistaAlquiler extends JDialog {
	private static final long serialVersionUID = 1L;
		
	public VistaAlquiler(final Clientes cliente, Peliculas pelicula) {

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1219, 447);
		getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(600, 0, 45, 519);
		getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("CLIENTE");
		lblNewLabel.setBounds(10, 11, 556, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPelicula = new JLabel("PELICULA");
		lblPelicula.setBounds(610, 11, 107, 14);
		getContentPane().add(lblPelicula);
		
		final JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.addItem(cliente);
		comboBox.setBounds(10, 36, 579, 27);
		getContentPane().add(comboBox);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>();
		comboBox_1.setBounds(610, 36, 560, 27);
		comboBox_1.addItem(pelicula);
		getContentPane().add(comboBox_1);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 123, 579, 202);
		textArea.setOpaque(false);
		textArea.setEditable(false);
		textArea.setMargin(new Insets(5,10,0,10));//<-- padding
		getContentPane().add(textArea);
		
		JButton registrarAlq = new JButton("Registrar alquiler");
		registrarAlq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		registrarAlq.setBounds(992, 74, 178, 27);
		getContentPane().add(registrarAlq);
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setMargin(new Insets(5, 10, 0, 10));
		textArea_1.setBounds(610, 123, 579, 202);
		textArea_1.setOpaque(false);
		textArea_1.setEditable(false);
		getContentPane().add(textArea_1);
		
		JButton mostrarAlq = new JButton("Mostrar alquileres del cliente");
		mostrarAlq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getItemAt(0) != null){
					try {
						String busqueda = cliente.getNombre();
						FileReader fr = new FileReader(new File("src\\modelo\\Alquiler.txt"));
						BufferedReader br = new BufferedReader(fr);
						String linea = "";
						while ((linea = br.readLine()) != null){
							if (linea.indexOf(busqueda) != -1){
								String[] l = linea.split("#");
								textArea.setText(l[0]);
								String peliculas = "";
								for (int i = 1; i< l.length; i++)
									peliculas = peliculas + l[i] + "\n";
								textArea_1.setText(peliculas);
							}
						}
						br.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "No hay cliente seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mostrarAlq.setBounds(838, 360, 245, 35);
		getContentPane().add(mostrarAlq);
		
		JButton atras = new JButton("atr\u00E1s");
		atras.setBounds(1093, 360, 89, 35);
		getContentPane().add(atras);
		
		//accion boton atrás
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

	}
}
