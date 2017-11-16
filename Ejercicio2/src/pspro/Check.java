package pspro;

public class Check {
	
	public static void main(String[] args) {
		boolean sincronizado;
		int numeroElegido = 1;
		Buffer buffer = new Buffer();
		sincronizado = false;
		

			if (args[0].equals("1")) //Si se introduce el 1 como primer parámetro, se utilizará el método con Monitor
			{
				sincronizado = true;
			}
			
		
		
		
		
		Escritor escritor = new Escritor(buffer, numeroElegido, sincronizado);
		Lector lector = new Lector(buffer, numeroElegido, sincronizado);
		
		
		
		escritor.start();
		lector.start();
		
		
		
		
		try {
			lector.join();
			escritor.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Termina hilo principal");
	}
	
	
	
	
}
