package pspro;



public class Orden {
	
	boolean esMiTurno;
	public Orden() {
		super();
		this.esMiTurno = false;
		
	}
	public synchronized void Saludar(int hilo) {
	
		if (hilo == 2) {
			esMiTurno = true;
		}
		
		
		while(!esMiTurno) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println("Hola, soy el hilo: "+hilo);		
		notify();
	}
		
	

}



