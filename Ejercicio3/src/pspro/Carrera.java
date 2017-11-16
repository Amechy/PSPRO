package pspro;


/**
 * 
 * @author Alejandro Mechiné
 *
 */
public class Carrera {
	boolean alguienCorriendo; //Nos dice si algun corredor está corriendo en ese momento, por lo que, si está a true, el relevo no estará disponible para otros corredores
	boolean haComenzado; // Nos dice si ha comenzado o no la carrera
	int corredor;

	public Carrera() {
		this.alguienCorriendo=false;
		this.haComenzado = false;
		this.corredor = 0;
		}

	
	public synchronized void Correr(int dorsal) {
		while ((alguienCorriendo || !haComenzado)&& dorsal != corredor) //El corredor no puede empezar a correr hasta que la carrera no haya empezado, sea su turno y el relevo esté libre. 
			
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		alguienCorriendo = true;
		System.out.println("\n\nEl corredor "+ dorsal +" ha cogido el relevo y empieza a correr...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		corredor ++;		
		System.out.println("El corredor con el dorsal "+dorsal+" ha terminado de correr y suelta el relevo.");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.alguienCorriendo = false;
		notify();
		
	}
	/**
	 * Método que avisa a los corredores que la carrera ha empezado.
	 */
	public synchronized void ComienzaLaCarrera() {
		haComenzado = true;
		notify(); //No utilizamos notifyAll() puesto que solo puede haber un corredor corriendo a la vez.
	}
}
