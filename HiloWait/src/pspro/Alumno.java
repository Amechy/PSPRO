package pspro;

public class Alumno extends Thread{
	String nombre;
	Bienvenida saludo;
	
	public Alumno(String nombre, Bienvenida b) {
		super();
		this.nombre = nombre;
		this.saludo = b;
	}
	
	
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			saludo.saludarAlProfesor(this.nombre);
			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
			
	}
}
