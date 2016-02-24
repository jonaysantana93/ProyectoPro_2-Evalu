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

import modelo.ClientesFile;
import controlador.Clientes;

public class ClienteNuevo extends JDialog {
	private static final long serialVersionUID = 1L;
	public Clientes nuevoCliente;
	private JTextField nombre;
	private JTextField codigoSocio;
	private JTextField dni;
	private JTextField teléfono;
	private JTextField dir;

	public ClienteNuevo() {
		getContentPane().setBackground(new Color(153, 204, 255));

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClienteNuevo.class.getResource("/imagenes/nuevo.jpg")));
		setBounds(100, 100, 366, 414);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		final JLabel cabecera = new JLabel("Cliente nuevo");
		cabecera.setHorizontalAlignment(SwingConstants.CENTER);
		cabecera.setForeground(new Color(0, 0, 153));
		cabecera.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 25));
		cabecera.setBounds(20, 11, 305, 61);
		getContentPane().add(cabecera);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(102, 153, 255));
		separator.setForeground(new Color(0, 51, 255));
		separator.setBounds(25, 66, 305, 2);
		getContentPane().add(separator);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(0, 51, 255));
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(47, 94, 150, 30);
		getContentPane().add(lblNombre);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setForeground(new Color(0, 51, 255));
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(47, 135, 150, 30);
		getContentPane().add(lblDni);
		
		JLabel telefono = new JLabel("Tel\u00E9fono");
		telefono.setForeground(new Color(0, 51, 255));
		telefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		telefono.setBounds(47, 176, 150, 30);
		getContentPane().add(telefono);
		
		JLabel direccion = new JLabel("Direcci\u00F3n");
		direccion.setForeground(new Color(0, 51, 255));
		direccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		direccion.setBounds(47, 217, 150, 30);
		getContentPane().add(direccion);
		
		JLabel lblCdigoDeSocio = new JLabel("C\u00F3digo de socio");
		lblCdigoDeSocio.setForeground(new Color(0, 51, 255));
		lblCdigoDeSocio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigoDeSocio.setBounds(47, 258, 150, 30);
		getContentPane().add(lblCdigoDeSocio);
		
		nombre = new JTextField();
		nombre.setBounds(175, 101, 150, 20);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		codigoSocio = new JTextField();
		codigoSocio.setColumns(10);
		codigoSocio.setBounds(175, 265, 150, 20);
		getContentPane().add(codigoSocio);
		
		dni = new JTextField();
		dni.setColumns(10);
		dni.setBounds(175, 142, 150, 20);
		getContentPane().add(dni);
		
		teléfono = new JTextField();
		teléfono.setColumns(10);
		teléfono.setBounds(175, 183, 150, 20);
		getContentPane().add(teléfono);
		
		dir = new JTextField();
		dir.setColumns(10);
		dir.setBounds(175, 224, 150, 20);
		getContentPane().add(dir);
		
		JButton aceptar = new JButton("ACEPTAR");
		aceptar.setBackground(new Color(51, 204, 0));
		aceptar.setForeground(new Color(0, 102, 0));
		aceptar.setBounds(61, 340, 111, 38);
		getContentPane().add(aceptar);
		
		JButton atras = new JButton("ATR\u00C1S");
		atras.setBackground(new Color(255, 153, 204));
		atras.setForeground(new Color(255, 0, 0));
		atras.setBounds(182, 340, 111, 38);
		getContentPane().add(atras);
		
		//accion boton aceptar
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] entradas = {nombre.getText(), dni.getText(), teléfono.getText(), dir.getText(), codigoSocio.getText()};
				if (entradaValida(entradas)){
					nuevoCliente = new Clientes();
					nuevoCliente.setNombre(nombre.getText());
					nuevoCliente.setDni(dni.getText());
					nuevoCliente.setTelefono(teléfono.getText());
					nuevoCliente.setDireccion(dir.getText());
					nuevoCliente.setCodigoSocio(codigoSocio.getText());
					
					actualizar(nuevoCliente);
					JOptionPane.showMessageDialog(null, "Se ha creado con exito");
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
	
	//metodo que hace diferentes acciones sobre la lista
	private void actualizar(Clientes nuevo) {
		VistaClientes.listaClientes.add(nuevoCliente);
		// VistaClientes.select = VistaClientes.listaClientes.indexOf(nuevoCliente);
		VistaClientes.temp = VistaClientes.rellenar(
				VistaClientes.listaClientes.indexOf(nuevoCliente),
				VistaClientes.nombre2, VistaClientes.dni2, VistaClientes.tlf2,
				VistaClientes.dir2, VistaClientes.cod2);
		ClientesFile.save(VistaClientes.listaClientes);
	}
}


