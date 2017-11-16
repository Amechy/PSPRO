package pspro;

public class Escritor extends Thread{
	boolean monitor;
	Buffer b;
	int numeroAEscribir;
	
	public Escritor(Buffer buffer, int numeroAEscribir, boolean sincronizado) {
		this.monitor = sincronizado;
		this.b = buffer;
		this.numeroAEscribir = numeroAEscribir;
	}


	
	
	
	@Override
	public void run() {
		for (int i = 0; i < b.bufer.length; i++) {
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (monitor) {
				b.EscribirMonitor(i,numeroAEscribir);
			}
			else
			{
				b.EscribirSinMonitor(i, numeroAEscribir);
			}
			
		}
	}

}
