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
	int cajaElegida;
	
	
	
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
	
	private void ElegirCaja() {
		
		cajaElegida= (int)(Math.random()*cajas.length);
		System.out.println("El cliente "+nCliente+" elige la caja "+cajaElegida+" para pagar");
	}
	
	@Override
	public void run() {
		Comprar();
		ElegirCaja();
		
		cajas[cajaElegida].Pagar(nCliente, precioCompra);
		
		
	}
}
