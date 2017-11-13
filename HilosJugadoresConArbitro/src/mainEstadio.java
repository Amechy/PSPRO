
public class mainEstadio {

	public static void main(String[] args) {
		Arbitro arbitro = new Arbitro(4);
		Jugador j0 = new Jugador(0, arbitro);
		Jugador j1 = new Jugador(1, arbitro);
		Jugador j2 = new Jugador(2, arbitro);
		Jugador j3 = new Jugador(3, arbitro);
		Jugador j4 = new Jugador(4, arbitro);
		Jugador j5 = new Jugador(5, arbitro);
		Jugador j6 = new Jugador(6, arbitro);
		Jugador j7 = new Jugador(7, arbitro);
		Jugador j8 = new Jugador(8, arbitro);
		Jugador j9 = new Jugador(9, arbitro);
		Jugador j10 = new Jugador(10, arbitro);
		Jugador j11 = new Jugador(11, arbitro);
		Jugador j12 = new Jugador(12, arbitro);
		Jugador j13 = new Jugador(13, arbitro);
		Jugador j14 = new Jugador(14, arbitro);
		Jugador j15 = new Jugador(15, arbitro);
		
		j0.start();j1.start();j2.start();j3.start(); j4.start();j5.start();j6.start();j7.start();
		j8.start();j9.start();j10.start();j11.start(); j12.start();j13.start();j14.start();j15.start();
		try {
			j0.join();
			j1.join();
			j2.join();
			j3.join();
			j4.join();
			j5.join();
			j6.join();
			j7.join();
			j8.join();
			j9.join();
			j10.join();
			j11.join();
			j12.join();
			j13.join();
			j14.join();
			j15.join();
			
			
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("Hilo principal finalizado");

	}

}
