package pspro;


/**
 * Clase que instancia una carrera e inicia varios corredores. Tiene un contador de 5 segundos para que empieze la carrera.
 * @author Alejandro Mechiné Gamarra
 *
 */
public class Relevos {
	
	
	public static void main(String[] args) {
		Carrera carrera = new Carrera();
		int segundos = 5;
		Corredor c1,c2,c3,c4;
		
		
		c1 = new Corredor(1, carrera);
		c2 = new Corredor(2, carrera);
		c3 = new Corredor(3, carrera);
		c4 = new Corredor(4, carrera);
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		System.out.println("La carrera empezará en: ");
		for (int i = segundos; i > 0; i--) {
			
			System.out.println("			"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		carrera.ComienzaLaCarrera();
		
		try {
			c1.join();
			c2.join();
			c3.join();
			c4.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println("\n\nEl último corredor ha llegado con el relevo en la meta.");
		
	}

}
