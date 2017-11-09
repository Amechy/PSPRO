
public class Jugador extends Thread {
	int dorsal;
	Arbitro arbitro;
	public Jugador(int elDorsal, Arbitro elArbitro) {
		this.dorsal = elDorsal;
		this.arbitro = elArbitro;
		
	}
	@Override
	public void run() {
		while (!arbitro.seAcabo()) {
			arbitro.jugar(this.dorsal, 1+ (int)(arbitro.maximo * Math.random()) );
		}
		System.out.println("El jugador "+dorsal+" ha dejado de jugar");
	}
}
