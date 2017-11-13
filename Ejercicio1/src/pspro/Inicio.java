package pspro;

public class Inicio {

	public static void main(String[] args) {
		Orden orden = new Orden();
		
		Hilo hilo1 = new Hilo(1, orden);
		Hilo hilo2 = new Hilo(2, orden);
		
	
		

		hilo1.start();		
		hilo2.start();
		
		try {
			hilo1.join();
			hilo2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
