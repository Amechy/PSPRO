package hilosSincronizados;

class Inutil{
	private int a = 0;
	private int b = 0;
	public synchronized void marcar_5() {
		a = 5;
		System.out.println("Marcando no me metas buya");
		b=5;
	}
	public synchronized boolean esVerdad() {
		return a == 0 || b == 5;
	}
	
}

class HiloA extends Thread{
	private Inutil i;
	public HiloA (Inutil in) {
		this.i = in;
	}
	@Override
	public void run() {
		i.marcar_5();
		super.run();
	}
	
}
class HiloB extends Thread{
	private Inutil i;
	public HiloB (Inutil in) {
		this.i = in;
	}
	@Override
	public void run() {
		if(i.esVerdad()) {
			System.out.println("Verdadero");
		}else {
			System.out.println("Más falso que tu cara");
		}
	}
	
}

public class HilosSincronizados {
	public static void main(String[] args) {
		Inutil in = new Inutil();
		HiloA ha = new HiloA(in);
		HiloB hb = new HiloB(in);
		ha.start();
		hb.start();
		try {
			ha.join();
			hb.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}
