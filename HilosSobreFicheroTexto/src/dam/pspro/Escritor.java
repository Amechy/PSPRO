package dam.pspro;

public class Escritor extends Thread {
	private ControladorFicheros destino;
	private String contenido = "";
	
	public Escritor (ControladorFicheros fich) {
		destino = fich;
	}
	
	public void fraseAdd(String cadena) {
		contenido += cadena;
	}
	
	@Override
	public void run() {
		destino.println(contenido);
	}
}
