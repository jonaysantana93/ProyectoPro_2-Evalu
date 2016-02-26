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

import modelo.ClientesFile;
import controlador.Clientes;
import controlador.Lista;

public class VistaClientes extends JDialog {
	
	private static final long serialVersionUID = 1L;
	protected static Lista listaClientes;
	protected static int select;
	protected static Clientes temp;
	protected static JLabel nombre2;
	protected static JLabel dni2;
	protected static JLabel tlf2;
	protected static JLabel dir2;
	protected static JLabel cod2;
	
	
	public VistaClientes(final VistaPrincipal parent) {
		getContentPane().setBackground(new Color(153, 204, 255));
		setBackground(new Color(0, 51, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaClientes.class.getResource("/imagenes/cliente.jpg")));
		setTitle("PROYECTO DE PROGRAMACI\u00D3N - Clientes");
		listaClientes = new Lista();
		select = -1;
		listaClientes = ClientesFile.load();
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 360);
		getContentPane().setLayout(null);
		
		JButton buscar = new JButton("BUSCAR");
		buscar.setBackground(new Color(204, 255, 255));
		buscar.setForeground(new Color(0, 51, 255));
		buscar.setIcon(new ImageIcon(VistaClientes.class.getResource("/imagenes/buscar.jpg")));
		buscar.setBounds(297, 11, 128, 42);
		getContentPane().add(buscar);
		
		JButton nuevo = new JButton("A\u00D1ADIR");
		nuevo.setBackground(new Color(204, 255, 255));
		nuevo.setForeground(new Color(0, 51, 255));
		nuevo.setIcon(new ImageIcon(VistaClientes.class.getResource("/imagenes/nuevo.jpg")));
		nuevo.setBounds(297, 117, 128, 42);
		getContentPane().add(nuevo);
		
		JButton modificar = new JButton("MODIFICAR");
		modificar.setBackground(new Color(204, 255, 255));
		modificar.setForeground(new Color(0, 51, 255));
		modificar.setIcon(new ImageIcon(VistaClientes.class.getResource("/imagenes/modificar.jpg")));
		modificar.setBounds(297, 170, 128, 42);
		getContentPane().add(modificar);
		
		JButton borrar = new JButton("BORRAR");
		borrar.setBackground(new Color(204, 255, 255));
		borrar.setForeground(new Color(0, 51, 255));
		borrar.setIcon(new ImageIcon(VistaClientes.class.getResource("/imagenes/borrar.png")));
		borrar.setBounds(297, 223, 128, 42);
		getContentPane().add(borrar);
		
		JButton salir = new JButton("ATR\u00C1S");
		salir.setBackground(new Color(255, 153, 204));
		salir.setForeground(new Color(255, 0, 0));
		salir.setIcon(new ImageIcon(VistaClientes.class.getResource("/imagenes/salir.png")));
		salir.setBounds(297, 276, 128, 42);
		getContentPane().add(salir);
		
		JButton listado = new JButton("LISTADO");
		listado.setBackground(new Color(204, 255, 255));
		listado.setForeground(new Color(0, 51, 255));
		listado.setIcon(new ImageIcon(VistaClientes.class.getResource("/imagenes/listado.png")));
		listado.setBounds(297, 64, 128, 42);
		getContentPane().add(listado);

