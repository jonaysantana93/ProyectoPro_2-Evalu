package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import modelo.PeliculasFile;
import controlador.Peliculas;



public class ModificarPelicula extends JDialog {
	private static final long serialVersionUID = 1L;
	private Peliculas peliculaModificado;
	private JTextField titulo;
	private JTextField director;
	private JTextField genero;
	private JTextField año;
	private JTextField pais;

	public ModificarPelicula(Peliculas temp) {
		getContentPane().setBackground(new Color(153, 204, 255));

		peliculaModificado = temp;
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarPelicula.class.getResource("/imagenes/modificar.jpg")));
		setBounds(100, 100, 427, 414);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		final JLabel cabecera = new JLabel("Modificar Pelicula");
		cabecera.setHorizontalAlignment(SwingConstants.CENTER);
		cabecera.setForeground(new Color(0, 0, 153));
		cabecera.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 25));
		cabecera.setBounds(65, 7, 305, 61);
		getContentPane().add(cabecera);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 51, 255));
		separator.setForeground(new Color(153, 255, 255));
		separator.setBounds(27, 66, 367, 2);
		getContentPane().add(separator);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setForeground(new Color(0, 51, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulo.setBounds(47, 94, 150, 30);
		getContentPane().add(lblTitulo);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setForeground(new Color(0, 51, 255));
		lblDirector.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDirector.setBounds(47, 135, 150, 30);
		getContentPane().add(lblDirector);
		
		JLabel Genero = new JLabel("Género");
		Genero.setForeground(new Color(0, 51, 255));
		Genero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Genero.setBounds(47, 176, 150, 30);
		getContentPane().add(Genero);
		
		JLabel Año = new JLabel("Año");
		Año.setForeground(new Color(0, 51, 255));
		Año.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Año.setBounds(47, 217, 150, 30);
		getContentPane().add(Año);
		
		JLabel lblPais = new JLabel("País");
		lblPais.setForeground(new Color(0, 51, 255));
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPais.setBounds(47, 258, 150, 30);
		getContentPane().add(lblPais);
		
		titulo = new JTextField();
		titulo.setBounds(175, 101, 220, 20);
		getContentPane().add(titulo);
		titulo.setColumns(10);
		
		director = new JTextField();
		director.setColumns(10);
		director.setBounds(175, 265, 220, 20);
		getContentPane().add(director);
		
		genero = new JTextField();
		genero.setColumns(10);
		genero.setBounds(175, 142, 220, 20);
		getContentPane().add(genero);
		
		año = new JTextField();
		año.setColumns(10);
		año.setBounds(175, 183, 220, 20);
		getContentPane().add(año);
		
		pais = new JTextField();
		pais.setColumns(10);
		pais.setBounds(175, 224, 220, 20);
		getContentPane().add(pais);
		
		//llamamos al metodo para rellenar los campos 
		rellenarCampos();
		
		JButton modificar = new JButton("MODIFICAR");
		modificar.setBackground(new Color(51, 204, 0));
		modificar.setForeground(new Color(0, 102, 0));
		modificar.setBounds(86, 340, 111, 38);
		getContentPane().add(modificar);
		
		JButton atras = new JButton("ATR\u00C1S");
		atras.setForeground(new Color(255, 0, 0));
		atras.setBackground(new Color(255, 153, 204));
		atras.setBounds(212, 340, 111, 38);
		getContentPane().add(atras);
		
		//accion boton aceptar
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] entradas = {titulo.getText(), genero.getText(), año.getText(), pais.getText(), director.getText()};
				if (entradaValida(entradas)){
					peliculaModificado.setTitulo(titulo.getText());
					peliculaModificado.setGenero(genero.getText());
					peliculaModificado.setYear(año.getText());
					peliculaModificado.setPais(pais.getText());
					peliculaModificado.setDirector(director.getText());
					
					actualizar(peliculaModificado);
					JOptionPane.showMessageDialog(null, "Se ha modificado con exito");
					dispose();
				} else {
					JOptionPane.showMessageDialog(cabecera, "Revise los campos, no pueden estar vacíos", "ERROR - Complete los campos", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//accion boton cancelar
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	//metodo que comprueba campos vacios
	private boolean entradaValida(Object[] entradas){
		int i = 0;
		boolean repetir = true;
		
		while (i < entradas.length && repetir){
			if (entradas[i].toString().isEmpty())
				repetir = false;
			else{
				i = i + 1;
			}
		}
		
		if (repetir == false)
			return false;
		else 
			return true;		
	}
	
	//metodo para borrar pelicula seleccionado y actualizar al nuevo modificado
	private void actualizar(Peliculas modificado) {
		VistaPeliculas.listaPeliculas.remove(VistaPeliculas.temp);
		VistaPeliculas.listaPeliculas.add(modificado);
		VistaPeliculas.temp = VistaPeliculas.rellenar(
				VistaPeliculas.listaPeliculas.indexOf(peliculaModificado),
				VistaPeliculas.tit2, VistaPeliculas.direct2, VistaPeliculas.gen2,
				VistaPeliculas.fec2, VistaPeliculas.pa2);
		PeliculasFile.save(VistaPeliculas.listaPeliculas);
	}
	
	private void rellenarCampos(){
		titulo.setText(peliculaModificado.getTitulo());
		genero.setText(peliculaModificado.getGenero());
		año.setText(peliculaModificado.getYear());
		pais.setText(peliculaModificado.getPais());
		director.setText(peliculaModificado.getDirector());
	}
}
