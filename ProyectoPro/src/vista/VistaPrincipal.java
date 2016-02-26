package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VistaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	VistaClientes vc;
	VistaPeliculas vp;
	VistaAlquiler va;
	VistaAlquiler valq;
			//VistaAlquiler
	
	public void run() {
		vc = new VistaClientes(VistaPrincipal.this);
		vp = new VistaPeliculas(VistaPrincipal.this);
		setVisible(true);
	}
			
	public VistaPrincipal() {	
		setTitle("PROYECTO PROGRAMACI\u00D3N - Casa de coches");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaPrincipal.class.getResource("/imagenes/videoclub.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 222);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonCliente = new JButton("CLIENTES");
		botonCliente.setBackground(new Color(204, 255, 255));
		botonCliente.setForeground(new Color(0, 51, 255));
		botonCliente.setBounds(20, 148, 115, 36);
		botonCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(botonCliente);
		
		JButton botonPelicula = new JButton("PEL\u00CDCULAS");
		botonPelicula.setBackground(new Color(204, 255, 255));
		botonPelicula.setForeground(new Color(0, 51, 255));
		botonPelicula.setBounds(145, 148, 115, 36);
		botonPelicula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(botonPelicula);
		
		JButton botonAlquiler = new JButton("ALQUILER");
		botonAlquiler.setBackground(new Color(204, 255, 255));
		botonAlquiler.setForeground(new Color(0, 51, 255));
		botonAlquiler.setBounds(270, 148, 115, 36);
		botonAlquiler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(botonAlquiler);
		
		JButton botonSalir = new JButton("SALIR");
		botonSalir.setBackground(new Color(255, 153, 204));
		botonSalir.setForeground(new Color(255, 0, 0));
		botonSalir.setBounds(395, 148, 115, 36);
		botonSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(botonSalir);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(getClass().getResource("/imagenes/fondo2.png")));
		fondo.setBounds(0, 0, 537, 197);
		contentPane.add(fondo);

		//accion del boton clientes
		botonCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vc.setVisible(true);
				vc.setLocationRelativeTo(null);
				VistaPrincipal.this.setVisible(false);
			}
		});
		
		// accion del boton pelicula
		botonPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vp.setVisible(true);
				vp.setLocationRelativeTo(null);
				VistaPrincipal.this.setVisible(false);
			}
		});
		
		// accion del boton alquiler
		botonAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				valq = new VistaAlquiler(VistaClientes.temp, VistaPeliculas.temp);
				valq.setVisible(true);
			}
		});
				
		//accion del boton Salir
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
}
