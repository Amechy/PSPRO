
public class SimulacionCena {

	public static void main(String[] args) {
		int comensales  = Integer.parseInt(args[0]);
		int nVeces = Integer.parseInt(args[1]);
		Cena cena = new Cena(comensales);
		for (int i = 0; i < nVeces; i++) {
			new Filosofo(i, , nVeces);
		}

	}

}
