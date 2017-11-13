import java.util.Random;

public class Arbitro {
	int numJug;
	int turno;
	int objetivo;	
	boolean acertado;	
	public int maximo = 100;
	
	public Arbitro(int nJugadores) {
		this.numJug = nJugadores;
		this.objetivo = (int)(Math.random()*maximo);
		this.turno = (int)(Math.random() * numJug);
		acertado = false;
		System.out.println("Numero a acerta: "+objetivo);
		
	}
	
	
	public int esTurnoDe() {		
		return turno;
	}
	public boolean seAcabo() {
		return acertado;
	}
	
	public  synchronized void jugar(int jugador, int jugada){
		while (jugador != turno && !acertado) {
			try {
				System.out.println("[PRE] Jugador "+ jugador + "y es turno de "+ turno);
				wait();
				System.out.println("[POST] Jugador "+ jugador + "y es turno de "+ turno);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (!acertado ) {
			System.out.println("El jugador " + turno+" Prueba con " + jugada);
			if (jugada==objetivo) {
				acertado = true;
				System.out.println("El jugador " + turno+" GANÓ");
			}else {
				turno = (turno +1)% numJug;
			}
		}
		notifyAll();
		
		
	}
}
