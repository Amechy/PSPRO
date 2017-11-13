package pspro;

/**
 * 
 * @author amechy
 *
 */
public class Hilo extends Thread {
	Orden orden;
	int turno; 
	
	
	public Hilo(int tur, Orden o) {
		this.orden = o;
		this.turno = tur;
	}
	
	
	
	



	@Override
	public void run() {
		orden.Saludar(turno);
			
		
	}


}
