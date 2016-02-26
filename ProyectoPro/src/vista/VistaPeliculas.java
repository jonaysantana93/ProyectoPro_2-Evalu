package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import modelo.PeliculasFile;
import controlador.Lista;
import controlador.Peliculas;

public class VistaPeliculas extends JDialog {
	
	private static final long serialVersionUID = 1L;
	protected static Lista listaPeliculas;
	protected static int select;
	protected static Peliculas temp;
	protected static JLabel tit2;
	protected static JLabel direct2;
	protected static JLabel gen2;
	protected static JLabel fec2;
	protected static JLabel pa2;
	
	
	public VistaPeliculas(final VistaPrincipal parent) {
		getContentPane().setBackground(new Color(153, 204, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaPeliculas.class.getResource("/imagenes/cliente.jpg")));
		setTitle("PROYECTO DE PROGRAMACI\u00D3N - Peliculas");
		listaPeliculas = new Lista();
		select = -1;
		listaPeliculas = PeliculasFile.load();
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 360);
		getContentPane().setLayout(null);
		
		JButton buscar = new JButton("BUSCAR");
		buscar.setBackground(new Color(204, 255, 255));
		buscar.setForeground(new Color(0, 51, 255));
		buscar.setIcon(new ImageIcon(VistaPeliculas.class.getResource("/imagenes/buscar.jpg")));
		buscar.setBounds(297, 11, 128, 42);
		getContentPane().add(buscar);
		
		JButton nuevo = new JButton("A\u00D1ADIR");
		nuevo.setBackground(new Color(204, 255, 255));
		nuevo.setForeground(new Color(0, 51, 255));
		nuevo.setIcon(new ImageIcon(VistaPeliculas.class.getResource("/imagenes/nuevo.jpg")));
		nuevo.setBounds(297, 117, 128, 42);
		getContentPane().add(nuevo);
		
		JButton modificar = new JButton("MODIFICAR");
		modificar.setBackground(new Color(204, 255, 255));
		modificar.setForeground(new Color(0, 51, 255));
		modificar.setIcon(new ImageIcon(VistaPeliculas.class.getResource("/imagenes/modificar.jpg")));
		modificar.setBounds(297, 170, 128, 42);
		getContentPane().add(modificar);
		
		JButton borrar = new JButton("BORRAR");
		borrar.setBackground(new Color(204, 255, 255));
		borrar.setForeground(new Color(0, 51, 255));
		borrar.setIcon(new ImageIcon(VistaPeliculas.class.getResource("/imagenes/borrar.png")));
		borrar.setBounds(297, 223, 128, 42);
		getContentPane().add(borrar);
		
		JButton salir = new JButton("ATR\u00C1S");
		salir.setBackground(new Color(255, 153, 204));
		salir.setForeground(new Color(255, 0, 0));
		salir.setIcon(new ImageIcon(VistaPeliculas.class.getResource("/imagenes/salir.png")));
		salir.setBounds(297, 276, 128, 42);
		getContentPane().add(salir);
		
		JButton listado = new JButton("LISTADO");
		listado.setBackground(new Color(204, 255, 255));
		listado.setForeground(new Color(0, 51, 255));
		listado.setIcon(new ImageIcon(VistaPeliculas.class.getResource("/imagenes/listado.png")));
		listado.setBounds(297, 64, 128, 42);
		getContentPane().add(listado);

