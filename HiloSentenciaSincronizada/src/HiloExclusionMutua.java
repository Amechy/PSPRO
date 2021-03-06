
class DatoCompartido{
	public static int c1 = 0;
	public static int c2 = 0;
	
	private static final Object mutex1 = new Object();
	private static final Object mutex2 = new Object();
	
	
	public static void incrementarC1() {
		//SC 1
		synchronized (mutex1) {
			c1++;	
		}
		
		//Fin Sc 1
	}
	public static void incrementarC2() {
		//SC 2
		synchronized (mutex2) {
			c2++;
		}
		
		//Fin SC 2
	}
}
class HilosMutex extends Thread{
	@Override
	public void run() {
		DatoCompartido.incrementarC1();
		DatoCompartido.incrementarC2();
	}
}

public class HiloExclusionMutua {

	public static void main(String[] args) throws InterruptedException {
		
		int N = Integer.parseInt(args[0]);
		
		HilosMutex hilos[];
		System.out.println("Creando "+N+" Hilos");
		
		hilos = new HilosMutex[N];
		for (int i = 0; i < N; i++) {
			hilos[i] = new HilosMutex();
			hilos[i].start();
		}
		for (int i = 0; i < N; i++) {
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("C1 = "+ DatoCompartido.c1);
		System.out.println("C2 = "+ DatoCompartido.c2);

	}

}
