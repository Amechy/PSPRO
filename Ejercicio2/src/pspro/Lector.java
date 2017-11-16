package pspro;

public class Lector extends Thread {
	boolean monitor;
	Buffer b;
	int numAComprobar;
	
	public Lector(Buffer buffer, int numAComprobar, boolean sincronizado) {
		
		this.b = buffer;
		this.numAComprobar = numAComprobar;
		this.monitor = sincronizado;
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
				if (b.LeerMonitor(i, numAComprobar)) {
					System.out.println("Este es correcto");
				}
				else
				{
					System.out.println("Este es erróneo");
				}
			}else {
				if (b.LeerSinMonitor(i, numAComprobar)) {
					System.out.println("Este es correcto");
				}
				else
				{
					System.out.println("Este es erróneo");
				}
			}
			
		}
	}

}
