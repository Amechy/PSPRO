package pspro;



public class Buffer {
	int[] bufer = new int[10000];
	
	public synchronized int Leer(int pos) {
		return bufer[pos];		
		
		
	}
	public synchronized void Escribir(int numero, int pos) {
		bufer[pos] = numero;
	}
	
}
