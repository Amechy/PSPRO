package pspro;

public class Buffer{
	int[] bufer = new int[10];

	

	int posEscritor = 0;
	int posLector = 0;

	public synchronized boolean LeerMonitor(int pos, int numAComprobar) {
		boolean sonIguales = true;
		posLector = pos;

		while (posEscritor < posLector||posEscritor==0) {
			try {
				System.out.println("Hilo lector esperando");
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (bufer[pos] != numAComprobar) {
			sonIguales = false;
		}		
		
		return sonIguales;

	}
	public synchronized void EscribirMonitor(int pos, int numero) {		
		if (pos <= this.bufer.length) {
			bufer[pos] = numero;
			posEscritor = pos;		
			notify();
		}
		

	}
	
	

	public void EscribirSinMonitor(int pos, int numero) {
		if (pos <= this.bufer.length) {
			bufer[pos] = numero;
			posEscritor = pos;		
		}
		

	}
	
	public boolean LeerSinMonitor(int pos, int numAComprobar) {
		boolean sonIguales = true;
		posLector = pos;

		if (posLector < posEscritor||posEscritor==0) {

			if (bufer[pos] != numAComprobar) {
				sonIguales = false;
			}		
		}

		return sonIguales;

	}

	


}
