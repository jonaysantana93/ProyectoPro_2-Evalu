package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import controlador.Lista;
import controlador.Peliculas;

public class PeliculasFile {
	private static final String filename = "src\\modelo\\Peliculas.txt";
	
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
					Peliculas p = new Peliculas();
					linea = br.readLine();
					if (linea != null) {
						p.setTitulo(linea);
						p.setDirector(br.readLine());
						p.setGenero(br.readLine());
						p.setYear(br.readLine());
						p.setPais(br.readLine());
						l.add(p);
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
				Peliculas p = (Peliculas) l.get(i);
				bw.write(p.getTitulo());
				bw.newLine();
				bw.write(p.getDirector());
				bw.newLine();
				bw.write(p.getGenero());
				bw.newLine();
				bw.write(p.getYear());
				bw.newLine();
				bw.write(p.getPais());
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