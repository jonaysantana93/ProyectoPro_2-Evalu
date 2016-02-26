package vista;

import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MostrarListadoClientes extends JDialog {
	private static final long serialVersionUID = 1L;

	public MostrarListadoClientes() {
		setResizable(false);
		setTitle("PROYECTO DE PROGRAMACI\u00D3N - Listado de Clientes\r\n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MostrarListadoClientes.class.getResource("/imagenes/listado.png")));
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 831, 329);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 825, 304);
		JTextArea jt = new JTextArea(VistaClientes.listar());
		jt.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		jt.setMargin(new Insets(5,10,0,10));//<-- padding
		jt.setOpaque(false);
		jt.setEditable(false);
		scrollPane.setViewportView(jt);
		getContentPane().add(scrollPane);
	}
}
