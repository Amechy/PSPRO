package dam.pspro;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ControladorFicheros {
	private PrintWriter fichero;
	
	
	public ControladorFicheros(String nomFichero) {
		try {
			
			fichero = new PrintWriter(new FileWriter(nomFichero));
		} catch (IOException e) {
			System.err.println("Error al crear el fichero: "+ e.getMessage());
		}
	}
	
	public synchronized void print(String cadena) {
		
		for (int i = 0; i < cadena.charAt(i); i++) {
			fichero.print(cadena.charAt(i));
		}	
	}
	
	public synchronized void println(String cadena) {
		this.print(cadena);
		fichero.println();
	}
	public void close() {
		fichero.close();
	}
	
}