		// accion boton buscar
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuscarCliente bc = new BuscarCliente();
				bc.setVisible(true);
				bc.setLocationRelativeTo(null);
			}
		});

		// accion boton listado
		listado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarListadoClientes mc = new MostrarListadoClientes();
				mc.setVisible(true);
				mc.setLocationRelativeTo(null);
			}
		});

		// accion boton añadir
		nuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteNuevo cn = new ClienteNuevo();
				cn.setVisible(true);
				cn.setLocationRelativeTo(null);
			}
		});

		// accion boton modificar
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (temp != null){
					ModificarCliente mc = new ModificarCliente(temp);
					mc.setVisible(true);
					mc.setLocationRelativeTo(null);
				} else
					JOptionPane.showMessageDialog(null, "No hay cliente seleccionado");
			}
		});

		// accion del boton borrar
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (temp == null){
					JOptionPane.showMessageDialog(null, "No hay cliente seleccionado");
				} else {
					int valor = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea borrar este cliente?", "Borrar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
					if (valor == JOptionPane.OK_OPTION) {
						listaClientes.remove(temp);
						ClientesFile.save(listaClientes);
						rellenarVacio(nombre2, dni2, tlf2, dir2, cod2);
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

		JLabel clienteActual = new JLabel("Cliente actual");
		clienteActual.setForeground(new Color(0, 0, 153));
		clienteActual.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		clienteActual.setHorizontalAlignment(SwingConstants.CENTER);
		clienteActual.setBounds(21, 25, 266, 50);
		getContentPane().add(clienteActual);
		
		JLabel nombre1 = new JLabel("Nombre:");
		nombre1.setForeground(new Color(0, 51, 255));
		nombre1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nombre1.setBounds(21, 101, 83, 31);
		getContentPane().add(nombre1);
		
		JLabel dni1 = new JLabel("DNI:");
		dni1.setForeground(new Color(0, 51, 255));
		dni1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dni1.setBounds(21, 143, 83, 31);
		getContentPane().add(dni1);
		
		JLabel tlf1 = new JLabel("Tel\u00E9fono:");
		tlf1.setForeground(new Color(0, 51, 255));
		tlf1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tlf1.setBounds(21, 185, 83, 31);
		getContentPane().add(tlf1);
		
		JLabel dir1 = new JLabel("Direcci\u00F3n:");
		dir1.setForeground(new Color(0, 51, 255));
		dir1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dir1.setBounds(21, 227, 83, 31);
		getContentPane().add(dir1);
		
		JLabel cod1 = new JLabel("C\u00F3digo de Socio:");
		cod1.setForeground(new Color(0, 51, 255));
		cod1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cod1.setBounds(21, 269, 120, 31);
		getContentPane().add(cod1);
		
		nombre2 = new JLabel("");
		nombre2.setBounds(87, 102, 188, 31);
		getContentPane().add(nombre2);
	
		dni2 = new JLabel("");
		dni2.setBounds(87, 144, 200, 31);
		getContentPane().add(dni2);
		
		tlf2 = new JLabel("");
		tlf2.setBounds(87, 186, 200, 31);
		getContentPane().add(tlf2);
		
		dir2 = new JLabel("");
		dir2.setBounds(87, 229, 200, 31);
		getContentPane().add(dir2);
		
		cod2 = new JLabel("");
		cod2.setBounds(132, 270, 167, 31);
		getContentPane().add(cod2);
		
		rellenarVacio(nombre2, dni2, tlf2, dir2, cod2);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBackground(new Color(51, 153, 255));
		separator.setBounds(21, 82, 266, 15);
		getContentPane().add(separator);

	}
	
	public static String listar(){
		String s = "";
		for (int i = 0; i < listaClientes.size(); i++){
			Clientes c = (Clientes)listaClientes.get(i);
			s = s + c + "\n";
		}
		return s;
	}	
	
	public static Clientes rellenar(int select, JLabel nombre2, JLabel dni2, JLabel tlf2, JLabel dir2, JLabel cod2){
		Clientes aux = (Clientes)listaClientes.get(select);
		nombre2.setText(aux.getNombre());
		dni2.setText(aux.getDni());
		tlf2.setText(aux.getTelefono());
		dir2.setText(aux.getDireccion());
		cod2.setText(aux.getCodigoSocio());
		
		return aux;
	}
	
	public static void rellenarVacio(JLabel nombre2, JLabel dni2, JLabel tlf2, JLabel dir2, JLabel cod2){
		nombre2.setText("");
		dni2.setText("");
		tlf2.setText("");
		dir2.setText("");
		cod2.setText("");
	}
}
