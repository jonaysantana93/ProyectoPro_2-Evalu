package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import controlador.Clientes;
import controlador.Lista;

public class ClientesFile {
	private static final String filename = "src\\modelo\\Clientes.txt";
	
	public static Lista load(){
		Lista l = new Lista();
		try {
			File f = new File(filename);
			if (f.exists()) {
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);

				String linea;
				boolean seguir = true;
				do {
					Clientes c = new Clientes();
					linea = br.readLine();
					if (linea != null) {
						c.setNombre(linea);
						c.setDni(br.readLine());
						c.setTelefono(br.readLine());
						c.setDireccion(br.readLine());
						c.setCodigoSocio(br.readLine());
						l.add(c);
					} else
						seguir = false;
				} while (seguir);
				br.close();
				fr.close();
			}
			return l;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean save(Lista l) {

		try {
			FileWriter fw = new FileWriter(filename);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < l.size(); i++) {
				Clientes c = (Clientes) l.get(i);
				bw.write(c.getNombre());
				bw.newLine();
				bw.write(c.getDni());
				bw.newLine();
				bw.write(c.getTelefono());
				bw.newLine();
				bw.write(c.getDireccion());
				bw.newLine();
				bw.write(c.getCodigoSocio());
				bw.newLine();
			}
			bw.flush();
			bw.close();
			fw.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}