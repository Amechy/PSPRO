package pspro;

public class Bienvenida {
	private boolean comienzaLaClase;
	
	
	public  Bienvenida() {
		this.comienzaLaClase = false;
	}
	
	public synchronized void saludarAlProfesor(String alumno) {
		
		System.out.println("El alumno "+alumno+" quiere saludar");
		while (!comienzaLaClase) {
			try {
				this.wait();
				
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}			
		}
		System.out.println("El alumno "+alumno+" dice YEEEEEE!");
		
	}
	
	public synchronized void profesorSaluda() {
		System.out.println("El el profesor dice: VEnga que va oliendo a playaa");
		this.comienzaLaClase = true;
		this.notifyAll();
	}
	
}
