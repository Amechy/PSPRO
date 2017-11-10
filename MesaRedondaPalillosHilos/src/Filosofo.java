

public class Filosofo implements Runnable {
	public Filosofo(int sitio, int nVeces) {
		super();
		this.asiento = sitio;
		this.veces = nVeces;
	}
	int pIzq, pDer;
	int asiento;
	int veces;
	@Override
	public void run() {
		for (int i = 0; i < veces; i++) {
			Pensar();
			CogerPalillos();
			Comer();
			SoltarPalillos();
		}
	}
	
	public void Pensar() {
		try {
			Thread.sleep((int)Math.random()*3000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
	public synchronized void CogerPalillos(){
		
	}
	public void Comer() {
		
	}	
	public void SoltarPalillos() {
		
	}
	
	

}
