
public class mainEstadio {

	public static void main(String[] args) {
		Arbitro arbitro = new Arbitro(4);
		Jugador j0 = new Jugador(0, arbitro);
		Jugador j1 = new Jugador(1, arbitro);
		Jugador j2 = new Jugador(2, arbitro);
		Jugador j3 = new Jugador(3, arbitro);
		
		j0.start();j1.start();j2.start();j3.start();
		try {
			j0.join();
			j1.join();
			j2.join();
			j3.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("Hilo principal finalizado");

	}

}
