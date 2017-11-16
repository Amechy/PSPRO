package pspro;

public class Corredor extends Thread {
	public Corredor(int dorsal, Carrera carrera) {
		this.nCorredor = dorsal;
		this.unaCarrera = carrera;
	}


	int nCorredor;
	Carrera unaCarrera;
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		unaCarrera.Correr(nCorredor);
		
	}
}
