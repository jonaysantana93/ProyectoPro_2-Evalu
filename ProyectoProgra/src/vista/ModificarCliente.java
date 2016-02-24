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

public class ModificarCliente extends JDialog {
	private static final long serialVersionUID = 1L;
	private Clientes clienteModificado;
	private JTextField nombre;
	private JTextField codigoSocio;
	private JTextField dni;
	private JTextField teléfono;
	private JTextField dir;

	public ModificarCliente(Clientes temp) {
		getContentPane().setBackground(new Color(153, 204, 255));

		clienteModificado = temp;
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarCliente.class.getResource("/imagenes/modificar.jpg")));
		setBounds(100, 100, 427, 414);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		final JLabel cabecera = new JLabel("Modificar Cliente");
		cabecera.setHorizontalAlignment(SwingConstants.CENTER);
		cabecera.setForeground(new Color(0, 0, 153));
		cabecera.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 25));
		cabecera.setBounds(65, 7, 305, 61);
		getContentPane().add(cabecera);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 51, 255));
		separator.setForeground(new Color(153, 204, 255));
		separator.setBounds(34, 66, 360, 2);
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
		nombre.setBounds(175, 101, 220, 20);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		codigoSocio = new JTextField();
		codigoSocio.setColumns(10);
		codigoSocio.setBounds(175, 265, 220, 20);
		getContentPane().add(codigoSocio);
		
		dni = new JTextField();
		dni.setColumns(10);
		dni.setBounds(175, 142, 220, 20);
		getContentPane().add(dni);
		
		teléfono = new JTextField();
		teléfono.setColumns(10);
		teléfono.setBounds(175, 183, 220, 20);
		getContentPane().add(teléfono);
		
		dir = new JTextField();
		dir.setColumns(10);
		dir.setBounds(175, 224, 220, 20);
		getContentPane().add(dir);
		
		//llamamos al metodo para rellenar los campos 
		rellenarCampos();
		
		JButton modificar = new JButton("MODIFICAR");
		modificar.setBackground(new Color(51, 204, 0));
		modificar.setForeground(new Color(0, 102, 0));
		modificar.setBounds(86, 340, 111, 38);
		getContentPane().add(modificar);
		
		JButton atras = new JButton("ATR\u00C1S");
		atras.setBackground(new Color(255, 153, 204));
		atras.setForeground(new Color(255, 0, 0));
		atras.setBounds(212, 340, 111, 38);
		getContentPane().add(atras);
		
		//accion boton aceptar
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] entradas = {nombre.getText(), dni.getText(), teléfono.getText(), dir.getText(), codigoSocio.getText()};
				if (entradaValida(entradas)){
					clienteModificado.setNombre(nombre.getText());
					clienteModificado.setDni(dni.getText());
					clienteModificado.setTelefono(teléfono.getText());
					clienteModificado.setDireccion(dir.getText());
					clienteModificado.setCodigoSocio(codigoSocio.getText());
					
					actualizar(clienteModificado);
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
	
	//metodo para borrar cliente seleccionado y actualizar al nuevo modificado
	private void actualizar(Clientes modificado) {
		VistaClientes.listaClientes.remove(VistaClientes.temp);
		VistaClientes.listaClientes.add(modificado);
		VistaClientes.temp = VistaClientes.rellenar(
				VistaClientes.listaClientes.indexOf(clienteModificado),
				VistaClientes.nombre2, VistaClientes.dni2, VistaClientes.tlf2,
				VistaClientes.dir2, VistaClientes.cod2);
		ClientesFile.save(VistaClientes.listaClientes);
	}
	
	private void rellenarCampos(){
		nombre.setText(clienteModificado.getNombre());
		dni.setText(clienteModificado.getDni());
		teléfono.setText(clienteModificado.getTelefono());
		dir.setText(clienteModificado.getDireccion());
		codigoSocio.setText(clienteModificado.getCodigoSocio());
	}
}
