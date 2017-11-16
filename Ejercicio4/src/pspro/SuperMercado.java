package pspro;

public class SuperMercado {

	public static void main(String[] args) {
		int nCajas;
		int nClientes;
		int dineroRecaudado = 0;
		Caja cajas[];
		Cliente clientes[];
		
		try {
			nCajas = Integer.parseInt(args[0]);//Número de cajas
			nClientes = Integer.parseInt(args[1]);//Número de clientes
			
			cajas = new Caja[nCajas];
			clientes = new Cliente[nClientes];
			
			
			for (int i = 0; i < cajas.length; i++) {
				cajas[i]=new Caja(i);
			}
			for (int i = 0; i < clientes.length; i++) {
				clientes[i] = new Cliente(i,cajas);
				clientes[i].start();
			}
			
			for (int i = 0; i < clientes.length; i++) {
				
				try {
					clientes[i].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for (int i = 0; i < cajas.length; i++) {
				dineroRecaudado += cajas[i].totalAcumulado;
			}
			
			System.out.println("\n\nEl dinero recaudado del dia ha sido: "+dineroRecaudado+ " €");
			
			System.out.println("Termina el hilo principal");
		} catch (Exception e) {
			System.out.println("Debe introducir al menos dos parámetros que sean números, \nel primero el número de cajas y el segundo el número de clientes");
		}
		
		
		

	}

}
