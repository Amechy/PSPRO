package pspro;


public class Cliente extends Thread{

	public Cliente(int nCliente, Caja[] cajas) {
		super();
		this.nCliente = nCliente;
		this.cajas = cajas;
	}

	int nCliente;
	int precioCompra;
	Caja[] cajas;
	int cajaQueMeHaTocado;
	long tiempoInicio,tiempoFin;
	long tiempoEspera;
	
	
	
	
	
	public void Comprar(){
		System.out.println("El cliente: "+nCliente+ " está comprando");
		try {
			sleep((int)(Math.random() * 2000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		precioCompra = (int)(Math.random() * 250)+1;
		System.out.println("El cliente "+nCliente+" termina de comprar");
		
	}
	
	private void EsperarCaja() {
		
		cajaQueMeHaTocado= GestionClientes.asignarCaja(cajas).idCaja;
		System.out.println("Al cliente "+nCliente+" le toca la caja "+cajaQueMeHaTocado+" para pagar");
	}
	
	@Override
	public void run() {
		Comprar();
		tiempoInicio = System.currentTimeMillis();
		EsperarCaja();
		tiempoFin = System.currentTimeMillis();
		tiempoEspera = tiempoFin-tiempoInicio;
		
		cajas[cajaQueMeHaTocado].Pagar(nCliente, precioCompra);
		
		
		
	}
}
