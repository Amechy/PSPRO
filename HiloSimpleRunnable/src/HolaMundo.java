
class HiloHolaMundo implements Runnable{

    Thread hilo;
	HiloHolaMundo(){
		hilo = new Thread(this, "Nuevo hilo creado");		
		System.out.println("Creando hilo nuevoo..."+hilo);
		
		hilo.start();
	}
	
	//Este método es para que el hilo hijo nunca acabe despues del padre
	 
	public void Espera() {
		try {
			hilo.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		System.out.println("Hilo nuevo ha empezado a ejecutarse");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hilo finalizando");
		
		
	}
	
}
public class HolaMundo {
	public static void main(String[] args) {
		System.out.println("Hola desde el hilo principal(main)");
		HiloHolaMundo ejemploHilo = new HiloHolaMundo();
		ejemploHilo.Espera();
		
		
		System.out.println("Hilo principal main finalizando...");
		
	}
}
