package pspro;


public class Caja {
	
	public Caja(int idCaja){
		this.idCaja = idCaja;
		ocupada = false;
		totalAcumulado = 0;
	}
	int idCaja;
	boolean ocupada;
	int totalAcumulado;
	
	
	public synchronized void Pagar(int nCliente, int precioCompra) {
		System.out.println("El cliente " +nCliente+" se acerca a la caja "+idCaja);
		while (ocupada) {
			System.out.println("Pero la caja "+idCaja+" está ocupada, el cliente "+nCliente+"tiene que esperar");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ocupada = true;
		System.out.println("El cliente "+nCliente+" está pagando en la caja "+idCaja+" un total de: " +precioCompra+" €");
		totalAcumulado += precioCompra;
		
		System.out.println("La caja "+idCaja+" está libre");
		ocupada = false;
		notifyAll();
		
	}
	
	
	
}