		// accion boton buscar
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuscarPelicula bp = new BuscarPelicula();
				bp.setVisible(true);
				bp.setLocationRelativeTo(null);
			}
		});

		// accion boton listado
		listado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarListadoPeliculas mp = new MostrarListadoPeliculas();
				mp.setVisible(true);
				mp.setLocationRelativeTo(null);
			}
		});

		// accion boton añadir
		nuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PeliculaNuevo pn = new PeliculaNuevo();
				pn.setVisible(true);
				pn.setLocationRelativeTo(null);
			}
		});

		// accion boton modificar
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (temp != null){
					ModificarPelicula mp = new ModificarPelicula(temp);
					mp.setVisible(true);
					mp.setLocationRelativeTo(null);
				} else
					JOptionPane.showMessageDialog(null, "No hay pelicula seleccionado");
			}
		});

		// accion del boton borrar
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (temp == null){
					JOptionPane.showMessageDialog(null, "No hay pelicula seleccionado");
				} else {
					int valor = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea borrar esta pelicula?", "Borrar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
					if (valor == JOptionPane.OK_OPTION) {
						listaPeliculas.remove(temp);
						PeliculasFile.save(listaPeliculas);
						rellenarVacio(tit2, direct2, gen2, fec2, pa2);
					}
				}
			}
		});

		// accion boton salir
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				parent.setVisible(true);
			}
		});

		JLabel peliculaActual = new JLabel("Pelicula actual");
		peliculaActual.setForeground(new Color(0, 51, 255));
		peliculaActual.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		peliculaActual.setHorizontalAlignment(SwingConstants.CENTER);
		peliculaActual.setBounds(21, 25, 266, 50);
		getContentPane().add(peliculaActual);
		
		JLabel tit1 = new JLabel("Titulo:");
		tit1.setForeground(new Color(0, 51, 255));
		tit1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tit1.setBounds(21, 101, 83, 31);
		getContentPane().add(tit1);
		
		JLabel direc1 = new JLabel("Director:");
		direc1.setForeground(new Color(0, 51, 255));
		direc1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		direc1.setBounds(21, 143, 83, 31);
		getContentPane().add(direc1);
		
		JLabel gen1 = new JLabel("Género:");
		gen1.setForeground(new Color(0, 51, 255));
		gen1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		gen1.setBounds(21, 185, 83, 31);
		getContentPane().add(gen1);
		
		JLabel fec1 = new JLabel("Año:");
		fec1.setForeground(new Color(0, 51, 255));
		fec1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fec1.setBounds(21, 227, 83, 31);
		getContentPane().add(fec1);
		
		JLabel pa1 = new JLabel("País:");
		pa1.setForeground(new Color(0, 51, 255));
		pa1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pa1.setBounds(21, 269, 120, 31);
		getContentPane().add(pa1);
		
		tit2 = new JLabel("");
		tit2.setBounds(87, 102, 188, 31);
		getContentPane().add(tit2);
	
		direct2 = new JLabel("");
		direct2.setBounds(87, 144, 200, 31);
		getContentPane().add(direct2);
		
		gen2 = new JLabel("");
		gen2.setBounds(87, 186, 200, 31);
		getContentPane().add(gen2);
		
		fec2 = new JLabel("");
		fec2.setBounds(87, 229, 200, 31);
		getContentPane().add(fec2);
		
		pa2 = new JLabel("");
		pa2.setBounds(87, 269, 167, 31);
		getContentPane().add(pa2);
		
		rellenarVacio(tit2, direct2, gen2, fec2, pa2);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 51, 255));
		separator.setBackground(new Color(51, 153, 255));
		separator.setBounds(21, 82, 266, 15);
		getContentPane().add(separator);

	}
	
	public static String listar(){
		String s = "";
		for (int i = 0; i < listaPeliculas.size(); i++){
			Peliculas p = (Peliculas)listaPeliculas.get(i);
			s = s + p + "\n";
		}
		return s;
	}	
	
	public static Peliculas rellenar(int select, JLabel tit2, JLabel direct2, JLabel gen2, JLabel fec2, JLabel pa2){
		Peliculas aux = (Peliculas)listaPeliculas.get(select);
		tit2.setText(aux.getTitulo());
		direct2.setText(aux.getDirector());
		gen2.setText(aux.getGenero());
		fec2.setText(aux.getYear());
		pa2.setText(aux.getPais());
		
		return aux;
	}
	
	public static void rellenarVacio(JLabel tit2, JLabel direct2, JLabel gen2, JLabel fec2, JLabel pa2){
		tit2.setText("");
		direct2.setText("");
		gen2.setText("");
		fec2.setText("");
		pa2.setText("");
	}
}
