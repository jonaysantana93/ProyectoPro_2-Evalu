package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.Peliculas;



public class BuscarPelicula extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField textoBusqueda;

	public BuscarPelicula() {
		getContentPane().setBackground(new Color(0, 204, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscarPelicula.class.getResource("/imagenes/buscar.jpg")));
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 796, 208);
		getContentPane().setLayout(null);
		
		final JComboBox<Object> comboBox = new JComboBox<Object>();
		
		comboBox.setBounds(10, 66, 759, 31);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Introduzca su b\u00FAsqueda");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(57, 25, 254, 23);
		getContentPane().add(lblNewLabel);
		
		textoBusqueda = new JTextField();
		textoBusqueda.setBounds(227, 27, 313, 23);
		getContentPane().add(textoBusqueda);
		textoBusqueda.setColumns(10);
		
		JButton botonBuscar = new JButton("BUSCAR");
		botonBuscar.setBackground(new Color(204, 255, 255));
		botonBuscar.setForeground(new Color(0, 51, 255));
		botonBuscar.setBounds(557, 27, 154, 23);
		getContentPane().add(botonBuscar);
		
		JButton botonAtras = new JButton("ATR\u00C1S");
		botonAtras.setForeground(new Color(255, 0, 0));
		botonAtras.setBackground(new Color(255, 153, 204));
		botonAtras.setBounds(647, 124, 114, 31);
		getContentPane().add(botonAtras);
		
		JButton botonElegir = new JButton("ACEPTAR");
		botonElegir.setBackground(new Color(51, 204, 0));
		botonElegir.setForeground(new Color(0, 102, 0));
		botonElegir.setBounds(399, 124, 114, 31);
		getContentPane().add(botonElegir);
		
		JButton botonReset = new JButton("RESETEAR");
		botonReset.setBackground(new Color(204, 255, 255));
		botonReset.setForeground(new Color(0, 51, 255));
		botonReset.setBounds(523, 124, 114, 31);
		getContentPane().add(botonReset);
		
		//acción boton buscar
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String busqueda = textoBusqueda.getText();
				Object[] lista = VistaPeliculas.listaPeliculas.get(busqueda);
				for (int i = 0; i < lista.length; i++){
					comboBox.addItem(lista[i]);
				}
			}
		});
		
		//accion boton aceptar
		botonElegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Peliculas aux = (Peliculas) comboBox.getSelectedItem();
					VistaPeliculas.temp = VistaPeliculas.rellenar(
							VistaPeliculas.listaPeliculas.indexOf(aux),
							VistaPeliculas.tit2, VistaPeliculas.direct2,
							VistaPeliculas.gen2, VistaPeliculas.fec2,
							VistaPeliculas.pa2);
					dispose();
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(getParent(), "Ha ocurrido un error. Vuelva a intentarlo", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//accion boton resetear
		botonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textoBusqueda.setText("");
				comboBox.removeAllItems();
			}
		});
		
		//accion boton atras
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}